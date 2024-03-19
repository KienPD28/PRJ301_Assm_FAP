<%-- 
    Document   : MarkReport
    Created on : Mar 18, 2024, 3:30:41 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .grade-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .grade-table th, .grade-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .grade-table th {
            background-color: #f2f2f2;
        }

        .grade-table tfoot td {
            font-weight: bold;
        }

        .grade-table tfoot tr:last-child td {
            border-top: 2px solid #333;
        }
    </style>
</head>
<body>
<%--<c:set var="sum" value="0" />
<c:set var="fe" value="0" />
<c:set var="start" value="" />
<c:set var="end" value="" />--%>

<c:forEach items="${requestScope.list_grade}" var="gr">
    <c:set var="sum" value="${sum + (gr.score * gr.eid.assid.weight / 100)}" />
    <c:if test="${gr.eid.assid.assname eq 'Final Exam'}">
        <c:set var="fe" value="${gr.score}" />
        <c:set var="start" value="${gr.eid.dateStart}" />
        <c:set var="end" value="${gr.eid.endDate}" />
    </c:if>
</c:forEach>

<table>
    <tr>
        <td>
            <table>
                <thead>
                    <tr>
                        <th>Grade Report for ${sessionScope.stu.stuid} (${sessionScope.stu.name})</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div>
                                <table>
                                    <tbody>
                                        <c:forEach items="${requestScope.groupbystuid}" var="ses">
                                            <tr>
                                                <td>
                                                    <b><a href="viewgrade?subid=${ses.gid.subid.subid}&stuid=${sessionScope.idStudent}">
                                                        ${ses.gid.subid.subname}(${ses.gid.subid.subid})</a>
                                                        (${ses.gid.gname}, from ${end} / ${start})</b><br>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </td>
        <td>
            <table border="1px" class="grade-table">
                <thead>
                    <tr>
                        <th>Grade category</th>
                        <th>Grade item</th>
                        <th>Weight</th>
                        <th>Value</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.list_grade}" var="gr">
                        <tr>
                            <td>${gr.eid.assid.assname}</td>
                            <td>${gr.eid.assid.assname}</td>
                            <td>${gr.eid.assid.weight}</td>
                            <td>${gr.score}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td rowspan="2">Course total</td>
                        <td>Average</td>
                        <td colspan="3">${sum}</td>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td>Status</td>
                        <c:choose>
                            <c:when test="${sum >= 5 and fe < 4}">
                                <td colspan="3"><font color="Red">Not Passed</font></td>
                            </c:when>
                            <c:when test="${sum >= 5 and fe >= 4}">
                                <td colspan="3"><font color="Green">Passed</font></td>
                            </c:when>
                            <c:otherwise>
                                <td colspan="3"><font color="Red">Not Passed</font></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </tfoot>
            </table>
        </td>
    </tr>
</table>
</body>
</html>

