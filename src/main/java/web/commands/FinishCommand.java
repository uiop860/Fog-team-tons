package web.commands;

import business.entities.Address;
import business.entities.User;
import business.exceptions.UserException;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FinishCommand extends Command
{
    public String pageToShow;

    public FinishCommand(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        OrderFacade orderFacade = new OrderFacade(database);

        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String name = request.getParameter("name");
        String road = request.getParameter("road");
        int houseNumber = Integer.parseInt(request.getParameter("housenumber"));
        int zipCode = Integer.parseInt(request.getParameter("zipcode"));
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        User sessionUser = (User) request.getSession().getAttribute("user");

        User user;
        if(sessionUser == null){
            user = new User(email,null,"customer");
            user.setName(name);
            user.setPhone(phone);
        } else{
            user = sessionUser;
        }

        Address address = new Address(road,houseNumber,city,zipCode);
        orderFacade.insertOrderIntoDB(address,height,width,user);

        return pageToShow;
    }
}


