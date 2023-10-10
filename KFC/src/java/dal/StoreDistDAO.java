/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import connectDB.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.internal.vm.vector.VectorSupport.store;
import model.Store;
import model.StoreDistance;

/**
 *
 * @author Asus
 */
public class StoreDistDAO {
     private final DBContext db;
    
    public StoreDistDAO() throws Exception {
        db = new DBContext();
    }
    public ArrayList<StoreDistance> getAll() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "SELECT store_id, latitude, longtitude FROM Store";
            connection = db.getConnection();
            ps = connection.prepareStatement(sql);
            
            ArrayList<StoreDistance> list = new ArrayList<>();
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                StoreDistance storeD = new StoreDistance();
                storeD.setStore_id(rs.getInt("store_id"));
                storeD.setLatitude(rs.getDouble("latitude"));
                storeD.setLongtitude(rs.getDouble("longtitude"));
               
                
                list.add(storeD);
            }
            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(StoreDistDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
           
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreDistDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreDistDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StoreDistDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return null;
    }
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
    final int R = 6371; // Bán kính của Trái Đất ở đơn vị kilômét

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);

    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    double distance = R * c; // Khoảng cách ở đơn vị kilômét

    return distance;
}
}
