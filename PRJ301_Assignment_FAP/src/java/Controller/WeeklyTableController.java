/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Authentication.BaseRequiredAuthentication;
import DAO.SlotDB;
import Entity.Account;
import Entity.Session;
import Entity.Slot;
import Util.DateHelper;
import Util.DateTime;
import Util.SessionDate;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

/**
 *
 * @author DELL
 */
public class WeeklyTableController extends BaseRequiredAuthentication {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        String user = request.getParameter("lid");
        String yearString = request.getParameter("year");
        HttpSession session = request.getSession();
        session.setAttribute("username", user);
        List<Session> listSessionByLid = (List<Session>) session.getAttribute("sessionbyLid");
        List<Session> listSessionByStuid = (List<Session>) session.getAttribute("sessionbyStuid");
        
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
        List<SessionDate> showDateInWeek = list.get(index).getListsessionDate();
        SlotDB dbslot = new SlotDB();
        List<Slot> slots = dbslot.getAllSlot();
        
        
        
        request.setAttribute("listSessionByLid", listSessionByLid);
        request.setAttribute("listSessionByStuid", listSessionByStuid);
        request.setAttribute("slots", slots);
        request.setAttribute("selectedW", week);
        request.setAttribute("selectedY", year);
        request.setAttribute("listDateTime", list);
        request.setAttribute("showDateInWeek", showDateInWeek);
        
        request.getRequestDispatcher("FapTable/TimeTable.jsp").forward(request, response);
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        processRequest(request, response,  account);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        processRequest(request, response,  account);
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
