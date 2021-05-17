package web.commands;

import business.entities.Request;
import business.exceptions.UserException;
import business.services.RequestFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TakeFSPCommand extends CommandProtectedPage
{
    RequestFacade requestFacade;
    UserFacade userFacade;
    public TakeFSPCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        this.requestFacade = new RequestFacade(database);
        this.userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        int requestID = Integer.parseInt(request.getParameter("requestID"));
        int employeeID = userFacade.getEmployeeID(request.getParameter("employeeID"));

        requestFacade.assignEmployee(requestID, employeeID);
        Request request1 = requestFacade.getRequestFromID(requestID);
        request.setAttribute("request", request1);
        return pageToShow;
    }

}
