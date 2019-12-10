package model.Interface;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProduct {
    public List<Product> getAllProduct() throws SQLException; // Lay tat ca san pham dang bao hanh
    public void addProduct(Product product, int maKH) throws SQLException;// Them san pham bao hanh
    public void editProduct(String imei, String tenSP,String loaiSP,String nxs, String thoiGianBH, String hinhanhSP,String thongTinSP) throws SQLException; //Sua san pham bao hanh
    public Product searchByImei(String imei) throws SQLException; // Tim kiem san pham theo imei
    public void deleteProduct(String imei) throws SQLException;
}
