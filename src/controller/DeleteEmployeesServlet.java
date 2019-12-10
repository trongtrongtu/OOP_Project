
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.EmployeesService;

@WebServlet(name = "DeleteEmployeesServlet" , urlPatterns = "/delete-employees")
public class DeleteEmployeesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String maNV = req.getQueryString();
            EmployeesService employeesService =  new EmployeesService();
            employeesService.deleteEmployees(Integer.parseInt(maNV));
            
            resp.sendRedirect(req.getContextPath()+"/list-employees");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteEmployeesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
