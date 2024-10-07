<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Return Book</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Return Book</h2>
    <form action="ReturnBookServlet" method="post">
        <label for="bookTitle">Book Title:</label>
        <input type="text" id="bookTitle" name="bookTitle" required><br><br>
        <label for="returnDate">Return Date:</label>
        <input type="date" id="returnDate" name="returnDate" required><br><br>
        <input type="submit" value="Return Book">
    </form>
    <p style="color:red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
</body>
</html>
