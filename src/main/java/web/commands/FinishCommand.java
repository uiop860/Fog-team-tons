package web.commands;

import business.entities.Request;
import business.exceptions.UserException;
import business.persistence.OrderListMapper;
import business.services.OrderListFacade;
import business.services.RequestFacade;

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

        int carportWidthID;
        int carportLengthID;
        String name;
        String road;
        int houseNumber;
        int zipCode;
        String city;
        int phone;
        String email;

        try{
            carportWidthID = Integer.parseInt(request.getParameter("width"));
            carportLengthID = Integer.parseInt(request.getParameter("length"));
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

        Request userRequest = new Request(carportWidthID,carportLengthID,name,road,houseNumber,zipCode,city,phone,email);

        RequestFacade requestFacade = new RequestFacade(database);

        requestFacade.insertRequestIntoDB(userRequest);

        OrderListFacade orderListFacade = new OrderListFacade(database);





        orderListFacade.calculateCarport(carportWidthID,carportLengthID);


        return pageToShow;
    }
}


