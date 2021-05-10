package business.persistence;

import business.entities.Fsp;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CarportDimenstionsMapper {

    Database database;

    public CarportDimenstionsMapper(Database database) {
        this.database = database;
    }

    public HashMap<Integer,Integer> getCarportLengthFromDB() throws UserException{

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM fog_db.carport_length ORDER BY carport_length_id ASC;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();

                rs.next();
                while (rs.next()){
                    hashMap.put(rs.getInt("carport_length_id"),rs.getInt("carport_length"));
                }

            } catch (SQLException ex){
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }

        return hashMap;
    }

    public HashMap<Integer,Integer> getCarportWidthFromDB() throws UserException{

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM fog_db.carport_width ORDER BY carport_width_id ASC;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();

                rs.next();
                while (rs.next()){
                    hashMap.put(rs.getInt("carport_width_id"),rs.getInt("carport_width"));
                }

            } catch (SQLException ex){
                throw new UserException(ex.getMessage());
            }

        } catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }

        return hashMap;
    }
}
