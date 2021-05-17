package business.persistence;

import business.exceptions.UserException;
import business.entities.User;

import java.sql.*;

public class UserMapper {

    private Database database;

    public UserMapper(Database database) {

        this.database = database;
    }

    public void createUser(User user) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO users (email, password, role) VALUES (?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, user.getEmail());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
                user.setId(id);
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public User login(String email, String password) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "SELECT * FROM fog_db.employee WHERE email=? AND password=?;";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, email);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    String role = rs.getString("role");
                    int id = rs.getInt("employee_id");
                    User user = new User(email, password, role);
                    user.setId(id);
                    return user;
                } else {
                    throw new UserException("Could not validate user");
                }
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
    public int getEmployeeID(String email) throws UserException
    {
        int id = 0;
        try (Connection connection = database.connect())
        {
            String sql = "SElECT employee_id From fog_db.employee WHERE email=?;";
            try(PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                {
                    id = rs.getInt("employee_id");
                    return id;
                }
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return id;
    }
}
