<%-- 
    Document   : TimeTable
    Created on : Mar 7, 2024, 11:39:42 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/tableweekly.css"/>

    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>

        <table>
            <tbody class="header_content">
                <tr>
                    <td colspan="2">
                        <strong>FAP mobile app (myFAP) is ready at</strong>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="https://apps.apple.com/app/id1527723314">
                            <img
                                src="https://fap.fpt.edu.vn/images/app-store.png"
                                style="width: 120px; height: 40px"
                                alt="apple store"
                                /></a>
                    </td>
                    <td>
                        <a href="https://play.google.com/store/apps/details?id=com.fuct">
                            <img
                                src="https://fap.fpt.edu.vn/images/play-store.png"
                                style="width: 120px; height: 40px"
                                alt="google store"
                                /></a>
                    </td>
                </tr>
            </tbody>
        </table>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="weeklyTable" method="POST">
                        <ol class="Navigation">
<!--                            Role for Teacher-->
                            <c:if test="${sessionScope.account.isTeacher == true}">
                            <li>
                                <span class="content_link">
                                    <a href="LecturersView.jsp">Home</a>&nbsp;|&nbsp;
                                    <b>View Schedule</b
                                    <h2>Lecturers For ${sessionScope.lec.email} (${sessionScope.lec.lname})</h2>
                                </span>
                            </li>
                            </c:if>
                            
<!--                            Role for Student-->
                            <c:if test="${sessionScope.account.isTeacher == false}">
                            <li>
                                <span class="content_link">
                                    <a href="StudentView.jsp">Home</a>&nbsp;|&nbsp;
                                    <b>View Schedule</b
                                    <h2>Student For ${sessionScope.stu.email} (${sessionScope.stu.name})</h2>
                                </span>
                            </li>
                            </c:if>
                        </ol>

                        <table>
                            <thead>
                                <tr>
                                    <th rowspan="2">
                                        <span class="year_content"><strong>Year</strong></span>
                                        <select name="year" id="content_year" onchange="this.form.submit()">
                                            <option value="2020" ${requestScope.selectedY == 2020 ? 'selected' : ''}>2020</option>
                                            <option value="2021" ${requestScope.selectedY == 2021 ? 'selected' : ''}>2021</option>
                                            <option value="2022" ${requestScope.selectedY == 2022 ? 'selected' : ''}>2022</option>
                                            <option value="2023" ${requestScope.selectedY == 2023 ? 'selected' : ''}>2023</option>
                                            <option value="2024" ${requestScope.selectedY == 2024 ? 'selected' : ''}>2024</option>
                                            <option value="2025" ${requestScope.selectedY == 2025 ? 'selected' : ''}>2025</option>
                                        </select><br />
                                        <span class="week_content"><strong>Week</strong></span>
                                        <select name="dateRange" id="content_week" onchange="this.form.submit()">
                                            <c:forEach items="${requestScope.listDateTime}" var="i">
                                                <option value ="${i.week}" ${i.week == requestScope.selectedW ? 'selected' : ''}>${i.content}</option>
                                            </c:forEach>
                                        </select>
                                    </th>

                            <div class="today_content">
                                <th align="center">Mon</th>
                                <th align="center">Tue</th>
                                <th align="center">Wed</th>
                                <th align="center">Thu</th>
                                <th align="center">Fri</th>
                                <th align="center">Sat</th>
                                <th align="center">Sun</th>
                            </div>

                            </tr>
                            <tr>
                                <c:forEach items="${requestScope.showDateInWeek}" var="i">
                                    <th align="center">${i.showDate()}</th>
                                    </c:forEach>

                                <c:forEach items="${requestScope.slots}" var="sl">
                                <tr>
                                    <td>${sl.slname}</td>


                                </tr>
                            </c:forEach>
                            </tr>
                            </thead>

                        </table>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>


