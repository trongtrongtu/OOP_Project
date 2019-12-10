

package model.DAO;

import connectionDB.ConnectionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Device;
import model.Interface.IDevice;


public class DeviceDAO implements IDevice{
    
    public DeviceDAO(){};
    
    @Override
    public List<Device> getAllDevice(){
        List<Device> list = new ArrayList<>(); //tao 1 mang list chua cac device
        try{
            String sql = "select * from LINHKIEN ;" ;
            Connection connection = ConnectionDB.getConnectionDB(); //ket noi database
            Statement statement = connection.createStatement(); //tao statement de thuc thi cau lenh sql
            ResultSet rs = statement.executeQuery(sql); //thuc hien truy van sql,tra ve cac doi tuong cua ResultSet
            while(rs.next()){           //kiem tra null
                Device device = new Device();
                device.setMaLK(rs.getInt(1));  //Lay data tu Result Set
                device.setTenLK(rs.getString(2));
                device.setNsx(rs.getString(3));
                device.setGiaLK(rs.getInt(4));
            
                list.add(device); //them vao list
            }
            rs.close(); //giai phong cac resource
            statement.close();
        }catch(Exception ex){  //in ra loi neu ket noi that bai
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public void insertDevice(Device device){
        try{
            String sql = " insert into LINHKIEN(TENLK,NSX,GIALK) values(?,?,?); ";
            Connection connection = ConnectionDB.getConnectionDB();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, device.getTenLK()); //them data vao ?
            ps.setString(2, device.getNsx());
            ps.setInt(3, device.getGiaLK());
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public void editDevice(Device device){
        try{
            String sql = " update LINHKIEN set TENLK=?,NSX=?,GIALK=? where MALK=? ; ";
            Connection connection = ConnectionDB.getConnectionDB();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, device.getTenLK());
            ps.setString(2, device.getNsx());
            ps.setInt(3, device.getGiaLK());
            ps.setInt(4, device.getMaLK());
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public void deleteDevice(int maLK){
        try{
            String sql = " delete from LINHKIEN where MALK=? ; ";
            Connection connection = ConnectionDB.getConnectionDB();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maLK);
            ps.executeUpdate();
            
            ps.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public List<Device> searchDevice(String tenLK){
        List<Device> list = new ArrayList<>();
        try{
            String sql = " select * from LINHKIEN where TENLK='"+tenLK+"';";
            Connection connection = ConnectionDB.getConnectionDB();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Device device = new Device();
                device.setMaLK(rs.getInt(1));
                device.setTenLK(rs.getString(2));
                device.setNsx(rs.getString(3));
                device.setGiaLK(rs.getInt(4));
                list.add(device);
            }
            rs.close();
            statement.close();    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public Device find(int maLK){
        Device device = new Device();
        try{
            String sql = " select * from LINHKIEN where MALK="+maLK+";";
            Connection connection = ConnectionDB.getConnectionDB();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                device.setMaLK(rs.getInt(1));
                device.setTenLK(rs.getString(2));
                device.setNsx(rs.getString(3));
                device.setGiaLK(rs.getInt(4));
            }
            rs.close();
            statement.close();    
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return device;
    }
    
}
