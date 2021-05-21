package business.entities;

import java.text.DecimalFormat;

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
    private double spacing = 0;
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
            case 1: //materialID = 1 = pole
                calculatePole(carportLength);
                break;

            case 2: //materialID = 2 = raft
                calculateRafters(carportWidth,carportLength);
                break;

            case 3: //materialID = 3 = roof
                calculateRoof(carportWidth,carportLength);
                break;

            case 4: //materialID = 4 = beam on long side
                calculateBeamOnLongSide(carportLength);
                break;

            case 5: //materialID = 4 = beam on broadside
                calculateBeamOnBroadSide(carportWidth);
                break;
        }
    }

    public void calculatePole(double carportLength){
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
    }

    public void calculateRafters(double carportWidth, double carportLength ){
        int raftersSplitter = 55;
        amount = (int) Math.ceil(carportLength/raftersSplitter);
        amount += 1;
        double rafterSpacingAmount = amount - 1;
        double raftersSpacing = (carportLength/rafterSpacingAmount);
        spacing = raftersSpacing;
        length = (int)carportWidth;

        totalPrice = Double.parseDouble(new DecimalFormat("#.##").format((length*price)*amount));

    }

    public void calculateRoof(double carportWidth, double carportLength){
        int roofPlateSplitter = 100;
        amount =  (int)Math.ceil(carportWidth/roofPlateSplitter);
        lastRoofPlateWidth = (int)carportWidth % roofPlateSplitter;
        length = (int)carportLength;

        totalPrice = Double.parseDouble(new DecimalFormat("#.##").format((length*price)*amount));
    }

    public void calculateBeamOnLongSide(double carportLength){
        int beamAmountOnLongSide = 2; //hvis carporten er firkantet er der altid 2
        amount = beamAmountOnLongSide;
        length = (int)carportLength;

        totalPrice = Double.parseDouble(new DecimalFormat("#.##").format((length*price)*amount));
    }

    public void calculateBeamOnBroadSide(double carportWidth){
        int beamAmountOnBroadSide = 2; //hvis carporten er firkantet er der altid 2
        amount = beamAmountOnBroadSide;
        length = (int)carportWidth;

        totalPrice = Double.parseDouble(new DecimalFormat("#.##").format((length*price)*amount));
    }


    /** getters and setters **/

    public double getSpacing() {
        return spacing;
    }

    public void setSpacing(double spacing) {
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
