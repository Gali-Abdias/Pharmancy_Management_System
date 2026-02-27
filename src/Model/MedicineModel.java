
package Model;

/**
 *
 * @author ibrah
 */
public class MedicineModel {
    private String medicine_id;
    private String medicine_name;
    private String country;
    private String man_date;
    private String exp_date;
    private int quantity;
    private float price;

    public MedicineModel() {
    }

    public MedicineModel(String medicine_id, String medicine_name, String country, String man_date, String exp_date, int quantity, float price) {
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.country = country;
        this.man_date = man_date;
        this.exp_date = exp_date;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(String medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMan_date() {
        return man_date;
    }

    public void setMan_date(String man_date) {
        this.man_date = man_date;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
