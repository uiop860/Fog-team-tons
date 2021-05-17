package business.persistence;

import business.exceptions.UserException;

import java.sql.*;

public class OrderListMapper {

    private Database database;

    public OrderListMapper(Database database) {
        this.database = database;
    }


    public void calculateCarport(int carportWidthID, int carportLengthID) throws UserException {


        try (Connection connection = database.connect()) {

            String sql = "SELECT m.material_id, m.unit_id, m.category_id, m.material_name, m.description, m.price, u.unit_name, c.category_name FROM " +
                    "material m" +
                    "INNER JOIN unit u ON m.unit_id = u.unit_id" +
                    "INNER JOIN category c  ON m.category_id = c.category_id;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int materialID = rs.getInt("material_id");
                    String name = rs.getString("material_name");
                    String description = rs.getString("description");
                    String unit = rs.getString("unit_name");
                    double price = rs.getDouble("price");
                    int amount = rs.getInt("amount");
                    int length = rs.getInt("length");
                }

            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }

    }
}
