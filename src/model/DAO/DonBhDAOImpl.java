/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connectionDB.*;
import services.CustomerService;

/**
 *
 * @author DELL LATITUDE
 */
public class DonBhDAOImpl implements model.Interface.DonBhDAO {

    @Override
    public void insert(DonBh don) {
        String sql = "INSERT INTO DONBAOHANH(IMEI, MAKH, MOTABENH, MALK, GIADON, MANV, TRANGTHAISUACHUA, NGAYTAO) VALUES (?,?,?,?,?,?,?,getdate())";

        try {
            Connection con = ConnectionDB.getConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);

            // ps.setString(1, don.getMaDon());
            ps.setString(1, don.getImei());
            ps.setInt(2, don.getMaKH());
            ps.setString(3, don.getLoi());
            ps.setInt(4, don.getMaLK());
            ps.setInt(5, don.getGiaDon());
            ps.setInt(6, don.getMaNV());
            ps.setString(7, don.getTrangThai());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int maDon) {
        String sql = "DELETE FROM DONBAOHANH WHERE MADON = ?";

        try {
            Connection con = ConnectionDB.getConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, maDon);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block

        }
    }

    @Override
    public void edit(DonBh don) {
        String sql = "UPDATE DONBAOHANH SET IMEI = ?, MAKH=?, MOTABENH=?, MALK=?, GIADON=?, MANV=?, TRANGTHAISUACHUA=? WHERE MADON=?";

        try {
            Connection con = ConnectionDB.getConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(8, don.getMaDon());
            ps.setString(1, don.getImei());
            ps.setInt(2, don.getMaKH());
            ps.setString(3, don.getLoi());
            ps.setInt(4, don.getMaLK());
            ps.setInt(5, don.getGiaDon());
            ps.setInt(6, don.getMaNV());
            ps.setString(7, don.getTrangThai());
            ps.executeUpdate();
            System.out.println("model.DAO.DonBhDAOImpl.edit()");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DonBh> getAll() {
        List<DonBh> list = new ArrayList<DonBh>();
        String sql = "SELECT * FROM DONBAOHANH";

        try {
            Connection con = ConnectionDB.getConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("model.DAO.DonBhDAOImpl.getAll()");
            while (rs.next()) {
                DonBh don = new DonBh();
                don.setMaDon(rs.getInt("MADON"));
                don.setImei(rs.getString("IMEI"));
                don.setMaKH(rs.getInt("MAKH"));
                don.setLoi(rs.getString("MOTABENH"));
                don.setMaLK(rs.getInt("MALK"));
                don.setGiaDon(rs.getInt("GIADON"));
                don.setTrangThai(rs.getString("TRANGTHAISUACHUA"));
                don.setMaNV(rs.getInt("MANV"));
                don.setDate(rs.getDate("NGAYTAO"));
                list.add(don);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public DonBh get(int maDon) {
        DonBh don = new DonBh();
        String sql = "SELECT * FROM dbo.DONBAOHANH where MADON = " + maDon;

        try {
            Connection con = ConnectionDB.getConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("get DonBH");
            while (rs.next()) {
                don.setMaDon(rs.getInt("MADON"));
                don.setImei(rs.getString("IMEI"));
                don.setMaKH(rs.getInt("MAKH"));
                don.setLoi(rs.getString("MOTABENH"));
                don.setMaLK(rs.getInt("MALK"));
                don.setGiaDon(rs.getInt("GIADON"));
                don.setTrangThai(rs.getString("TRANGTHAISUACHUA"));
                don.setMaNV(rs.getInt("MANV"));
                don.setDate(rs.getDate("NGAYTAO"));
            }

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return don;
    }

    @Override
    public DonBh searchByImei(String imei) {
        DonBh don = new DonBh();
        String sql = "SELECT Top 1 * FROM DONBAOHANH WHERE IMEI = '" + imei + "' ORDER BY NGAYTAO DESC";
//To change body of generated methods, choose Tools | Templates.
        try {
            Connection con = ConnectionDB.getConnectionDB();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            System.out.println("model.DAO.DonBhDAOImpl.searchByImei()");
            while (rs.next()) {
                don.setMaDon(rs.getInt("MADON"));
                don.setImei(rs.getString("IMEI"));
                don.setMaKH(rs.getInt("MAKH"));
                don.setLoi(rs.getString("MOTABENH"));
                don.setMaLK(rs.getInt("MALK"));
                don.setGiaDon(rs.getInt("GIADON"));
                don.setTrangThai(rs.getString("TRANGTHAISUACHUA"));
                don.setMaNV(rs.getInt("MANV"));
                don.setDate(rs.getDate("NGAYTAO"));
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return don;
    }
}
