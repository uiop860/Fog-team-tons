package business.entities;

public class Address
{


    private String road;
    private int houseNumber;
    private String city;
    private int zipCode;
    private int phone;
    private String name;

    public Address(String road, int houseNumber, String city, int zipCode, int phone, String name)
    {
        this.road = road;
        this.houseNumber = houseNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.name = name;
    }


    /** getters and setters **/

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRoad()
    {
        return road;
    }

    public void setRoad(String road)
    {
        this.road = road;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }
}
