/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Common;

import DAO.PharmacyUtils;
import java.io.File;
import javax.swing.JOptionPane;
//import java.lang.runtime.ObjectMethods;

/**
 *
 * @author ibrah
 */
public class OpenPdf {
    public static void openById(String id)throws Exception{
        try{
            if((new File(PharmacyUtils.billPath+id+".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler "+PharmacyUtils.billPath+""+id+".pdf");
                        
            }else{
                JOptionPane.showMessageDialog(null, "File does not Exist");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
