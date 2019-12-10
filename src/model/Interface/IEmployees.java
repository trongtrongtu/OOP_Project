package model.Interface;

import model.Employees;

import java.sql.SQLException;
import java.util.List;

public interface IEmployees {
    public List<Employees> getAllEmployees() throws SQLException;
    public void addEmployees(Employees employees) throws SQLException;
    public void editEmployees(Employees employees) throws SQLException;
    public void deleteEmployees(int maNV) throws SQLException ;
    public Employees searchByMaNV(int maNV) throws SQLException;
}