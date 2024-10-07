<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.library.model.Report" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Reports</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h2>Library Reports</h2>
    <form action="ViewReportsServlet" method="get">
        <label for="reportType">Select Report Type:</label>
        <select id="reportType" name="reportType">
            <option value="issuedBooks">Issued Books</option>
            <option value="returnedBooks">Returned Books</option>
            <option value="finesPaid">Fines Paid</option>
        </select><br><br>

        <input type="submit" value="View Report">
    </form>
    <p style="color:red;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </p>

    <table border="1">
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Member</th>
            <th>Date</th>
        </tr>
        <% 
            List<Report> reports = (List<Report>) request.getAttribute("reports");
            if (reports != null) {
                for (Report report : reports) {
        %>
        <tr>
            <td><%= report.getTitle() %></td>
            <td><%= report.getAuthor() %></td>
            <td><%= report.getMember() %></td>
            <td><%= report.getDate() %></td>
        </tr>
        <% 
                }
            } 
        %>
    </table>
</body>
</html>
