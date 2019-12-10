package services;

import java.sql.SQLException;
import java.util.List;
import model.DAO.EmployeesDAO;
import model.Employees;
import model.Interface.IEmployees;


public class EmployeesService implements IEmployees {

    private EmployeesDAO employeesDAO = new EmployeesDAO();
    
    @Override
    public List<Employees> getAllEmployees() throws SQLException {
        return employeesDAO.getAllEmployees();
    }

    @Override
    public void addEmployees(Employees employees) throws SQLException {
        employeesDAO.addEmployees(employees);
    }

    @Override
    public void editEmployees(Employees employees) throws SQLException {
        employeesDAO.editEmployees(employees);
    }

    @Override
    public void deleteEmployees(int maNV) throws SQLException {
        employeesDAO.deleteEmployees(maNV);
    }
    
    @Override
    public Employees searchByMaNV(int maNV) throws SQLException {
        return employeesDAO.searchByMaNV(maNV);
    }
}
