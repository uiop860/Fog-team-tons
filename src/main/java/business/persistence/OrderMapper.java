package business.persistence;

import business.entities.Address;
import business.entities.User;
import business.exceptions.UserException;
import java.sql.*;

public class OrderMapper {

    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }

    public void insertOrderIntoDB(Address address, int carportHeight, int carPortWidth, User user) throws UserException {

        try(Connection connection = database.connect()){

            String sql = "INSERT INTO fog_db.user(email,role,name,phone,road,housenumber,city,zipcode)" +
                         "VALUES(?,?,?,?,?,?,?,?);";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                ps.setString(1,user.getEmail());
                ps.setString(2,user.getRole());
                ps.setString(3,user.getName());
                ps.setString(4,user.getPhone());
                ps.setString(5,address.getRoad());
                ps.setInt(6,address.getHouseNumber());
                ps.setString(7,address.getCity());
                ps.setInt(8,address.getZipCode());

                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                user.setId(rs.getInt(1));

            } catch (SQLException e){
                throw new UserException(e.getMessage());
            }
        } catch (SQLException e){
            throw new UserException(e.getMessage());
        }
    }
}
