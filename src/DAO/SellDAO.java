
package DAO;

import Model.SellModel;
import java.sql.*;

/**
 *
 * @author ibrah
 */
public class SellDAO {
    private String url = "jdbc:mysql://localhost:3306/pharmacy_management_system_db";
    private String user = "root";
    private String password = "IBRAHIM2525";
    
    //Recording Sell
    public void recordSell(SellModel slObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            //Statement st = con.createStatement();
            String sql = "INSERT INTO SELL (sell_id, seller_id, med_id, price, quantity)" + "values (?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, slObj.getSell_id());
            pst.setInt(2, slObj.getSeller_id());
            pst.setString(3, slObj.getMed_id());
            pst.setFloat(4, slObj.getPrice());
            pst.setInt(5, slObj.getQuantity());
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Sell Recorded Successfully");
            }
            else{
                System.out.println("Sell Not Recorded");
            }
            con.close();
        }catch(Exception ex){
        ex.printStackTrace();
        }
    }
    
        //Updating Sell
    public void updateSell(SellModel slObj){
         try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            String sql = "UPDATE SELL SET seller_id=?, med_id=?, price=?, quantity=? WHERE sell_id=? ";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(5, slObj.getSell_id());
            pst.setInt(1, slObj.getSeller_id());
            pst.setString(2, slObj.getMed_id());
            pst.setFloat(3, slObj.getPrice());
            pst.setInt(4, slObj.getQuantity());
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Sell Updated Successfully");
            }
            else{
                System.out.println("Sell Not Updated");
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //Deleting Sell
    public void deleteSell(SellModel slObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            //Statement st = con.createStatement();
            String sql = "DELETE FROM SELL WHERE sell_id = ? ";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, slObj.getSell_id());
            
            
            int rowAffected;
            rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Sell Deleted Successfully");
            }
            else{
                System.out.println("Sell Not Deleted");
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean exist(SellModel slObj) {
    boolean exist = false;
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement("SELECT * FROM SELL WHERE sell_id = ?")) {
         pst.setInt(1, slObj.getSell_id());
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                exist = true;
            }
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return exist;
    }
}
