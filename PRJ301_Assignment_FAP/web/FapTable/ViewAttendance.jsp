<%-- 
    Document   : ViewAttendance
    Created on : Mar 10, 2024, 2:59:32 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./css/attendanceReport.css"/>
    </head>
    <body>
        
        <c:if test="${sessionScope.isTeacher == true}">
           <title>Attendance Report</title> 
            <input type="button" value="Home" class="btn-campus" onclick="window.location.href = 'LecturersView.jsp'"/>
            <table>
                <tr>
                    <td>
                        <table>
                            <thead>
                                <tr><th>Course</th></tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.groupByLid}" var="s">
                                    <tr>
                                        <td><b><a href="view?id=${s.gid.gid}&lid=${s.gid.lid.lid}" style="text-decoration: none;" class="custom-link">${s.gid.subid.subname}(${s.gid.subid.subid})</a>(${s.gid.gname})</b></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                    <td>
                        <table border="1px">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Date</th>
                                    <th>Slot</th>
                                    <th>Room</th>
                                    <th>Lecturers</th>
                                    <th>Group Name</th>
                                    <th>Attendance status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.sessionByGid}" var="s1" varStatus="idex">
                                    <tr>
                                        <td>${idex.index+1}</td>
                                        <td>${s1.date}</td>
                                        <td>${s1.slid.slid} (${s1.tid.startTime}-${s1.tid.endTime})</td>
                                        <td>${s1.rid.rname}</td>
                                        <td>${s1.lid.nickName}</td>
                                        <td>${s1.gid.gname}</td>
                                        <td><c:if test="${!s1.isTaken}">Not yet</c:if><c:if test="${s1.isTaken}">Attended</c:if></td>
                                        </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </table>
        </c:if>
        
        
        <c:if test="${sessionScope.isTeacher == false}">
            <input type="button" value="Home" class="btn-campus" onclick="window.location.href = 'StudentView.jsp'"/>
            <table>
                <tr>
                    <td>
                        <table>
                            <thead>
                                <tr><th>Course</th></tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.groupByStuid}" var="s2">
                                    <tr>
                                        <td><b><a href="view?id=${s2.gid.gid}&stuid=${sessionScope.stuids}">${s2.gid.subid.subname}(${s2.gid.subid.subid})</a>(${s2.gid.gname})</b></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                    <td>
                        <table border="1px">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>Date</th>
                                    <th>Slot</th>
                                    <th>Room</th>
                                    <th>Lecturers</th>
                                    <th>Group Name</th>
                                    <th>Attendance status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.attendanceSession}" var="s3" varStatus="idex">
                                    <tr>
                                        <td>${idex.index+1}</td>
                                        <td>${s3.date}</td>
                                        <td>${s3.slid.slid} (${s3.tid.startTime}-${s3.tid.endTime})</td>
                                        <td>${s3.rid.rname}</td>
                                        <td>${s3.lid.nickName}</td>
                                        <td>${s3.gid.gname}</td>
                                        <td>
                                            <c:if test="${!s3.isTaken}">Not yet</c:if>
                                            <c:if test="${s3.isTaken}">Attended</c:if>
                                        </td>
                                        </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </table>
        </c:if>
    </body>
</html>

