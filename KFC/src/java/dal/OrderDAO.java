/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.entity.Cart;
import com.entity.CartItem;
import connectDB.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import model.Customer;
import model.Store;

/**
 *
 * @author Asus
 */
public class OrderDAO {

    private final DBContext db;

    public OrderDAO() throws Exception {
        db = new DBContext();
    }

    public void addOrder(Customer c, Cart cart, int store_id) {
        LocalDate currDate = LocalDate.now();
        String date = currDate.toString();
        Connection connection = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        try {
            String sql = "Insert into [Order] values(?,?,?,?)";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getCustomer_id());
            ps.setInt(2, store_id);
            ps.setDouble(3, cart.getTotal());
            ps.setString(4, date);
            ps.executeUpdate();
            String sql1 = "Select top 1  order_id from [Order] order by order_id desc";
            ps1 = connection.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt("order_id");
                for (CartItem i : cart.getCartItems()) {
                    String sql2 = "insert into [OrderDetail] values (?,?,?,?) ";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getDish().getDish_id());
                    st2.setInt(3, i.getQuantity());
                    st2.setInt(4, i.getDish().getPrice());
                    st2.executeUpdate();
                }
            }

        } catch (Exception ex) {

        }
    }
}
