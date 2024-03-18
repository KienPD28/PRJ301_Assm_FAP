<%-- 
    Document   : StudentView
    Created on : Mar 7, 2024, 10:09:10 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University Academic Portal</title>
        <link rel="stylesheet" href="./css/studentview.css"/>
    </head>
    <body>
        <div class="container">
            
            <div class="sidebar">
                <nav>
                    <ul>
                        <li><a href="weeklyTable">Weekly Timetable</a></li>
                        <li><a href="viewsubject?id=${sessionScope.account.username}&isTeacher=${sessionScope.account.isTeacher}">Attendance Report</a></li>
                        <li><a href="mark?id=${sessionScope.account.username}">Mark Report</a></li>
                    </ul>
                </nav>
            </div>
            
            <div class="content">
                <header>
                    <h1>FPT University Academic Portal</h1>
                    <button class="btn-campus">CAMPUS: FPTU-Hòa Lạc</button><br>
                    <input type="button" value="Logout" class="btn-campus" onclick="window.location.href = 'login'"/>
                </header>
                
            </div>
        </div>
    </body>

</html>
