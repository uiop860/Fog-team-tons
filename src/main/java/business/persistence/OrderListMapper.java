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

            String sql = "";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ResultSet resultSet = ps.executeQuery();

                int carportItemID;
                String name;
                String description;
                String unit;
                int price;
                int amount;
                int length;


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
