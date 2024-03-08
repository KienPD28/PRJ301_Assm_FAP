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
        <style>
            
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
            }
            h1 {
                color: #333;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
                border-bottom: 1px solid #ddd;
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
        </style>
    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>
        <a href="weeklyTable">Back</a> | <h3>User detail</h3>

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
                    <td></td>
                </tr>
                <tr align="left">
                    <td>Email</td>
                    <td>${info.email}</td>
                </tr>
               

            </tbody>
        </table>
    </body>
</html>

