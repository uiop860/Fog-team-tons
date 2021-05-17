package business.persistence;

import business.entities.Material;
import business.entities.OrderList;
import business.exceptions.UserException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderListMapper {

    private Database database;

    public OrderListMapper(Database database) {
        this.database = database;
    }


    public OrderList getMaterialsFromDB() throws UserException {


        try (Connection connection = database.connect()) {

            String sql = "SELECT material.material_id, material.unit_id, material.category_id, material.material_name, material.description, material.price, u.unit_name, c.category_name FROM " +
                         "material m" +
                         "INNER JOIN unit u ON m.unit_id = u.unit_id" +
                         "INNER JOIN category c  ON m.category_id = c.category_id;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                List<Material> materialList = new ArrayList<>();
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int materialID = rs.getInt("material_id");
                    String name = rs.getString("material_name");
                    String description = rs.getString("description");
                    String unit = rs.getString("unit_name");
                    double price = rs.getDouble("price");
                    String category = rs.getString("category_name");

                    materialList.add(new Material(materialID,name,description,unit,price,category));
                }

                OrderList orderList = new OrderList(materialList);

                return orderList;
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }
    }

    public OrderList calculateCarport(int carportWidth, int carportLength) throws UserException {

        OrderList orderList = getMaterialsFromDB();

        List<Material> materialList = orderList.getMaterialList();

        for (Material i: materialList) {
            i.calculateAmountAndPrice(carportWidth,carportLength);

        }
        return orderList;
    }
}























