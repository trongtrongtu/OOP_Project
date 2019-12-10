package connectionDB;

        import java.sql.*;

public class ConnectionDB {
    public static Connection getConnectionDB() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=oop_project","sa","admin");
        return connection;
        /*
        Su dung Tomcat. va SQL Server
        url : jdbc:sqlserver://localhost:1433
        databaseName : < ten db can ket noi>
        user : sa ; password: 1234 : Do moi nguoi dat trong SQL Server

        Khi can tao connection den database :
        Connection connection = ConnectionDB.getConnectionDB;
        Statement statement = connection.createStatement;
        ...
         */

    }
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectionDB.getConnectionDB();

        String tenKH ="Tuan";
        String dienThoai = "0969034989";
        String email ="tuan.la173445@sis.hust.edu.vn";
        String diaChi ="Bach Khoa";
        // Thuc hien truy van tham so
        String sql = "insert into KHACHHANG(TENKH, DIENTHOAI, EMAIL, DIACHI) values ('Tuan', 'a','a','a');";
        Statement statement = connection.createStatement();
        // Them tham so vao "?"


        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println(resultSet.getString("TENKH"));
        }
    }
}
