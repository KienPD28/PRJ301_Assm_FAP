<%-- 
    Document   : LecturersView
    Created on : Mar 7, 2024, 10:09:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FPT University Academic Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        header {
            text-align: center;
            margin-bottom: 20px;
        }
        header h1 {
            margin: 10px 0;
            font-size: 24px;
        }
        .btn-campus {
            background-color: #5cb85c;
            border: none;
            color: #fff;
            padding: 5px 10px;
            font-size: 12px;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        .btn-campus:hover {
            cursor: pointer;
            background-color: #4cae4c;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            margin-bottom: 10px;
            background-color: #f9f9f9;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
        }
        nav ul li a:hover {
            color: #5cb85c;
        }
        .lecturer-section {
            background-color: #f0f0f0;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        .lecturer-section h2 {
            margin-bottom: 10px;
            color: #5cb85c;
        }
        .lecturer-section ul {
            list-style-type: none;
            padding: 0;
        }
        .lecturer-section ul li {
            margin-bottom: 10px;
        }
        .lecturer-section ul li a {
            text-decoration: none;
            color: #333;
        }
        .lecturer-section ul li a:hover {
            color: #5cb85c;
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>FPT University Academic Portal</h1>
            <div class="d-flex justify-content-end d-flex align-items-start">
                <button type="button" > CAMPUS: FPTU-Hòa Lạc </button></br>
                
                <input type="button" value="Logout" onclick="window.location.href ='login'"/>
            </div>
        </header>
        <div class="row">
            <div class="mt-2">
                <div class="lecturer-section">
                    <h2>Lecturer Section</h2>
                    <ul>
                        <li><a href="weeklyTable" id="styleHref">View Weekly timetable</a> (Lịch Dạy)</li>
                        <li><a href="#" id="styleHref">Take Attendance</a> (Sửa điểm danh)</li>
                        <li><a href="#" id="styleHref">Views Attendance</a> (Báo cáo điểm danh)</li>
                        <li><a href="#" id="styleHref">Mark Report</a> (Báo cáo điểm)</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

