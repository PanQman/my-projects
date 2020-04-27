<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 06.04.2020
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom Login Page</title>
</head>
<body>
    <h3>Custom Login Page</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
        <c:if test="${param.error != null}">
            <i style="color:red;">Wrong User name or password!</i>
        </c:if>
        
        <p>
            User Name: <input type="text" name="username" />
        </p>
        <p>
            Password: <input type="password" name="password" />
        </p>

        <input type="submit" value="Login" />
    </form:form>

</body>
</html>
