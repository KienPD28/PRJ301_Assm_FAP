/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Authentication.BaseRequiredAuthentication;
import DAO.LecturersDB;
import Entity.Account;
import Entity.Lecturers;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DetailsLecturersController extends BaseRequiredAuthentication {
   
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        String lid = request.getParameter("lid");
        LecturersDB db = new LecturersDB();
        List<Lecturers> lecturersList = db.getAll();
        Lecturers inforLecturers = db.getLecturersById(lid);
        request.setAttribute("lecturersList", lecturersList);
        request.setAttribute("inforLecturers", inforLecturers);
        request.getRequestDispatcher("FapTable/DetailsLecturers.jsp").forward(request, response);
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
