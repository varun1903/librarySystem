package com.library.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PayFineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String transactionId = request.getParameter("transactionId");
        String finePaid = request.getParameter("finePaid");

        // Validate inputs
        if (transactionId == null || finePaid == null || finePaid.isEmpty()) {
            request.setAttribute("errorMessage", "Please enter fine details.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("PayFine.jsp");
            dispatcher.forward(request, response);
            return;
        }

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "varun123");
            String sql = "UPDATE transactions SET fine = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, finePaid);
            ps.setString(2, transactionId);
            ps.executeUpdate();

            // Redirect to User Dashboard
            response.sendRedirect("UserDashboard.jsp");
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Log the exception for debugging
            request.setAttribute("errorMessage", "Database error: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("PayFine.jsp");
            dispatcher.forward(request, response);
        } finally {
            // Close resources
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Log the exception
            }
        }
    }
}
