package web.commands;

import business.entities.Request;
import business.exceptions.UserException;
import business.services.RequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmployeeCommand extends CommandProtectedPage
{
    public RequestFacade requestFacade;

    public EmployeeCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        this.requestFacade = new RequestFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {

        try{
            List<Request> requestList = requestFacade.getAllRequestFromDB();
            request.setAttribute("requestList",requestList);

        } catch (UserException e){
            e.printStackTrace();
        }

        return pageToShow;
    }
}
