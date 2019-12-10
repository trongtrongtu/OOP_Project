
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

@WebServlet(name = "EditEmployeesServlet",urlPatterns = "/edit-employees")
public class EditEmployeesServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String maNV = req.getQueryString();
        req.setAttribute("MANV", maNV);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/form-editNV.jsp");
        dispatcher.forward(req,resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Employees emp = new Employees();
            emp.setMaNV(Integer.parseInt(req.getParameter("MANV")));
            emp.setTenNV(req.getParameter("TENNV"));
            emp.setSdt(req.getParameter("SDT"));
            emp.setEmail(req.getParameter("EMAIL"));
            emp.setDcNV(req.getParameter("DCNV"));
            EmployeesService employeesService = new EmployeesService();
            employeesService.editEmployees(emp);
            
            resp.sendRedirect(req.getContextPath() + "/list-employees");
        } catch (SQLException ex) {
            Logger.getLogger(EditEmployeesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
