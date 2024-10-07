<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Books</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Search Books</h2>
    <form action="SearchBooksServlet" method="get">
        <label for="title">Book Title:</label>
        <input type="text" id="title" name="title"><br><br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author"><br><br>
        <input type="submit" value="Search">
    </form>
    <p style="color:red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
</body>
</html>
