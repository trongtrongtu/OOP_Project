
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/login.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error = "";
        if (username.equals("") || password.equals("")) {
            error += "Email/Password is required!";
        } 

        if (error.length() > 0) {
            request.setAttribute("error", error);
        }

        String url = "/login.jsp";
        try {
            if (error.length() == 0) {
                if (username.equals("admin")&&password.equals("admin")) {
                    
                    response.sendRedirect(request.getContextPath() + "/index.jsp");
                }
            } else {
                url = "/login.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            response.sendRedirect("/login.jsp");
        }
    }

}
