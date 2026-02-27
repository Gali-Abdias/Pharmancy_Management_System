
package Model;

/**
 *
 * @author ibrah
 */
public class StaffModel {
    private int staff_id;
    private String staff_name;
    private String phone;
    private String email;
    private String address;
    private String working_time;
    private String username;
    private String password;
    private String staffRole;

    public StaffModel() {
    }

    public StaffModel(int staff_id, String staff_name, String phone, String email, String address, String working_time) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.working_time = working_time;
        this.username = username;
        this.password = password;
        this.staffRole = staffRole;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorking_time() {
        return working_time;
    }

    public void setWorking_time(String working_time) {
        this.working_time = working_time;
    }
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getStaffRole(){
        return staffRole;
    }
    
    public void setStaffRole(String staffRole){
        this.staffRole = staffRole;
    }
}
