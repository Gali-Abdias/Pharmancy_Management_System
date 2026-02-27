
package DAO;

import Model.StaffModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibrah
 */
public class StaffDAO {
    private String url = "jdbc:mysql://localhost:3306/pharmacy_management_system_db";
    private String user = "root";
    private String password = "IBRAHIM2525";
    
    //Recording Staff
    public Integer recordStaff(StaffModel stObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO STAFF (staff_id, staff_name, phone, email, address, working_time, username, password, staffRole)" + "values (?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, stObj.getStaff_id());
            pst.setString(2, stObj.getStaff_name());
            pst.setString(3, stObj.getPhone());
            pst.setString(4, stObj.getEmail());
            pst.setString(5, stObj.getAddress());
            pst.setString(6, stObj.getWorking_time());
            pst.setString(7, stObj.getUsername());
            pst.setString(8, stObj.getPassword());
            pst.setString(9, stObj.getStaffRole());
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Staff Recorded Successfully");
            }
            else{
                System.out.println("Staff Not Recorded");
            }
            con.close();
            return rowAffected;
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        return null;
    }
    
        //Updating Staff
    public Integer updateStaff(StaffModel stObj){
         try{
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "UPDATE STAFF SET staff_name=?, phone=?, email=?, address=?, working_time=?, staffRole=? WHERE username=? ";
            
            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(9, stObj.getStaff_id());
            pst.setString(1, stObj.getStaff_name());
            pst.setString(2, stObj.getPhone());
            pst.setString(3, stObj.getEmail());
            pst.setString(4, stObj.getAddress());
            pst.setString(5, stObj.getWorking_time());
            pst.setString(7, stObj.getUsername());
//            pst.setString(7, stObj.getPassword());
            pst.setString(6, stObj.getStaffRole());
            int rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Staff Updated Successfully");
            }
            else{
                System.out.println("Staff Not Updated");
            }
            con.close();
            return rowAffected;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
         return null;
    }
    
    //Deleting Staff
    public Integer deleteStaff(StaffModel stObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            //Statement st = con.createStatement();
            String sql = "DELETE FROM STAFF WHERE staff_id = ? ";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, stObj.getStaff_id());
            
            
            int rowAffected;
            rowAffected = pst.executeUpdate();
            if(rowAffected > 0){
                System.out.println("Staff Deleted Successfully");
            }
            else{
                System.out.println("Staff Not Deleted");
            }
            con.close();
            return rowAffected;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    //Searching for a Staff
    public StaffModel findStaffById(StaffModel stObj){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM staff WHERE staff_id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, stObj.getStaff_id());
            ResultSet rs = pst.executeQuery();
//            Student theStudent = null;
            StaffModel theStaff = new StaffModel();
            boolean isFound = false;
            if(rs.next()){
                theStaff.setStaff_id(rs.getInt("staff_id"));
                theStaff.setStaff_name(rs.getString("staff_name"));
                theStaff.setPhone(rs.getString("phone"));
                theStaff.setEmail(rs.getString("email"));
                theStaff.setAddress(rs.getString("address"));
                theStaff.setWorking_time(rs.getString("working_time"));
                theStaff.setUsername(rs.getString("username"));
                theStaff.setPassword(rs.getString("password"));
                theStaff.setStaffRole(rs.getString("staffRole"));
                isFound = true;
            }
            con.close();
            if(isFound){
                return theStaff;
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<StaffModel> retrieveAllStaff(){
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM staff";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            List<StaffModel> staffList = new ArrayList<>();
            while(rs.next()){
                StaffModel theStaff = new StaffModel();
                theStaff.setStaff_id(rs.getInt("staff_id"));
                theStaff.setStaff_name(rs.getString("staff_name"));
                theStaff.setPhone(rs.getString("phone"));
                theStaff.setEmail(rs.getString("email"));
                theStaff.setAddress(rs.getString("address"));
                theStaff.setWorking_time(rs.getString("working_time"));
                theStaff.setUsername(rs.getString("username"));
                theStaff.setPassword(rs.getString("password"));
                theStaff.setStaffRole(rs.getString("staffRole"));
                staffList.add(theStaff);
            }
            con.close();
            return staffList;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
        public boolean isUsernameUnique(String username) {
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM STAFF WHERE username = ?")) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count == 0; // If count is 0, username is unique; otherwise, it's not unique
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // In case of any error, return false (assuming username is not unique)
    }
    
    public boolean exist(StaffModel stObj) {
    boolean exist = false;
    try (Connection con = DriverManager.getConnection(url, user, password);
         PreparedStatement pst = con.prepareStatement("SELECT * FROM STAFF WHERE username = ?")) {
         pst.setInt(1, stObj.getStaff_id());
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
