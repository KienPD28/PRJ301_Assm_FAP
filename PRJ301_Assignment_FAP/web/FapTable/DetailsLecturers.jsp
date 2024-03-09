<%-- 
    Document   : DetailsLecturers
    Created on : Mar 7, 2024, 11:41:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/detailsLecturers.css"/>
    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>
        <div class="content_block">
            <a href="weeklyTable">Back | User detail</a> 
        </div>
        

        <table>
            <tbody>
                
                <c:set value="${requestScope.inforLecturers}" var="info"></c:set>
                    <tr align="left">
                        <td>Login</td>
                        <td>${info.nickName}</td>
                </tr>
                <tr align="left">
                    <td>FullName</td>
                    <td>${info.lname}</td>
                </tr>
                <tr align="left">
                    <td>Image</td>
                    <td>
                        <img src="./image/Lecturers.png" alt="Lecturers Image">
                    </td>
                </tr>
                <tr align="left">
                    <td>Email</td>
                    <td>${info.email}</td>
                </tr>
               

            </tbody>
        </table>
    </body>
</html>

