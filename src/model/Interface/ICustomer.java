package model.Interface;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomer {
    public List<Customer> getAllCustomer() throws SQLException;
    public void addCustomer( String tenKH,String dienThoai, String email, String diaCHi) throws SQLException;
    public void editCustomer(Customer customer) throws SQLException;
    public Customer searchByPhone( String phoneNumber) throws SQLException;
    public Customer searchByMaKH (int maKH) throws SQLException;
    public void deleteCustomer(String maKH) throws SQLException;
}
