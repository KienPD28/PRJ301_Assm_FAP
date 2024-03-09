<%-- 
    Document   : Attendance
    Created on : Mar 7, 2024, 11:41:16 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/attendance.css"/>
    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>
        <a href="weeklyTable">Time Table</a>
        <form action="attendance" method="POST">
            <input type="hidden" name="id" value="${param.id}" />
            <table border="1px">
                <tr class="header_row">
                    <td>Group</td>
                    <td>Id</td>
                    <td>Name</td>
                    <td>Presented</td>
                    <td>Note</td>
                    <td>Image</td>
                    <td>Time</td>
                </tr>
                <c:forEach items="${requestScope.att}" var="at">
                    <tr>

                        <td>${at.gid.gname}</td>
                        <td>${at.stuid.stuid}</td>
                        <td>${at.stuid.name}</td>
                        <td>
                            <input type="radio" 
                                   ${!at.isPresent?"checked=\"checked\"":""}
                                   name="present${at.stuid.stuid}" value="no"/> Absent
                            <input type="radio" 
                                   ${at.isPresent?"checked=\"checked\"":""}
                                   name="present${at.stuid.stuid}" value="yes"/> Present
                        </td>
                        <td>
                            <input type="text" name="description${at.stuid.stuid}" value="${at.description}"/>
                        </td>
                        <td>

                            <img src="./image/student.jpg" alt="Student Image">

                        </td>
                        <td>${at.dateTime}</td>
                    </tr>    
                </c:forEach>
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
