package com.library.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are mandatory.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddBook.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "varun123");
            String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.executeUpdate();

            response.sendRedirect("AdminDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
