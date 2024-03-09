/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.EnrollmentDB;
import DAO.StudentDB;
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
public class GroupStudentController extends HttpServlet {
   
    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String gid = request.getParameter("gid");
        EnrollmentDB db = new EnrollmentDB();
        List<Student> list = db.getEnrollBygid(gid);
        
        StudentDB studentDB = new StudentDB();
        List<Student> studentGroup = new ArrayList<>();
        
        for (Student student : list) {
            studentGroup.add(studentDB.getStudentByID(student.getStuid()));
        }
        request.setAttribute("studentGroup", studentGroup);
        request.getRequestDispatcher("FapTable/GroupStudent.jsp").forward(request, response);
        
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
