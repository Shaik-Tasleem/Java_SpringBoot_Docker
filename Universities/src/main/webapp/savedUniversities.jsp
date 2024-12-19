<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.University" %>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Saved Universities</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Saved Universities</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Country</th>
            <th>Website</th>
            <th>Action</th>
        </tr>
        <c:forEach var="university" items="${universities}">
        <tr>
            <td>${university.name}</td>
            <td>${university.country}</td>
            <td><a href="${university.website}" target="_blank">Visit</a></td>
            <td>
                <form method="post" action="savedUniversities">
                    <input type="hidden" name="id" value="${university.id}">
                    <input type="hidden" name="action" value="delete">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>
    <a href="addUniversity.jsp">Add University Manually</a> |
    <a href="reports.jsp">View Reports</a>
</body>
</html>
