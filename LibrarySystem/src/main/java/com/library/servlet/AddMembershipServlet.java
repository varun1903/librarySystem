package com.library.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddMembershipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberName = request.getParameter("memberName");
        String membershipType = request.getParameter("membershipType");
        String startDate = request.getParameter("startDate");

        if (memberName == null || memberName.isEmpty() || membershipType == null || membershipType.isEmpty() || startDate == null || startDate.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are mandatory.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddMembership.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "varun123");
            String sql = "INSERT INTO memberships (member_name, membership_type, start_date) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberName);
            ps.setString(2, membershipType);
            ps.setString(3, startDate);
            ps.executeUpdate();

            response.sendRedirect("AdminDashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
