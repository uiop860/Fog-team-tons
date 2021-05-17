package business.entities;

import java.util.List;

public class OrderList {

    private List<Material> materialList;


    public OrderList(List<Material> materialList) {
        this.materialList = materialList;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
