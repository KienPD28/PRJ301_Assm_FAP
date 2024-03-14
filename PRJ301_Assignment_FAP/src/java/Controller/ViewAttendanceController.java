/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import Authentication.BaseRequiredAuthentication;
import DAO.AttendanceDB;
import DAO.GroupDB;
import DAO.SessionDB;
import Entity.Account;
import Entity.Attendance;
import Entity.Session;
import java.io.IOException;
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
public class ViewAttendanceController extends BaseRequiredAuthentication {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        String gid = request.getParameter("id");
        String stuid = request.getParameter("stuid");
        String lid = request.getParameter("lid");
        
        GroupDB db = new GroupDB();
        List<Session> sessionByGid = db.getSessionByGroupId(gid);
        
        SessionDB sesDB = new SessionDB();
        List<Session> attendanceSession = sesDB.getSessionByStudentIdAndGroupId(stuid, gid);
        
        List<Session> groupByLid = sesDB.getOnlyGroupIdsByLid(lid);
        List<Session> groupByStuid = sesDB.getGroupIDbyStuid(stuid);
        
        AttendanceDB attDB = new AttendanceDB();
        List<Attendance> attendance = new ArrayList<>();
        
        for (Session at : attendanceSession) {
            Attendance a = attDB.getStudentByAttendance(at.getSeid(), stuid);
            attendance.add(a);
            
        }
        
        request.setAttribute("sessionByGid", sessionByGid);
        request.setAttribute("attendanceSession", attendanceSession);
        request.setAttribute("attendance", attendance);
        request.setAttribute("groupByLid", groupByLid);
        request.setAttribute("groupByStuid", groupByStuid);
        
        request.getRequestDispatcher("FapTable/ViewAttendance.jsp").forward(request, response);
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        processRequest(request, response, account);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account)
    throws ServletException, IOException {
        processRequest(request, response, account);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
