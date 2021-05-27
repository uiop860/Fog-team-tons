package business.persistence;


import business.entities.Material;
import business.entities.MaterialListItem;
import business.entities.Request;
import business.exceptions.UserException;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RequestMapper {

    private Database database;

    public RequestMapper(Database database) {
        this.database = database;
    }

    public int insertRequestIntoDB(Request userRequest) throws UserException {

        try (Connection connection = database.connect()) {

            String sql = "INSERT INTO fog_db.request (phone,name,email,road,housenumber,city,zipcode,carport_length_id,carport_width_id) VALUES(?,?,?,?,?,?,?,?,?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, userRequest.getPhone());
                ps.setString(2, userRequest.getName());
                ps.setString(3, userRequest.getEmail());
                ps.setString(4, userRequest.getRoad());
                ps.setInt(5, userRequest.getHouseNumber());
                ps.setString(6, userRequest.getCity());
                ps.setInt(7, userRequest.getZipcode());
                ps.setInt(8, userRequest.getCarportLengthID());
                ps.setInt(9, userRequest.getCarportWidthID());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                int requestID = rs.getInt(1);
                userRequest.setRequestID(requestID);

                return requestID;
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }
    }

    public List<Request> getAllRequestFromDB() throws UserException
    {

        List<Request> requestList = new ArrayList<>();

        try (Connection connection = database.connect())
        {

            String sql = "SELECT r.request_id,r.phone,name,email,road,housenumber,city,zipcode,employee_id,r.carport_length_id,r.carport_width_id,L.carport_length,W.carport_width " +
                    "FROM request r " +
                    "INNER JOIN carport_length L ON r.carport_length_id = L.carport_length_id " +
                    "INNER JOIN carport_width W ON r.carport_width_id = W.carport_width_id;";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {
                    int requestID = rs.getInt("request_id");
                    int phone = rs.getInt("phone");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String road = rs.getString("road");
                    int houseNumber = rs.getInt("housenumber");
                    String city = rs.getString("city");
                    int zipcode = rs.getInt("zipcode");
                    int employeeID = rs.getInt("employee_id");
                    int carportWidthID = rs.getInt("carport_width_id");
                    int carportLengthID = rs.getInt("carport_length_id");
                    int carportWidth = rs.getInt("carport_width");
                    int carportLength = rs.getInt("carport_length");

                    Request request = new Request(carportWidthID, carportLengthID, name, road, houseNumber, zipcode, city, phone, email);
                    request.setEmployeeID(employeeID);
                    request.setRequestID(requestID);
                    request.setCarportWidth(carportWidth);
                    request.setCarportLength(carportLength);
                    requestList.add(request);

                }
                return requestList;
            } catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }

    }
        public Request getRequestFromID(int id) throws UserException {

            Request request;
            try (Connection connection = database.connect()){

                String sql = "SELECT r.request_id,r.phone,name,email,road,housenumber,city,zipcode,employee_id,r.carport_length_id,r.carport_width_id,L.carport_length,W.carport_width,r.total_carport_price " +
                "FROM request r " +
                "INNER JOIN carport_length L ON r.carport_length_id = L.carport_length_id "+
                "INNER JOIN carport_width W ON r.carport_width_id = W.carport_width_id " +
                "WHERE r.request_id = ?;";

                try (PreparedStatement ps = connection.prepareStatement(sql)){

                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()){
                        int requestID = rs.getInt("request_id");
                        int phone = rs.getInt("phone");
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        String road = rs.getString("road");
                        int houseNumber = rs.getInt("housenumber");
                        String city = rs.getString("city");
                        int zipcode = rs.getInt("zipcode");
                        int employeeID = rs.getInt("employee_id");
                        int carportWidthID = rs.getInt("carport_width_id");
                        int carportLengthID = rs.getInt("carport_length_id");
                        int carportWidth = rs.getInt("carport_width");
                        int carportLength = rs.getInt("carport_length");
                        double total_price = rs.getDouble("total_carport_price");

                        request = new Request(carportWidthID, carportLengthID, name, road, houseNumber, zipcode, city, phone, email);
                        request.setEmployeeID(employeeID);
                        request.setRequestID(requestID);
                        request.setCarportWidth(carportWidth);
                        request.setCarportLength(carportLength);
                        total_price = Double.parseDouble(new DecimalFormat("#.##").format(total_price));
                        request.setTotal_price(total_price);

                        return request;
                    }

                } catch (SQLException ex){
                    throw new UserException(ex.getMessage());
                }
            } catch (SQLException ex){
                throw new UserException(ex.getMessage());
            }
        return null;
    }


    public int assignEmployee(int requestID, int employeeID) throws UserException {
        int rowsAffected = 0;
        try (Connection connection = database.connect()) {

            String sql = "UPDATE fog_db.request SET employee_id=? WHERE request_id=?;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, employeeID);
                ps.setInt(2, requestID);
                rowsAffected = ps.executeUpdate();

                return rowsAffected;
            }
            catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex){
            throw new UserException(ex.getMessage());
        }
    }

    public List<MaterialListItem> getMaterialList (int requestID) throws UserException
    {
        List<MaterialListItem> materialList = new ArrayList<>();
        try(Connection connection = database.connect())
        {
            String sql ="SELECT * FROM fog_db.orderlist INNER JOIN fog_db.material ON orderlist.material_id=material.material_id WHERE request_id =?;";

            try(PreparedStatement ps = connection.prepareStatement(sql))
            {

                ps.setInt(1, requestID);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    int amount = rs.getInt("amount");
                    double total_material_price = rs.getDouble("total_material_price");
                    String material_name = rs.getString("material_name");
                    String description = rs.getString("description");

                    total_material_price = Double.parseDouble(new DecimalFormat("#.##").format(total_material_price));
                    materialList.add(new MaterialListItem(amount, total_material_price, material_name, description));
                }
                return materialList;
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return materialList;
    }
    public List<Material> getDrawingfromDB (int requestID) throws UserException
    {
        List<Material> drawingList = new ArrayList<>();
        try(Connection connection = database.connect())
        {
            String sql ="SELECT * FROM fog_db.orderlist INNER JOIN fog_db.material ON orderlist.material_id=material.material_id WHERE request_id =?;";

            try(PreparedStatement ps = connection.prepareStatement(sql))
            {

                ps.setInt(1, requestID);
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    int id = rs.getInt("material_id");
                    int amount = rs.getInt("amount");
                    double total_material_price = rs.getDouble("total_material_price");
                    double price = rs.getDouble("price");
                    String material_name = rs.getString("material_name");
                    String description = rs.getString("description");

//                    total_material_price = Double.parseDouble(new DecimalFormat("#.##").format(total_material_price));
                    drawingList.add(new Material(id, material_name, description, "Stk", price, "Træ" ));
                }
                return drawingList;
            }
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return drawingList;
    }

}
