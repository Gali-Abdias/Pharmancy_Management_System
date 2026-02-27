
package View;

import DAO.StaffDAO;
import Model.StaffModel;
import java.util.Scanner;

/**
 *
 * @author ibrah
 */
public class StaffView {
    public static void main(String[] args) throws Exception{
        boolean condition = true;
        while(condition){
            System.out.println("Staff Management System");
            System.out.println("=======================");
            System.out.println("1. Record New User");
            System.out.println("2. Update User's Info");
            System.out.println("3. Delete User");
            System.out.println("0. Exit");
            System.out.println("Choose (0-3)");
            
            int choice;
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                    
                    System.out.println("User Record");
                    System.out.println("===========");
                    System.out.println("Enter Staff username");
                    String username = input.next();
                    String role = null;
                    String staff_name;
                    String phone;
                    String email;
                    String address;
                    String working_time;
                    String password;
                    int staff_id;
                    
                    
                    
//                    if (medicine_id.length() != 5){
//                        System.out.println("Out of the length, put 5 characters ID");
//                    }
//                    else{
                       StaffModel theStaff = new StaffModel();
                       theStaff.setUsername(username);
                       StaffDAO dao = new StaffDAO();
                        if (dao.exist(theStaff)){
                            System.out.println("This User of "+username+" Exist. Please Try another username");
                        }
                        else{
                            System.out.print("Enter User Role: ");
                            role = input.next();
                            System.out.print("Enter User name: ");
                            staff_name = input.next();
                            System.out.print("Enter Phone Number: ");
                            phone = input.next();
                            System.out.print("Enter Email: ");
                            email = input.next();
                            System.out.print("Enter Address: ");
                            address = input.next();
                            System.out.print("Enter Working Time: ");
                            working_time = input.next(); 
                            System.out.print("Enter Password: ");
                            password = input.next(); 
                            
                            theStaff.setStaffRole(role);
                            theStaff.setStaff_name(staff_name);
                            theStaff.setPhone(phone);
                            theStaff.setEmail(email);
                            theStaff.setAddress(address);
                            theStaff.setWorking_time(working_time);
                            theStaff.setPassword(password);
                            dao.recordStaff(theStaff);
                        }
                    //}
                    
                    // check if user wish to continue
                    toContinue();
                    break;



        
                case 2:                    
                    System.out.println("Update User");
                    System.out.println("===========");
                    System.out.println("Enter Username to Update");
                    username = input.next();
                    theStaff = new StaffModel();
                    dao = new StaffDAO();
//                    if(dao.exist(theMedicine)){
//                        System.out.println("Enter Student Name to Update");
//                        Names = input.next();
//                        System.out.println("Enter Student Age to Update");
//                        Age = input.nextInt();
//                        
//                        //thestudent.setStudentId(studentId);
//                        thestudent.setNames(Names);
//                        thestudent.setAge(Age);
//                        dao.updateStudentByPreparedStatement(thestudent);
//                    }
//                    else{
//                        System.out.println("The Provided ID Does not Exist");
//                    }
                    System.out.println("Enter The Staff Role to Update");
                    role = input.next();
                    System.out.println("Enter User Name to Update");
                    staff_name = input.next();
                    System.out.println("Enter The Phone Number to Update");
                    phone = input.next();
                    System.out.println("Enter The Email to Update");
                    email = input.next();
                    System.out.println("Enter The Address to Update");
                    address = input.next();
                    System.out.println("Enter The Working Time to Update");
                    working_time = input.next();
                    System.out.println("Enter The Password to Update");
                    password = input.next();
                    
                    
                    //Create Model Object
                    theStaff = new StaffModel();
                    theStaff.setStaffRole(role);
                    theStaff.setUsername(username);
                    theStaff.setStaff_name(staff_name);
                    theStaff.setPhone(phone);
                    theStaff.setEmail(email);
                    theStaff.setAddress(address);
                    theStaff.setWorking_time(working_time);
                    theStaff.setPassword(password);
                    
                    //Send Model to Dao
                    dao = new StaffDAO();
                    dao.updateStaff(theStaff);
                    
                    //Check if user wish to continue
                    toContinue();
                    break;
                
                case 3:
                    System.out.println("Delete User");
                    System.out.println("===========");
                    System.out.println("Enter Uesr ID to delete");
                    staff_id = input.nextInt();
                    
                    //Create Model Obj
                    theStaff = new StaffModel();
                    theStaff.setStaff_id(staff_id);
                    
                    
                    //Send Model to Dao
                    dao = new StaffDAO();
                    dao.deleteStaff(theStaff);
                    
                    //Check if user wish to continue
                    toContinue();                    
                    break;
                
                case 0:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    System.out.println("You made a wrong choice, please try again with a valid input");
                    toContinue();
            }
        }
    }    

 
    public static boolean toContinue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wish to continue?");
        System.out.println("Type yes to continue or hit any key to quit");
        String anwser = sc.next();
        if(anwser.equalsIgnoreCase("Yes")){
            return true;
        }
        else{
            System.out.println("Thank you for using our system");
            return false;
        }
    }
}
