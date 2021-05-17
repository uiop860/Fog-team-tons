package business.entities;

public class Material {

    private int materialID;
    private String name;
    private String description;
    private String unit;
    private double price;
    private int amount = 0;
    private int length;
    private String category;
    private double totalPrice;
    private int spacing = 0;
    private int lastRoofPlateWidth = 0;

    public Material(int materialID, String name, String description, String unit, double price, String category) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.price = price;
        this.materialID = materialID;
        this.category = category;
    }


    public void calculateAmountAndPrice(double carportWidth, double carportLength){

        switch (materialID){
            case 1:
                double lengthAfterMinus = carportLength-120;
                int postSplitter = 310;
                int cornerPosts = 2;
                int postSpacing;
                int postLength = 300; //default value of posts

                if (lengthAfterMinus < postSplitter * 2 && lengthAfterMinus > postSplitter) {
                    amount = 1;

                }else if(lengthAfterMinus < postSplitter * 3 && lengthAfterMinus > postSplitter * 2){
                    amount = 2;
                }

                if(amount == 0){
                    postSpacing = (int)lengthAfterMinus;
                } else {
                    postSpacing =  (int)lengthAfterMinus/(amount+1);
                }

                spacing = postSpacing;
                amount += cornerPosts;
                amount *= 2;
                length = postLength;

                totalPrice = (length*price)*amount;

                break;

            case 2:
                int raftersSplitter = 55;
                amount = (int) Math.ceil(carportLength/raftersSplitter);
                int raftersSpacing = (int)(carportLength/amount);
                spacing = raftersSpacing;
                length = (int)carportWidth;

                totalPrice = (length*price)*amount;

                break;

            case 3:
                int roofPlateSplitter = 100;
                amount =  (int)Math.ceil(carportWidth/roofPlateSplitter);
                lastRoofPlateWidth = (int)carportWidth % roofPlateSplitter;
                length = (int)carportLength;

                totalPrice = (length*price)*amount;

                break;

            case 4:
                int beamAmountOnLongSide = 2; //hvis carporten er firkantet er der altid 2
                amount = beamAmountOnLongSide;
                length = (int)carportLength;

                totalPrice = (length*price)*amount;

                break;
            case 5:
                int beamAmountOnBroadSide = 2; //hvis carporten er firkantet er der altid 2
                amount = beamAmountOnBroadSide;
                length = (int)carportWidth;

                totalPrice = (length*price)*amount;

                break;
        }
    }




    /** getters and setters **/

    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }

    public int getLastRoofPlateWidth() {
        return lastRoofPlateWidth;
    }

    public void setLastRoofPlateWidth(int lastRoofPlateWidth) {
        this.lastRoofPlateWidth = lastRoofPlateWidth;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMaterialID() {
        return materialID;
    }

    public void setMaterialID(int materialID) {
        this.materialID = materialID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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