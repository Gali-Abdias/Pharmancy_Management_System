
package View;

import DAO.MedicineDAO;
import Model.MedicineModel;
import java.util.Scanner;

/**
 *
 * @author ibrah
 */
public class MedicineView {
    public static void main(String[] args) throws Exception{
        boolean condition = true;
        while(condition){
            System.out.println("Pharmacy Management System");
            System.out.println("==========================");
            System.out.println("1. Record Medicine");
            System.out.println("2. Update Medicine");
            System.out.println("3. Delete Medicine");
            System.out.println("0. Exit");
            System.out.println("Choose (0-3)");
            
            int choice;
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                    
                    System.out.println("Medicine Record");
                    System.out.println("================");
                    System.out.println("Enter Medicine Id");
                    String medicine_id = input.next();
                    String medicine_name;
                    String country;
                    String man_date;
                    String exp_date;
                    int quantity;
                    float price;
                    
                    
//                    if (medicine_id.length() != 5){
//                        System.out.println("Out of the length, put 5 characters ID");
//                    }
//                    else{
                       MedicineModel theMedicine = new MedicineModel();
                       theMedicine.setMedicine_id(medicine_id);
                       MedicineDAO dao = new MedicineDAO();
                        if (dao.exist(theMedicine)){
                            System.out.println("This Medicine of "+medicine_id+" Exist. Please Try another Id");
                        }
                        else{
                        
                            System.out.print("Enter Medicine name: ");
                            medicine_name = input.next();
                            System.out.print("Enter Production Country: ");
                            country = input.next();
                            System.out.print("Enter Medicine Manifucture Date: ");
                            man_date = input.next();
                            System.out.print("Enter Medicine Expiration Date: ");
                            exp_date = input.next();
                            System.out.println("Enter Medicine Quantity");
                            quantity = input.nextInt();
                            System.out.println("Enter Medicine Price");
                            price = input.nextFloat();

                            theMedicine.setMedicine_name(medicine_name);
                            theMedicine.setCountry(country);
                            theMedicine.setMan_date(man_date);
                            theMedicine.setExp_date(exp_date);
                            theMedicine.setQuantity(quantity);
                            theMedicine.setPrice(price);
                            dao.recordMedicine(theMedicine);
                        }
                    //}
                    
                    // check if user wish to continue
                    toContinue();
                    break;


        
                case 2:                    
                    System.out.println("Update Medicine");
                    System.out.println("===============");
                    System.out.println("Enter Medicine ID to Update");
                    medicine_id = input.next();
                    theMedicine = new MedicineModel();
                    dao = new MedicineDAO();
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
                    
                    System.out.println("Enter Medicine Name to Update");
                    medicine_name = input.next();
                    System.out.println("Enter The Production Country to Update");
                    country = input.next();
                    System.out.println("Enter The Manifucture Date to Update");
                    man_date = input.next();
                    System.out.println("Enter The Expiration Date to Update");
                    exp_date = input.next();
                    System.out.println("Enter The Quantity to Update");
                    quantity = input.nextInt();
                    System.out.println("Enter The Price to Update");
                    price = input.nextFloat();
                    
                    //Create Model Object
                    theMedicine = new MedicineModel();
                    theMedicine.setMedicine_id(medicine_id);
                    theMedicine.setMedicine_name(medicine_name);
                    theMedicine.setCountry(country);
                    theMedicine.setMan_date(man_date);
                    theMedicine.setExp_date(exp_date);
                    theMedicine.setQuantity(quantity);
                    theMedicine.setPrice(price);
                    
                    //Send Model to Dao
                    dao = new MedicineDAO();
                    dao.updateMedicine(theMedicine);
                    
                    //Check if user wish to continue
                    toContinue();
                    break;
                
                case 3:
                    System.out.println("Delete Medicine");
                    System.out.println("===============");
                    System.out.println("Enter Medicine ID to delete");
                    medicine_id = input.next();
                    
                    //Create Model Obj
                    theMedicine = new MedicineModel();
                    theMedicine.setMedicine_id(medicine_id);
                    
                    
                    //Send Model to Dao
                    dao = new MedicineDAO();
                    dao.deleteMedicine(theMedicine);
                    
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
