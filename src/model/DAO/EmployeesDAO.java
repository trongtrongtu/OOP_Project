package model.DAO;


import connectionDB.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Employees;
import model.Interface.IEmployees;


public class EmployeesDAO implements IEmployees{

    public EmployeesDAO(){}

    @Override
    public List<Employees> getAllEmployees() throws SQLException{
        List<Employees> employeesList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnectionDB();
        String sql = "select * from NHANVIEN;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            //manv, ten nv, sdt, email, dia chi
            Employees employees = new Employees();
            employees.setMaNV(resultSet.getInt(1));
            employees.setTenNV(resultSet.getString(2));
            employees.setSdt(resultSet.getString(3));
            employees.setEmail(resultSet.getString(4));
            employees.setDcNV(resultSet.getString(5));

            employeesList.add(employees);
        }
        resultSet.close();
        statement.close();
        return employeesList;
    }

    @Override
    public void addEmployees(Employees employees) throws SQLException{
        Connection connection = ConnectionDB.getConnectionDB();

        String sql = "insert into NHANVIEN(TENNV, SDT, EMAIL, DCNV) values (?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);
        // ten nv, sdt, email, dia chi
        statement.setString(1, employees.getTenNV());
        statement.setString(2, employees.getSdt());
        statement.setString(3, employees.getEmail());
        statement.setString(4, employees.getDcNV());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void editEmployees(Employees employees) throws SQLException{
        Connection connection = ConnectionDB.getConnectionDB();

        String sql = "update NHANVIEN set TENNV=?, SDT=?, EMAIL=?, DCNV=? where MANV=?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, employees.getTenNV());
        statement.setString(2, employees.getSdt());
        statement.setString(3, employees.getEmail());
        statement.setString(4, employees.getDcNV());
        statement.setInt(5, employees.getMaNV());
        statement.executeUpdate();
        statement.close();

    }
    
    @Override
    public void deleteEmployees(int maNV) throws SQLException{
        Connection connection = ConnectionDB.getConnectionDB();
        String sql = "delete from NHANVIEN where MANV= ? ;";
        PreparedStatement statement = connection.prepareStatement(sql);       
        statement.setInt(1, maNV);
        statement.executeUpdate();
        statement.close();

    }
    
    @Override
    public Employees searchByMaNV(int maNV) throws SQLException {
        Employees employees = new Employees();
        Connection connection = ConnectionDB.getConnectionDB();
        Statement statement = connection.createStatement();
        String sql = "select * from NHANVIEN where MANV="+maNV+";";
        ResultSet resultSet = statement.executeQuery(sql);
        //manv, ten nv, sdt, email, dia chi
        while (resultSet.next()){
            employees.setMaNV(resultSet.getInt(1));
            employees.setTenNV(resultSet.getString(2));
            employees.setSdt(resultSet.getString(3));
            employees.setEmail(resultSet.getString(4));
            employees.setDcNV(resultSet.getString(5));
        }
        statement.close();
        return employees;
    }


}
