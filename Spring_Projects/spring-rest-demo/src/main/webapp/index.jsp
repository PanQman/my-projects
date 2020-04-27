<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 21.04.2020
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Rest Demo</title>
</head>
<body>

<h3>Spring REST Demo</h3>

<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">Get Students</a>

</body>
</html>
