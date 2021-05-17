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


    public OrderList calculateCarport(double carportWidth, double carportLength, int requestID) throws UserException {

        OrderList orderList = getMaterialsFromDB();

        List<Material> materialList = orderList.getMaterialList();

        for (Material i : materialList) {
            i.calculateAmountAndPrice(carportWidth, carportLength);
        }

        orderList.calculatePriceOfMaterials();
        insertOrderListIntoDB(orderList, requestID);
        insertTotalPriceOfCarportIntoDB(orderList,requestID);

        return orderList;
    }

    public void insertTotalPriceOfCarportIntoDB(OrderList orderList,int requestID) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "UPDATE fog_db.request SET total_carport_price = ? WHERE request_id = ?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,orderList.getTotalPriceOfCarport()); //TODO: gør så prisen ikke har mere end 2 decimaler
                ps.setInt(2,requestID);
                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }

    }

    public void insertOrderListIntoDB(OrderList orderList, int requestID) throws UserException {

        try (Connection connection = database.connect()) {

            List<Material> materialList = orderList.getMaterialList();
            for (Material i : materialList) {

                String sql = "INSERT INTO fog_db.orderlist(request_id,material_id,amount,total_material_price) VALUES (?,?,?,?);";

                try (PreparedStatement ps = connection.prepareStatement(sql)) {

                    ps.setInt(1, requestID);
                    ps.setInt(2,i.getMaterialID());
                    ps.setInt(3,i.getAmount());
                    ps.setDouble(4,i.getTotalPrice()); //TODO: gør så prisen ikke har mere end 2 decimaler
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    throw new UserException(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public OrderList getMaterialsFromDB() throws UserException {


        try (Connection connection = database.connect()) {

            String sql = "SELECT material.material_id, material.unit_id, material.category_id, material.material_name, material.description, material.price, u.unit_name, c.category_name " +
                    "FROM material " +
                    "INNER JOIN unit u ON material.unit_id = u.unit_id " +
                    "INNER JOIN category c  ON material.category_id = c.category_id;";

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

                    materialList.add(new Material(materialID, name, description, unit, price, category));
                }

                OrderList orderList = new OrderList(materialList);

                return orderList;
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }


}























