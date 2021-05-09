package business.entities;

public class Fsp
{
    private int id;
    private int width;
    private int length;
    private String name;
    private String Address;
    private int houseNr;
    private int zipcode;
    private String city;
    private int phone;
    private String email;

    public Fsp(int id, int width, int length, String name, String address, int houseNr, int zipcode, String city, int phone, String email)
    {
        this.id = id;
        this.width = width;
        this.length = length;
        this.name = name;
        Address = address;
        this.houseNr = houseNr;
        this.zipcode = zipcode;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return Address;
    }

    public void setAddress(String address)
    {
        Address = address;
    }

    public int getHouseNr()
    {
        return houseNr;
    }

    public void setHouseNr(int houseNr)
    {
        this.houseNr = houseNr;
    }

    public int getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
