<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pay Fine</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Pay Fine</h2>
    <form action="PayFineServlet" method="post">
        <label for="bookTitle">Book Title:</label>
        <input type="text" id="bookTitle" name="bookTitle" readonly value="<%= request.getAttribute("bookTitle") %>"><br><br>
        
        <label for="fineAmount">Fine Amount:</label>
        <input type="text" id="fineAmount" name="fineAmount" readonly value="<%= request.getAttribute("fineAmount") %>"><br><br>
        
        <label for="finePaid">Fine Paid:</label>
        <input type="checkbox" id="finePaid" name="finePaid" value="yes"> Yes<br><br>

        <label for="remarks">Remarks:</label>
        <textarea id="remarks" name="remarks"></textarea><br><br>
        
        <input type="submit" value="Confirm Payment">
    </form>
    <p style="color:red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
</body>
</html>
