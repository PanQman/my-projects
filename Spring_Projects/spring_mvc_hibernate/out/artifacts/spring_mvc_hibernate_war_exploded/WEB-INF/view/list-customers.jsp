<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 27.03.2020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <input type="button" value="Add_Customer"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>        <!--call spring controller -->
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="customers" items="${customers}">
                    <!-- construct an update and delete link with customer id -->

                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${customers.id}" />
                    </c:url>

                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${customers.id}" />
                    </c:url>

                    <tr>
                        <td>${customers.firstName}</td>
                        <td>${customers.lastName}</td>
                        <td>${customers.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            <a>|</a>
                             <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure to delete ${customers.firstName}?')))
                               return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>

</body>
</html>
