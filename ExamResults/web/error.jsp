<%--
  Created by IntelliJ IDEA.
  User: Vixon
  Date: 9/25/2018
  Time: 1:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true"%>
<html>
<head>
    <title>Exam Results</title>
</head>
<body>
    <h1>Welcome!</h1>
    <hr/>
    <h3>We could not provide you with the results.</h3>
    <h3><b>Reason: </b><%=exception.getMessage()%></h3>
    <hr/>
    <a href="index.html">Back to Home</a>
</body>
</html>
