package web.commands;

import business.entities.MaterialListItem;
import business.entities.Request;
import business.exceptions.UserException;
import business.services.RequestFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ManageFSPCommand extends CommandProtectedPage
{
    RequestFacade requestFacade;
    public ManageFSPCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        this.requestFacade = new RequestFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
       int id = Integer.parseInt(request.getParameter("manageRequest"));
       Request request1 = requestFacade.getRequestFromID(id);
       request.setAttribute("request", request1);
       List<MaterialListItem> materialList = requestFacade.getMaterialList(id);
       request.setAttribute("materialList", materialList);
        return pageToShow;
    }
}
