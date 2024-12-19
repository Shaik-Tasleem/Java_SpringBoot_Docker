<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="model.University" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>University Search</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>University Search</h1>
    <form method="get" action="searchUniversity">
        <input type="text" name="country" placeholder="Enter country name" required>
        <input type="submit" value="Search">
    </form>

    <c:if test="${not empty universities}">
    <h2>Search Results:</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Country</th>
            <th>Website</th>
            <th>Action</th>
        </tr>
        <% 
            List<University> universities = (List<University>) request.getAttribute("universities");
            if (universities != null) {
                for (University university : universities) { 
        %>
        <tr>
            <td><%= university.getName() %></td>
            <td><%= university.getCountry() %></td>
            <td><a href="<%= university.getWebsite() %>" target="_blank">Visit Website</a></td>
            <td>
                <form method="post" action="savedUniversities">
                    <input type="hidden" name="name" value="<%= university.getName() %>">
                    <input type="hidden" name="country" value="<%= university.getCountry() %>">
                    <input type="hidden" name="website" value="<%= university.getWebsite() %>">
                    <input type="submit" value="Save">
                </form>
            </td>
        </tr>
        <% 
                }
            }
        %>
    </table>
</c:if>

<c:if test="${empty universities}">
    <p>No universities found. Please enter a valid country name.</p>
</c:if>

</body>
</html>
