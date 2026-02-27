/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibrah
 */
public class BillModel {
    private int bill_pk;
    private String billID;
    private String billDate;
    private int totalPaid;
    private String generatedBy;

    public BillModel() {
    }

    public BillModel(int bill_pk, String billID, String billDate, int totalPaid, String generatedBy) {
        this.bill_pk = bill_pk;
        this.billID = billID;
        this.billDate = billDate;
        this.totalPaid = totalPaid;
        this.generatedBy = generatedBy;
    }

    public int getBill_pk() {
        return bill_pk;
    }

    public void setBill_pk(int bill_pk) {
        this.bill_pk = bill_pk;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        this.totalPaid = totalPaid;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }
    
}
