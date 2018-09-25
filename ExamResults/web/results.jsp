<%--
  Created by IntelliJ IDEA.
  User: Vixon
  Date: 9/25/2018
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="utexas.ExamResult"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <title>Exam Results</title>
</head>
<body>
    <h1>Welcome to your exam results!</h1><hr>
    <%
        ExamResult result = (ExamResult)session.getAttribute("result");
        if (result != null) {
    %>
    <table>
        <tr>
            <td style="font-weight: bold">ID Number:</td>
            <td><%=result.getIdNumber()%></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Student Name:</td>
            <td><%=result.getStudentName()%></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Exam 1 Grade:</td>
            <td><%=result.getExam1Grade()%></td>
        </tr>
        <tr>
            <td style="font-weight: bold">Exam 2 Grade:</td>
            <td><%=result.getExam2Grade()%></td>
        </tr>
    </table>
    <%
        } else {
    %>
    <h3>We could not provide you with any results</h3>
    <%
        }
    %>
    <hr><<a href="index.html">Back to Home</a>
</body>
</html>
