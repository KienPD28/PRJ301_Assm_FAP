/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Authentication.BaseRequiredAuthentication;
import DAO.AttendanceDB;
import DAO.SessionDB;
import Entity.Account;
import Entity.Attendance;
import Entity.Session;
import Entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DetailsSessionController extends BaseRequiredAuthentication {
   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        int seid = Integer.parseInt(request.getParameter("seid"));
        SessionDB db = new SessionDB();
        List<Session> listSession = db.getAllSession();
        Session sessionDetails = db.getSessionBySid(seid);
        HttpSession session = request.getSession();
        AttendanceDB attdb = new AttendanceDB();
        List<Attendance> attendance = new ArrayList<>();
        Student s =(Student) session.getAttribute("stu");
        for (Session at : listSession) {
            Attendance a = attdb.getStudentByAttendance(at.getSeid(), s.getStuid());
            attendance.add(a);
        }
        request.setAttribute("attendance", attendance);
        request.setAttribute("listSession", listSession);
        request.setAttribute("sessionDetails", sessionDetails);
        request.getRequestDispatcher("FapTable/DetailsSession.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
