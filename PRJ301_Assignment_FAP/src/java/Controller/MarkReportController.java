/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.GroupDB;
import DAO.SessionDB;
import Entity.Session;
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
public class MarkReportController extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SessionDB sesdb = new SessionDB();
        String id = request.getParameter("id");
        
        List<Session> groupbylid = sesdb.getOnlyGroupIdsByLid(id);
        List<Session> groupbystuid = sesdb.getGroupIDbyStuid(id);
        
        request.setAttribute("groupbylid", groupbylid);
        request.setAttribute("groupbystuid", groupbystuid);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("idStudent", id);
        
        request.getRequestDispatcher("FapTable/MarkReport.jsp").forward(request, response);
        
        
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
