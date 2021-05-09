package web.commands;

import business.entities.Address;
import business.entities.Fsp;
import business.entities.User;
import business.exceptions.UserException;
import business.services.FspFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class FinishCommand extends Command
{
    public String pageToShow;

    public FinishCommand(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        FspFacade fspFacade = new FspFacade(database);

        int width;
        int height;
        String name;
        String road;
        int houseNumber;
        int zipCode;
        String city;
        int phone;
        String email;

        try{
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("height"));
            name = request.getParameter("name");
            road = request.getParameter("road");
            houseNumber = Integer.parseInt(request.getParameter("housenumber"));
            zipCode = Integer.parseInt(request.getParameter("zipcode"));
            city = request.getParameter("city");
            phone = Integer.parseInt(request.getParameter("phone"));
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


        fspFacade.createFSp(0, width, height, name, road, houseNumber, zipCode, city, phone, email);

//        Address address = new Address(road,houseNumber,city,zipCode);
//        orderFacade.insertOrderIntoDB(address,height,width,user);

        return pageToShow;
    }
}


