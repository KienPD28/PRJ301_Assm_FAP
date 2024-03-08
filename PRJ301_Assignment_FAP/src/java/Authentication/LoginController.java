/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Authentication;

import DAO.AccountDB;
import DAO.LecturersDB;
import DAO.SessionDB;
import DAO.StudentDB;
import Entity.Account;
import Entity.Lecturers;
import Entity.Session;
import Entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LoginController extends HttpServlet {
   
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("Authentication/login.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDB db = new AccountDB();
        Account a = db.getAccountByUsernameandPassword(username, password);
        HttpSession session = request.getSession();
        SessionDB sessionDB = new SessionDB();
        List<Session> sessionbyLid = sessionDB.getSessionByLid(username);
        List<Session> sessionbyStuid = sessionDB.getSessionBySid(username);
        request.setAttribute("sessionbyLid", sessionbyLid);
        request.setAttribute("sessionbyStuid", sessionbyStuid);
        LecturersDB lecturer = new LecturersDB();
        StudentDB student = new StudentDB();
        Lecturers lec = lecturer.getLecturersById(username);
        Student stu = student.getStudentByID(username);
        if(a != null){
            if(a.isIsTeacher() == true){
                session.setAttribute("account", a);
                session.setAttribute("lec", lec);
                request.getRequestDispatcher("LecturersView.jsp").forward(request, response);
            }else{
                session.setAttribute("account", a);
                session.setAttribute("stu", stu);
                request.getRequestDispatcher("StudentView.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("Authentication/login.jsp").forward(request, response);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
