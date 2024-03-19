/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.MarkDB;
import DAO.SessionDB;
import Entity.Grade;
import Entity.Session;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ViewGradeController extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        SessionDB sesdb = new SessionDB();
        MarkDB markdb = new MarkDB();
        
        String subid_id = request.getParameter("subid");
        String studentid_id = request.getParameter("stuid");
        
        List<Session> list_groupbystuid = sesdb.getGroupIDbyStuid(subid_id);
        List<Grade> list_grade = markdb.getMarkByStuidandSubid(studentid_id, subid_id);
        
        request.setAttribute("list_groupbystuid", list_groupbystuid);
        request.setAttribute("list_grade", list_grade);
        
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
    }

}
