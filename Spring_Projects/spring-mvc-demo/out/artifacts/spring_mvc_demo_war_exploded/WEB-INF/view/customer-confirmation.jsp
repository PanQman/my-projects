<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student ${customer.firstName}</title>
</head>
<body>

The customer is confirmed: ${customer.firstName} ${customer.lastName}
<br>
Your age: ${customer.age}
<br>
Postal Code: ${customer.postalCode}
<br>
Postal Code: ${customer.courseCode}
<br>
</body>
</html>