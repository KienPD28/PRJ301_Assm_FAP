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
        <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
    }
    h1 {
        color: #333;
        font-size: 30px; 
        display: flex; 
        align-items: center; 
        justify-content: center; 
    }
    table {
        font-size: 15px; 
        background-color: #fff; 
        border-collapse: collapse;
        width: 80%; 
        margin-left: 10%; 
        border: 1px solid #ccc; 
    }
    th, td {
        padding: 5px; 
        text-align: left; 
        border-bottom: 1px solid #ddd; 
        border-left-width: 0px; 
        border-right-width: 0px;
    }
    th {
        background-color: orange; 
        text-transform: uppercase; 
        font-weight: normal; 
    }
    tr:nth-child(even) {
        background-color: #f2f2f2; 
    }
    tr:hover {
        background-color: #ddd; 
    }
    a {
        text-decoration: none;
        color: #007bff;
    }
   
    .header_content {
        color: blue;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .Navigation .content_link {
        text-decoration: none;
        padding-left: 100px;
    }
    .time_content {
        border: 1px solid #ccc;
        padding: 1px;
        border-radius: 5px;
        width: fit-content;
        background-color: #ff81006e;
    }
    .listStudent_content {
        align-items: center;
        display: flex;
        justify-content: center;
        padding-left: 40px;
    }
</style>

    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>
        <a href="weeklyTable">Time Table</a> | <h3>Activity details</h3>

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
                    <c:if test="${ses.isTaken}">
                        <td style="color: green">Attended</td>
                    </c:if>
                </tr>

            </tbody>
        </table>
    </body>
</html>
