<%-- 
    Document   : GroupStudent
    Created on : Mar 9, 2024, 1:33:57 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Student Table</title>
        <link rel="stylesheet" href="./css/groupStudent.css"/>
    </head>
    <body>
        <h1><span>FPT University Academic Portal</span></h1>

        <table>
            <thead>
                <tr>
                    <th>Index</th>
                    <th>Image</th>
                    <th>Roll Student</th>
                    <th>Full Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.studentGroup}" var="st" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>
                <center>
                    <img src="./image/student.jpg" alt="Student Image">
                </center>
            </td>
            <td>${st.stuid}</td>
            <td>${st.name}</td>
        </tr>

    </c:forEach>
</tbody>
</table>

</body>
</html>

