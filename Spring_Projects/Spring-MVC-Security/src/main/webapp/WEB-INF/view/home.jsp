<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 03.04.2020
  Time: 21:36   
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
Hello
<br/>
    <hr>
        <p>
            User: <security:authentication property="principal.username"/>
           <br><br>
            Role: <security:authentication property="principal.authorities"/>
        </p>
    <hr>


    <security:authorize access="hasRole('MANAGER')">
        <br/><br/>
        <hr>
        <br/>

        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a> (Only for Manager peeps)
        </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <br/><br/>
        <hr>
        <br/>

        <p>
            <a href="${pageContext.request.contextPath}/systems">IT Meeting</a> (Only for IT folks)
        </p>
    </security:authorize>

<br/><br/>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Wyloguj"/>
</form:form>

</body>
</html>
