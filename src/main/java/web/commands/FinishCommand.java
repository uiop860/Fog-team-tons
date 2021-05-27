package web.commands;

import business.entities.OrderList;
import business.entities.Request;
import business.exceptions.UserException;
import business.services.OrderListFacade;
import business.services.RequestFacade;
import business.services.SVG;
import business.services.SVGDrawerFacade;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class FinishCommand extends Command
{
    public String pageToShow;

    public FinishCommand(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {

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

        Request userRequest = new Request(carportWidthID, carportLengthID, name, road, houseNumber, zipCode, city, phone, email);

        RequestFacade requestFacade = new RequestFacade(database);

        int requestID = requestFacade.insertRequestIntoDB(userRequest);

        OrderListFacade orderListFacade = new OrderListFacade(database);

        ServletContext servletContext = request.getServletContext();

        HashMap<Integer, Integer> carportLengthMap = (HashMap<Integer, Integer>) servletContext.getAttribute("carportlength");
        HashMap<Integer, Integer> carportWidthMap = (HashMap<Integer, Integer>) servletContext.getAttribute("carportwidth");

        double carportLength = 0;
        double carportWidth = 0;

        for (Map.Entry<Integer, Integer> set : carportLengthMap.entrySet())
        {
            if (set.getKey() == carportLengthID)
            {
                carportLength = (double) set.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> set : carportWidthMap.entrySet())
        {
            if (set.getKey() == carportWidthID)
            {
                carportWidth = (double) set.getValue();
            }
        }

        OrderList orderList = orderListFacade.calculateCarport(carportWidth, carportLength, requestID);

        SVGDrawerFacade svgDrawerFacade = new SVGDrawerFacade(orderList,carportLength,carportWidth);

        SVG svg = svgDrawerFacade.drawSVGCarport();
        SVG sideSVG = svgDrawerFacade.drawSideSVG();

        request.setAttribute("sideSVG", sideSVG.toString());
        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}


