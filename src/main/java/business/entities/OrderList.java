package business.entities;

import java.util.List;

public class OrderList {

    private List<Material> materialList;
    private int totalPriceOfCarport;


    public OrderList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public void calculatePriceOfMaterials(){

        for (Material i: materialList) {
            totalPriceOfCarport += i.getTotalPrice();
        }
    }




    /** getters and setters **/

    public int getTotalPriceOfCarport() {
        return totalPriceOfCarport;
    }

    public void setTotalPriceOfCarport(int totalPriceOfCarport) {
        this.totalPriceOfCarport = totalPriceOfCarport;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
