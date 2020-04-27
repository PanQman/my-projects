<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student ${theStudent.firstName}</title>
</head>
<body>

The student is confirmed: ${theStudent.firstName} ${theStudent.lastName}
                            <%--theStudent.getFirstName() and theStudent.getLastName() --%>
<br><br>
Country: ${theStudent.country}
<br>
Favourite language: ${theStudent.favouriteLanguage}
<br>
Systems:
<ul>
    <c:forEach var="temp" items="${theStudent.systemsList}">
        <li> ${temp} </li>
    </c:forEach>
</ul>

</body>
</html>