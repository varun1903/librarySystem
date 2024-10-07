package com.library.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReturnBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String serialNo = request.getParameter("serialNo");

        if (bookName == null || bookName.isEmpty() || serialNo == null || serialNo.isEmpty()) {
            request.setAttribute("errorMessage", "Book name and serial number are required.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ReturnBook.jsp");
            dispatcher.forward(request, response);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db", "root", "varun123");
            String sql = "UPDATE transactions SET return_date = ? WHERE book_id = ? AND serial_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, request.getParameter("returnDate"));
            ps.setString(2, bookName);
            ps.setString(3, serialNo);
            ps.executeUpdate();

            response.sendRedirect("PayFine.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
