<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add University</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Add University</h1>
    <form method="post" action="savedUniversities">
        <input type="text" name="name" placeholder="University Name" required>
        <input type="text" name="country" placeholder="Country" required>
        <input type="url" name="website" placeholder="Website URL" required>
        <input type="submit" value="Add University">
    </form>
    <a href="savedUniversities.jsp">Back to Saved Universities</a>
</body>
</html>
