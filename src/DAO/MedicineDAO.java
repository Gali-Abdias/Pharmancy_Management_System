
package DAO;

import Model.MedicineModel;
import java.sql.*;

/**
 *
 * @author ibrah
 */
public class MedicineDAO {
    private String url = "jdbc:mysql://localhost:3306/pharmacy_management_system_db";
    private String user = "root";
    private String password = "IBRAHIM2525";
    
    //Recording Medicine
    public void recordMedicine(MedicineModel medObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            String sql = "INSERT INTO MEDICINE (medicine_id, medicine_name, country, man_date, exp_date, quantity, price)" + "values (?,?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, medObj.getMedicine_id());
            pst.setString(2, medObj.getMedicine_name());
            pst.setString(3, medObj.getCountry());
            pst.setString(4, medObj.getMan_date());
            pst.setString(5, medObj.getExp_date());
            pst.setInt(6, medObj.getQuantity());
            pst.setFloat(7, medObj.getPrice());
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Medicine Recorded Successfully");
            }
            else{
                System.out.println("Medicine Not Recorded");
            }
            con.close();
        }catch(Exception ex){
        ex.printStackTrace();
        }
    }
    
        //Updating Medicine
    public void updateMedicine(MedicineModel medObj){
         try{
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            String sql = "UPDATE MEDICINE SET medicine_name=?, country=?, man_date=?, exp_date=?, quantity=?, price=? WHERE medicine_id=? ";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(7, medObj.getMedicine_id());
            pst.setString(1, medObj.getMedicine_name());
            pst.setString(2, medObj.getCountry());
            pst.setString(3, medObj.getMan_date());
            pst.setString(4, medObj.getExp_date());
            pst.setInt(5, medObj.getQuantity());
            pst.setFloat(6, medObj.getPrice());
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Medicine Updated Successfully");
            }
            else{
                System.out.println("Medicine Not Updated");
            }
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    //Deleting Medicine
    public void deleteMedicine(MedicineModel medObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            //Statement st = con.createStatement();
            String sql = "DELETE FROM MEDICINE WHERE medicine_id = ? ";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, medObj.getMedicine_id());
            
            
            int rowAffected;
            rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Medicine Deleted Successfully");
            }
            else{
                System.out.println("Medicine Not Deleted");
            }
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public boolean exist(MedicineModel medObj) {
    boolean exist = false;
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement("SELECT * FROM MEDICINE WHERE medicine_id = ?")) {
         pst.setString(1, medObj.getMedicine_id());
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
