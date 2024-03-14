<%-- 
    Document   : DetailsSession
    Created on : Mar 7, 2024, 11:40:40 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/detailsSesion.css"/>

    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>
        <a href="weeklyTable">Time Table | Activity details </a> 

        <table>
            <tbody>
                <c:set value="${requestScope.sessionDetails}" var="ses"></c:set>
                    <tr align="left">
                        <td>Date:</td>
                        <td>${ses.date}</td>
                </tr>
                <tr align="left">
                    <td>Slot:</td>
                    <td>${ses.slid.slname}</td>
                </tr>
                <tr align="left">
                    <td>Student group:</td>
                    <td><a href="group?gid=${ses.gid.gid}">${ses.gid.gname}</a></td>
                </tr>
                <tr align="left">
                    <td>Instructor:</td>
                    <td>

                        <a href="detailsLecturers?lid=${ses.lid.lid}">${ses.lid.nickName}</a>

                    </td>


                </tr>
                <tr align="left">
                    <td>Course:</td>
                    <td>${ses.subid.subname}(${ses.subid.subid})</td>
                </tr>

                <tr>
                    <td>Prerequisite:</td>
                    <td>${ses.subid.prerequisite}</td>
                </tr>

                <tr>
                    <td>Credits:</td>
                    <td>${ses.subid.credits}</td>
                </tr>

                <tr>
                    <td>Campus:</td>
                    <td>FU-HL</td>
                </tr>

                <tr align="left">
                    <td>Attendance:</td>
                    
                    <c:if test="${!ses.isTaken}">
                        <td style="color: black">Not yet</td>
                    </c:if>
                    
                    <c:forEach items="${requestScope.attendance}" var="check">
                        <c:if test="${ses.seid == check.seid.seid}">
                            
                            <c:if test="${ses.isTaken}">
                                <c:if test="${check.isPresent}">
                                    <td style="color: green">Attended</td>
                                </c:if>
                                <c:if test="${!check.isPresent}">
                                    <td style="color: red">Absent</td>
                                </c:if>
                            </c:if>
                                    
                        </c:if>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </body>
</html>
