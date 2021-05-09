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
        int width;
        int height;
        String name;
        String road;
        int houseNumber;
        int zipCode;
        String city;
        String phone;
        String email;
        OrderFacade orderFacade = new OrderFacade(database);

        try{
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
            name = request.getParameter("name");
            road = request.getParameter("road");
            houseNumber = Integer.parseInt(request.getParameter("housenumber"));
            zipCode = Integer.parseInt(request.getParameter("zipcode"));
            city = request.getParameter("city");
            phone = request.getParameter("phone");
            email = request.getParameter("email");

        } catch (NumberFormatException e){
            request.setAttribute("error","Du har udfyldt forkert");
            return "orderpage";
        }

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


