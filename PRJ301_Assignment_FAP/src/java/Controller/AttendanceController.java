/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.AttendanceDB;
import DAO.SessionDB;
import Entity.Attendance;
import Entity.Session;
import Entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class AttendanceController extends HttpServlet {
   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int seid = Integer.parseInt(request.getParameter("id"));
        AttendanceDB db = new AttendanceDB();
        List<Attendance> att = db.getAtteandanceBySeid(seid);
        request.setAttribute("att", att);
        request.getRequestDispatcher("FapTable/Attendance.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int seid = Integer.parseInt(request.getParameter("id"));
        
        SessionDB sessionDB = new SessionDB();
        List<Student> list = sessionDB.getStudentInSession(seid);
        
        AttendanceDB attenDB = new AttendanceDB();
        List<Attendance> listAttendance = new ArrayList<>();
        
        Session session = new Session();
        session.setSeid(seid);
        
        for (Student student : list) {
            Attendance attendance = new Attendance();
            attendance.setSeid(session);
            attendance.setStuid(student);
            attendance.setDescription(request.getParameter("description" + student.getStuid()));
            attendance.setIsPresent(request.getParameter("present" + student.getStuid()).equals("yes"));
            listAttendance.add(attendance);
        }
        attenDB.takeAttendancesforStudent(seid, listAttendance);
        response.sendRedirect("attendance?id=" + seid);
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
