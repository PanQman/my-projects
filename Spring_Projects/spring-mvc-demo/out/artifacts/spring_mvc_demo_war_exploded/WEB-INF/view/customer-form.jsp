<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 18.03.2020
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer site</title>
    <style>
        .error{ color: red }
    </style>
</head>
<body>

<form:form action="processForm" modelAttribute="customer">

    First name: <form:input path="firstName"/>
    <br>
    Last name(*): <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" />
    <br><br>
    Your age: <form:input path="age" />
    <form:errors path="age" cssClass="error"/>
    <br><br>
    Postal Code: <form:input path="postalCode" />
    <form:errors path="postalCode" cssClass="error"/>
    <br><br>
    Course Code: <form:input path="courseCode" />
    <form:errors path="courseCode" cssClass="error"/>
    <br><br>
    <input type="submit" value="Zatwierdź" />

</form:form>
</body>
</html>
