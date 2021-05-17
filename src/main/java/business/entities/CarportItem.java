package business.entities;

public class CarportItem {

    private int carportItemID;
    private String name;
    private String description;
    private String unit;
    private int price;
    private int amount;
    private int length;

    public CarportItem(int carportItemID, String name, String description, String unit, int price, int amount, int length) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.price = price;
        this.amount = amount;
        this.length = length;
        this.carportItemID = carportItemID;
    }



    /** getters and setters **/

    public int getCarportItemID() {
        return carportItemID;
    }

    public void setCarportItemID(int carportItemID) {
        this.carportItemID = carportItemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
