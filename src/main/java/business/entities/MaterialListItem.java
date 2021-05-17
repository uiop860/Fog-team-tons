package business.entities;

public class MaterialListItem
{
    private int amount;
    private double total_material_price;
    private String material_name;
    private String description;

    public MaterialListItem(int amount, double total_material_price, String material_name, String description)
    {
        this.amount = amount;
        this.total_material_price = total_material_price;
        this.material_name = material_name;
        this.description = description;
    }


    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public double getTotal_material_price()
    {
        return total_material_price;
    }

    public void setTotal_material_price(double total_material_price)
    {
        this.total_material_price = total_material_price;
    }

    public String getMaterial_name()
    {
        return material_name;
    }

    public void setMaterial_name(String material_name)
    {
        this.material_name = material_name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
