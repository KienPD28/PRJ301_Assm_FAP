/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Authentication;

import DAO.AccountDB;
import Entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        if(a != null){
            if(a.isIsTeacher() == true){
                session.setAttribute("account", a);
                request.getRequestDispatcher("Authentication/LecturersView.jsp").forward(request, response);
            }else{
                session.setAttribute("account", a);
                request.getRequestDispatcher("Authentication/StudentView.jsp").forward(request, response);
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
