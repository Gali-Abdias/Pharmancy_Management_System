
package View;

import DAO.SellDAO;
import Model.SellModel;
import java.util.Scanner;

/**
 *
 * @author ibrah
 */
public class SellView {
    public static void main(String[] args) throws Exception{
        boolean condition = true;
        while(condition){
            System.out.println("Pharmacy Management System");
            System.out.println("==========================");
            System.out.println("1. Record Sell");
            System.out.println("2. Update Sell");
            System.out.println("3. Delete Sell");
            System.out.println("0. Exit");
            System.out.println("Choose (0-3)");
            
            int choice;
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            
            switch(choice){
                case 1:
                    
                    System.out.println("Sell Record");
                    System.out.println("===========");
                    System.out.println("Enter Sell Id");
                    int sell_id = input.nextInt();
                    int seller_id;
                    String med_id;
                    float price;                    
                    int quantity;

                    
                    
//                    if (medicine_id.length() != 5){
//                        System.out.println("Out of the length, put 5 characters ID");
//                    }
//                    else{
                       SellModel theSell = new SellModel();
                       theSell.setSell_id(sell_id);
                       SellDAO dao = new SellDAO();
                        if (dao.exist(theSell)){
                            System.out.println("This Sell of "+sell_id+" Exist. Please Try another Id");
                        }
                        else{
                        
                            System.out.print("Enter Seller ID: ");
                            seller_id = input.nextInt();
                            System.out.print("Enter Medicine ID: ");
                            med_id = input.next();
                            System.out.print("Enter Price: ");
                            price = input.nextFloat();                           
                            System.out.println("Enter Medicine Quantity To Sell");
                            quantity = input.nextInt();                        

                            theSell.setSeller_id(seller_id);
                            theSell.setMed_id(med_id);
                            theSell.setPrice(price);
                            theSell.setQuantity(quantity);
                            theSell.setPrice(price);
                            dao.recordSell(theSell);
                        }
                    //}
                    
                    // check if user wish to continue
                    toContinue();
                    break;


        
                case 2:                    
                    System.out.println("Update Sell");
                    System.out.println("===========");
                    System.out.println("Enter Sell ID to Update");
                    sell_id = input.nextInt();
                    theSell = new SellModel();
                    dao = new SellDAO();
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
                    
                    System.out.println("Enter Seller ID to Update");
                    seller_id = input.nextInt();
                    System.out.println("Enter The Medicine ID to Update");
                    med_id = input.next();
                    System.out.println("Enter The Price to Update");
                    price = input.nextFloat();                    
                    System.out.println("Enter The Quantity to Update");
                    quantity = input.nextInt();                   
                    
                    //Create Model Object
                    theSell = new SellModel();
                    theSell.setSell_id(sell_id);
                    theSell.setSeller_id(seller_id);
                    theSell.setMed_id(med_id);
                    theSell.setPrice(price);
                    theSell.setQuantity(quantity);
                    
                    //Send Model to Dao
                    dao = new SellDAO();
                    dao.updateSell(theSell);
                    
                    //Check if user wish to continue
                    toContinue();
                    break;
                
                case 3:
                    System.out.println("Delete Sell");
                    System.out.println("===========");
                    System.out.println("Enter Sell ID to delete");
                    sell_id = input.nextInt();
                    
                    //Create Model Obj
                    theSell = new SellModel();
                    theSell.setSell_id(sell_id);
                    
                    
                    //Send Model to Dao
                    dao = new SellDAO();
                    dao.deleteSell(theSell);
                    
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
