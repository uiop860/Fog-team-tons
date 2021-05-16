package web.commands;

import business.entities.Address;
import business.entities.User;
import business.persistence.Database;
import business.services.AddressFacade;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;
    private AddressFacade addressFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
        addressFacade = new AddressFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {

        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");


        /*String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String road = request.getParameter("road");
        int house = Integer.parseInt(request.getParameter("house"));
        String city = request.getParameter("city");
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));*/



        if (password1.equals(password2))
        {


            User user = userFacade.createUser(email, password1);
            /*Address address = new Address(road, house, city, zipcode, phone, name);
            addressFacade.createAddress(address, email);*/

            HttpSession session = request.getSession();

            session.setAttribute("email", email);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return user.getRole() + "page";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }

    }

}
