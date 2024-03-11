/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Authentication.BaseRequiredAuthentication;
import DAO.GroupDB;
import DAO.SessionDB;
import Entity.Account;
import Entity.Session;
import java.io.IOException;
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
public class ViewSubjectAttendanceController extends BaseRequiredAuthentication {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Account account)
            throws ServletException, IOException {
        SessionDB sesDB = new SessionDB();
        GroupDB grDB = new GroupDB();

        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        boolean isTeacher = Boolean.parseBoolean(request.getParameter("isTeacher"));

        List<Session> groupByLid = sesDB.getOnlyGroupIdsByLid(id);
        List<Session> groupByStuid = sesDB.getGroupIDbyStuid(id);

        session.setAttribute("isTeacher", isTeacher);
        session.setAttribute("stuids", id);
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
    }// </editor-fold>

}
