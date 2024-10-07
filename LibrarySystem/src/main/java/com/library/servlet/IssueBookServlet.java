package com.library.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class IssueBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String issueDate = request.getParameter("issueDate");
        String returnDate = request.getParameter("returnDate");

        if (bookName == null || bookName.isEmpty()) {
            request.setAttribute("errorMessage", "Book name is required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("IssueBook.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "varun123");
            String sql = "INSERT INTO transactions (book_id, user_id, issue_date, return_date) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bookName);
            // Assuming session has userId stored
            HttpSession session = request.getSession();
            ps.setInt(2, (Integer) session.getAttribute("userId"));
            ps.setString(3, issueDate);
            ps.setString(4, returnDate);
            ps.executeUpdate();

            response.sendRedirect("UserDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
