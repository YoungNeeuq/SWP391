/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import connectDB.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class InvoiceDAO {
     private final DBContext db;

 public InvoiceDAO() throws Exception {
 db = new DBContext();
 }
 public void add(String name, int quantity, String address, String phoneNumber, int price, int customer_id, int order_id) {
    Connection connection = null;
    PreparedStatement ps = null;
    
    try {
        String sql = "  insert into Invoice (nameOfDish, numOfDish, address,store_phoneNumber, invoice_price, customer_id, order_id)\n" +
"  values (?,?,?,?,?,?,?)";
        connection = db.getConnection();
        ps = connection.prepareStatement(sql);
        
        // Kiểm tra và đặt các giá trị đầu vào
        ps.setString(1, name);
        ps.setInt(2, quantity);
        ps.setString(3, address);
        ps.setString(4, phoneNumber);
        ps.setInt(5, price);
        ps.setInt(6, customer_id);
        ps.setInt(7,order_id);
        
        // Thực hiện truy vấn
        ps.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Đóng PreparedStatement và Connection trong khối finally để đảm bảo giải phóng tài nguyên
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                // Xử lý lỗi đóng PreparedStatement
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                // Xử lý lỗi đóng Connection
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
}
