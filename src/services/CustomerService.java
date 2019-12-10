package services;

import model.Customer;
import model.DAO.CustomerDAO;
import model.Interface.ICustomer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomer {

    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public List<Customer> getAllCustomer() throws SQLException {
        return customerDAO.getAllCustomer();
    }

    @Override
    public void addCustomer(String tenKH,String dienThoai, String email, String diaCHi) throws SQLException {
        customerDAO.addCustomer(tenKH, dienThoai, email, diaCHi);
    }

    @Override
    public void editCustomer(Customer customer) throws SQLException {
        customerDAO.editCustomer(customer);
    }

    @Override
    public Customer searchByPhone(String phoneNumber) throws SQLException {
        return customerDAO.searchByPhone(phoneNumber);
    }

    @Override
    public Customer searchByMaKH(int maKH) throws SQLException {
        return customerDAO.searchByMaKH(maKH);
    }

    @Override
    public void deleteCustomer(String maKH) throws SQLException {
        customerDAO.deleteCustomer(maKH);
    }
}
