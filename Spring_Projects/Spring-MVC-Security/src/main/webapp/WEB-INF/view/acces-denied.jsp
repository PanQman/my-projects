<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 03.04.2020
  Time: 21:36   
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Acces Denied</title>
</head>
<body>
    <h2>Acces Denied</h2>
    <hr>
    <p>
        <h3>You are not authorized to access this resource</h3>
    </p><hr>

    <a href="${pageContext.request.contextPath}/">Back to Home</a>

</body>
</html>
