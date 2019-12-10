
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employees;
import services.EmployeesService;

@WebServlet(name = "AddEmployeesServlet",urlPatterns ="/add-employees" )
public class AddEmployeesServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/form-addNV.jsp");
	dispatcher.forward(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            //lấy data từ form
            Employees emp = new Employees();
            emp.setTenNV(req.getParameter("TENNV"));
            emp.setSdt(req.getParameter("SDT"));
            emp.setEmail(req.getParameter("EMAIL"));
            emp.setDcNV(req.getParameter("DCNV"));
            //thêm vào database
            EmployeesService employeesService = new EmployeesService();
            employeesService.addEmployees(emp);
            
            resp.sendRedirect(req.getContextPath() + "/list-employees");
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployeesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
