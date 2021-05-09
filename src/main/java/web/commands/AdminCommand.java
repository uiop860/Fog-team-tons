package web.commands;

import business.entities.Fsp;
import business.exceptions.UserException;
import business.services.FspFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminCommand extends CommandProtectedPage
{
    FspFacade fspFacade;

    public AdminCommand(String pageToShow, String role)
    {
        super(pageToShow, role);
        this.fspFacade = new FspFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            List<Fsp> fspList = fspFacade.getfsp();

            request.setAttribute("fspList", fspList);
        } catch (UserException e)
        {
            e.printStackTrace();
        }

        return pageToShow;
    }
}