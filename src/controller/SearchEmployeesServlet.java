
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employees;
import services.EmployeesService;

@WebServlet(name = "SearchEmployeesServlet" , urlPatterns = "/search-employees")
public class SearchEmployeesServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            String maNV = req.getParameter("search-by-MaNV");
            List<Employees> list = new ArrayList<>();
            EmployeesService employeesService = new EmployeesService();
            list.add(employeesService.searchByMaNV(Integer.parseInt(maNV)));
            req.setAttribute("listemployees", list);
            req.getRequestDispatcher("view/nhan-vien.jsp").forward(req,resp);
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchEmployeesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
