package com.library.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && "admin".equals(session.getAttribute("role"))) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
