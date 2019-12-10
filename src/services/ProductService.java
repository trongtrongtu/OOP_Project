package services;

import model.DAO.CustomerDAO;
import model.DAO.ProductDAO;
import model.Interface.IProduct;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProduct {

    private ProductDAO productDAO = new ProductDAO();
    @Override
    public List<Product> getAllProduct() throws SQLException {
        return productDAO.getAllProduct();
    }

    @Override
    public void addProduct(Product product, int maKH) throws SQLException {
        productDAO.addProduct(product, maKH);
    }

    @Override
    public void editProduct(String imei, String tenSP, String loaiSP, String nxs, String thoiGianBH, String hinhanhSP, String thongTinSP) throws SQLException {
        productDAO.editProduct(imei, tenSP, loaiSP, nxs, thoiGianBH, hinhanhSP, thongTinSP);
    }

    @Override
    public Product searchByImei(String imei) throws SQLException {
        return productDAO.searchByImei(imei);
    }

    @Override
    public void deleteProduct(String imei) throws SQLException {
        productDAO.deleteProduct(imei);
    }
}
