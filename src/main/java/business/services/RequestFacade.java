package business.services;

import business.entities.Request;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.RequestMapper;

import java.util.ArrayList;
import java.util.List;

public class RequestFacade {

    private RequestMapper requestMapper;

    public RequestFacade(Database database) {
        this.requestMapper = new RequestMapper(database);
    }

    public void insertRequestIntoDB(Request userRequest) throws UserException {

        requestMapper.insertRequestIntoDB(userRequest);

    }

    public List<Request> getAllRequestFromDB() throws UserException {

        List<Request> requestList = new ArrayList<>();

        requestList = requestMapper.getAllRequestFromDB();

        return requestList;
    }

    public Request getRequestFromID(int id) throws UserException
    {
        Request request;

        request = requestMapper.getRequestFromID(id);
        return request;
    }


    public int assignEmployee(int requestID, int employeeID) throws UserException
    {
        int rowsAffected = requestMapper.assignEmployee(requestID, employeeID);

        return rowsAffected;
    }

}
