
package Model;

/**
 *
 * @author ibrah
 */
public class SellModel {
    private int sell_id;
    private int seller_id;
    private String med_id;
    private float price;
    private int quantity;

    public SellModel() {
    }

    public SellModel(int sell_id, int seller_id, String med_id, float price, int quantity) {
        this.sell_id = sell_id;
        this.seller_id = seller_id;
        this.med_id = med_id;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSell_id() {
        return sell_id;
    }

    public void setSell_id(int sell_id) {
        this.sell_id = sell_id;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
