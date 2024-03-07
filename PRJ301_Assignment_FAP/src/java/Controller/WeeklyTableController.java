/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Util.DateHelper;
import Util.DateTime;
import Util.SessionDate;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

/**
 *
 * @author DELL
 */
public class WeeklyTableController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String yearString = request.getParameter("year");
        int year = Year.now().getValue();
        if(yearString != null){
            year = Integer.parseInt(yearString);
        }
        
        List<DateTime> list = DateHelper.DateOfYear(year);
        String weekString = request.getParameter("dateRange");
        
        int week = DateHelper.Weeks(list, LocalDate.now());
        if(weekString != null){
            week = Integer.parseInt(weekString);
        }
        
        int index = DateHelper.IndexByWeeks(list, week);
        List<SessionDate> sessionDate = list.get(index).getListsessionDate();
        
        request.setAttribute("selectedW", week);
        request.setAttribute("selectedY", year);
        request.setAttribute("listDateTime", list);
        request.setAttribute("sessionDate", sessionDate);
        
        request.getRequestDispatcher("FapTable/TimeTable.jsp").forward(request, response);
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

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}