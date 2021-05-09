package business.persistence;

import business.entities.Fsp;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FspMapper
{
    private Database database;

    public FspMapper(Database database)
    {
        this.database = database;
    }

    public void createFsp(Fsp fsp) throws UserException
    {
        try (Connection connection = database.connect())
        {
            String sql = "INSERT INTO fog_db.fsp (width, length, name, address, housenr, zipcode, city, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                ps.setInt(1, fsp.getWidth());
                ps.setInt(2, fsp.getLength());
                ps.setString(3, fsp.getName());
                ps.setString(4, fsp.getAddress());
                ps.setInt(5, fsp.getHouseNr());
                ps.setInt(6, fsp.getZipcode());
                ps.setString(7, fsp.getCity());
                ps.setInt(8, fsp.getPhone());
                ps.setString(9, fsp.getEmail());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                fsp.setId(id);
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

    public List<Fsp> getAllFsp() throws UserException
    {
        List<Fsp> fspList = new ArrayList<>();
        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM fog_db.fsp;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int id = rs.getInt("fsp_id");
                    int width = rs.getInt("width");
                    int height = rs.getInt("length");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    int housenr = rs.getInt("housenr");
                    int zipcode = rs.getInt("zipcode");
                    String city = rs.getString("city");
                    int phone = rs.getInt("phone");
                    String email = rs.getString("email");


                    fspList.add(new Fsp(id, width, height, name, address, housenr, zipcode, city, phone, email));


                }
                return fspList;
            } catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }
}
