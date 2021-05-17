package business.entities;

public class Request {


    private int requestID;
    private int carportWidthID;
    private int carportLengthID;
    private int carportWidth;
    private int carportLength;
    private String name;
    private String road;
    private int houseNumber;
    private int zipcode;
    private String city;
    private int phone;
    private String email;
    private int employeeID;
    private double total_price;

    public Request(int carportWidthID, int carportLengthID, String name, String road, int houseNumber, int zipcode, String city, int phone, String email) {
        this.carportWidthID = carportWidthID;
        this.carportLengthID = carportLengthID;
        this.name = name;
        this.road = road;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }


    public double getTotal_price()
    {
        return total_price;
    }

    public void setTotal_price(double total_price)
    {
        this.total_price = total_price;
    }

    /** getters and setters **/



    public int getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(int carportWidth) {
        this.carportWidth = carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(int carportLength) {
        this.carportLength = carportLength;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getCarportWidthID() {
        return carportWidthID;
    }

    public void setCarportWidthID(int carportWidthID) {
        this.carportWidthID = carportWidthID;
    }

    public int getCarportLengthID() {
        return carportLengthID;
    }

    public void setCarportLengthID(int carportLengthID) {
        this.carportLengthID = carportLengthID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
