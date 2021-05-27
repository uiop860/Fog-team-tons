package business.persistence;

import business.entities.Address;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;

public class AddressMapper
{
    private Database database;

    public AddressMapper(Database database)
    {
        this.database = database;
    }

    public void createAddress(Address address, String email) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "UPDATE fog_db.users SET name =?, phone = ?, road = ?, housenumber = ?, city = ?, zipcode = ? WHERE email = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setString(1, address.getName());
                ps.setInt(2, address.getPhone());
                ps.setString(3, address.getRoad());
                ps.setInt(4, address.getHouseNumber());
                ps.setString(5, address.getCity());
                ps.setInt(6, address.getZipCode());
                ps.setString(7, email);
                ps.executeUpdate();

            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }
}
