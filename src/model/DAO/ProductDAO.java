package model.DAO;

import connectionDB.ConnectionDB;
import model.Interface.IProduct;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProduct {

    public ProductDAO(){}
    @Override
    public List<Product> getAllProduct() throws SQLException {
        List<Product> productList = new ArrayList<>();
        Connection connection = ConnectionDB.getConnectionDB();
        String sql ="select * from SANPHAM;";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Product product = new Product();
            product.setImei(resultSet.getString(1));
            product.setMaKH(resultSet.getInt(2));
            product.setTenSP(resultSet.getString(3));
            product.setLoaiSP(resultSet.getString(4));
            product.setNxs(resultSet.getString(5));
            product.setHanBaoHanh(resultSet.getString(6));
            product.setHinhAnh(resultSet.getString(7));
            product.setThongTinSP(resultSet.getString(8));
            productList.add(product);
        }
        statement.close();
        return productList;
    }

    @Override
    public void addProduct(Product product, int maKH) throws SQLException {
        Connection connection = ConnectionDB.getConnectionDB();
        // Thuc hien truy van tham so
        String sql = "insert into SANPHAM(IMEI, MAKH, TENSP, LOAISP,NXS,THOIGIANBAOHANH,HINHANHSP,THONGTINSP) values (?,?,?,?,?,?,?,?);";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Them tham so vao "?"
        statement.setString(1,product.getImei() );
        statement.setInt(2, maKH);
        statement.setString(3, product.getTenSP());
        statement.setString(4, product.getLoaiSP());
        statement.setString(5,product.getNxs());
        statement.setString(6,product.getHanBaoHanh());
        statement.setString(7,product.getHinhAnh());
        statement.setString(8,product.getThongTinSP());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void editProduct(String imei, String tenSP,String loaiSP,String nxs, String thoiGianBH, String hinhanhSP,String thongTinSP) throws SQLException {
        Connection connection = ConnectionDB.getConnectionDB();
        if (hinhanhSP!=null){
            // Thuc hien truy van tham so
            String sql = "update SANPHAM  set TENSP=?, LOAISP=?,NXS=?,THOIGIANBAOHANH=?,HINHANHSP=?,THONGTINSP=? where IMEI=?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Them tham so vao "?"
            statement.setString(7,imei );
            statement.setString(1, tenSP);
            statement.setString(2, loaiSP);
            statement.setString(3,nxs);
            statement.setString(4,thoiGianBH);
            statement.setString(5,hinhanhSP);
            statement.setString(6,thongTinSP);
            statement.executeUpdate();
            statement.close();
        }else {
            // Thuc hien truy van tham so
            String sql = "update SANPHAM  set TENSP=?, LOAISP=?,NXS=?,THOIGIANBAOHANH=?,THONGTINSP=? where IMEI=?;";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Them tham so vao "?"
            statement.setString(6,imei );
            statement.setString(1, tenSP);
            statement.setString(2, loaiSP);
            statement.setString(3,nxs);
            statement.setString(4,thoiGianBH);
            statement.setString(5,thongTinSP);
            statement.executeUpdate();
            statement.close();
        }

    }

    @Override
    public Product searchByImei(String imei) throws SQLException {
        Product product = new Product();
        Connection connection = ConnectionDB.getConnectionDB();
        Statement statement = connection.createStatement();
        String sql = "select * from SANPHAM where IMEI= "+imei+";";
        ResultSet resultSet =statement.executeQuery(sql);
        while (resultSet.next()){
            product.setImei(resultSet.getString(1));
            product.setMaKH(resultSet.getInt(2));
            product.setTenSP(resultSet.getString(3));
            product.setLoaiSP(resultSet.getString(4));
            product.setNxs(resultSet.getString(5));
            product.setHanBaoHanh(resultSet.getString(6));
            product.setHinhAnh(resultSet.getString(7));
            product.setThongTinSP(resultSet.getString(8));
        }
        statement.close();
        return product;
    }

    @Override
    public void deleteProduct(String imei) throws SQLException {
        Connection connection = ConnectionDB.getConnectionDB();
        String sql =" delete from SANPHAM where IMEI="+imei+";";
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
    }
}
