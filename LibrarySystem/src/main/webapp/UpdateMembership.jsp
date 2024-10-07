<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Membership</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Update Membership</h2>
    <form action="UpdateMembershipServlet" method="post">
        <label for="membershipId">Membership ID:</label>
        <input type="text" id="membershipId" name="membershipId" required><br><br>
        
        <label for="membershipDuration">Extend Membership Duration:</label>
        <select id="membershipDuration" name="membershipDuration">
            <option value="6 months">6 months</option>
            <option value="1 year">1 year</option>
            <option value="2 years">2 years</option>
        </select><br><br>

        <input type="submit" value="Update Membership">
    </form>
    <p style="color:red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>
</body>
</html>
