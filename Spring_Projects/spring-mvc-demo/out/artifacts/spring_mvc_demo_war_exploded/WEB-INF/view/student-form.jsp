<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Strona studencka</title>
</head>
<body>
<form:form action="zapiszStudenta" modelAttribute="theStudent">

    First name: <form:input path="firstName"/>
    <br>
    Last name: <form:input path="lastName" />
    <br><br>
    Country: 
    <form:select path="country">
        <form:options items="${theStudent.countryOptions}" />
    </form:select>
    <br><br>
    Your favourite language:
    Java <form:radiobutton path="favouriteLanguage" value="Java" />
    C# <form:radiobutton path="favouriteLanguage" value="C#" />
    Javascript <form:radiobutton path="favouriteLanguage" value="Javascript" />
    <br><br>
    Operating Systems:
    <form:checkboxes path="systemsList" items="${theStudent.systemsOptions}"/>
    <br>

    <input type="submit" value="Zatwierdź" />


</form:form>

</body>
</html>