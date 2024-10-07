package com.library.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && "user".equals(session.getAttribute("role"))) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("UserDashboard.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
