<%-- 
    Document   : LecturersView
    Created on : Mar 7, 2024, 10:09:23 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FPT University Academic Portal</title>
    <link rel="stylesheet" href="./css/lecturersview.css"/>
</head>
<body>
    <div class="container">
        <header>
            <h1>FPT University Academic Portal</h1>
            <div class="user-actions">
                <button type="button" class="btn-campus">CAMPUS: FPTU-Hòa Lạc</button>
                <input type="button" value="Logout" class="btn-campus" onclick="window.location.href = 'login'"/>
            </div>
        </header>
        <div class="row">
            <div class="mt-2">
                <div class="lecturer-section">
                    <h2>Lecturer Section</h2>
                    <c:set value="${sessionScope.account}" var="a"></c:set>
                    <ul>
                        <li><a href="weeklyTable" id="styleHref">View Weekly timetable</a> (Lịch Dạy)</li>
                        <li><a href="viewsubject?id=${a.username}&isTeacher=${a.isTeacher}" id="styleHref">Views Attendance</a> (Báo cáo điểm danh)</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
