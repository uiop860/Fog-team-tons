package web.commands;

import business.entities.Material;
import business.entities.OrderList;
import business.entities.Request;
import business.exceptions.UserException;
import business.persistence.OrderListMapper;
import business.services.OrderListFacade;
import business.services.RequestFacade;
import business.services.SVG;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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

        /*try{*/
        carportWidthID = Integer.parseInt(request.getParameter("width"));
        carportLengthID = Integer.parseInt(request.getParameter("length"));
        name = request.getParameter("name");
        road = request.getParameter("road");
        houseNumber = 1; //Integer.parseInt(request.getParameter("housenumber"));
        zipCode = 1;// Integer.parseInt(request.getParameter("zipcode"));
        city = request.getParameter("city");
        phone = 1; //Integer.parseInt(request.getParameter("phone"));
        email = request.getParameter("email");

        /*} catch (NumberFormatException e){
            request.setAttribute("error","Du har udfyldt forkert");
            return "orderpage";
        }*/

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
        List<Material> materialList = orderList.getMaterialList();

//TODO: MÅL, Sidste 3 markers
        SVG svg = new SVG(0, 0, "0 0 " + (carportLength+10) +" " + (carportWidth+10) , 70, 70);
        //Initiate end of line markers
        svg.initiateMarkers();

        //Add outer vertical line
        double endOfOL = (carportWidth-7) * 0.7;
        svg.addMarkerLine(20, 7, 20, endOfOL);
        svg.addLine(20, 1, 30, 1);
        svg.addLine(20, carportWidth*0.7, 30, carportWidth*0.7);
        svg.addVerticalText(15,(carportWidth/2) * 0.7,(int) carportWidth);

        //add inner vertical line
        double endOfIL = (carportWidth-42)*0.7;
        double startOfIL = 42*0.7;
        double firstLine = 34*0.7;
        double secondLine = (carportWidth-35)*0.7;
        svg.addMarkerLine(50, startOfIL, 50, endOfIL);
        svg.addLine(50, firstLine, 60, firstLine);
        svg.addLine(50, secondLine, 60, secondLine);
        svg.addVerticalText(45, (carportWidth/2) * 0.7, (int) carportWidth-70);

        //add horizontal lines
        double horiLineY = (carportWidth+50)*0.7;
        double endOfHoriLine = (carportLength+94)*0.7;
        svg.addMarkerLine(82, horiLineY, endOfHoriLine, horiLineY);
        svg.addLine(76,(carportWidth+40)*0.7,76, horiLineY);
        svg.addLine(endOfHoriLine+6, (carportWidth+40)*0.7, endOfHoriLine+6, horiLineY );
        svg.addHorizontalText((carportLength+76)/2,horiLineY-5, (int) carportLength );




//        svg.addLine(10, 50, 20, 500);
        SVG innerSVG = new SVG(75, 0,"0 0 " + (carportLength+10) +" " + (carportWidth+10),70, 70 );
        innerSVG.addRect(1, 1, carportWidth, carportLength);
        for (Material mat : materialList)
        {
            switch (mat.getMaterialID())
            {
                case 1:
//                    svg.addRect(100, 32.4,9.7, 9.7);
//                    svg.addRect(100, (carportWidth-42.1),9.7, 9.7);
//                    svg.addRect((carportLength-29.7), 32.4,9.7, 9.7);
//                    svg.addRect((carportLength-29.7), (carportWidth-42.1),9.7, 9.7);
                    if(mat.getAmount() >= 4)
                    {
                        for (int i = 0; i < (mat.getAmount()/2); i++)
                        {
                            innerSVG.addRect(((mat.getSpacing()*i)+100), 32.4, 9.7, 9.7);
                            innerSVG.addRect(((mat.getSpacing()*i)+100), (carportWidth-42.1), 9.7, 9.7);
                        }
                    }


                    innerSVG.addRect(1, 35, 4.5, carportLength); //Beam 1
                    innerSVG.addRect(1, (carportWidth - 39.5), 4.5, carportLength); //Beam 2
                    break;

                case 2:
                    innerSVG.addRect(1,1, carportWidth, 4.5);
                    for (int i = 1; i < mat.getAmount(); i++)
                    {

                        if ((mat.getSpacing() * i) >= carportLength)
                        {
                            innerSVG.addRect((mat.getSpacing() * i), 1, carportWidth, 4.5);
                        }
                        else
                        {
                            innerSVG.addRect(mat.getSpacing() * i, 1, carportWidth, 4.5);
                        }
                    }
                    innerSVG.addStripedLine((mat.getSpacing() + 4.5), (carportLength - mat.getSpacing()), 39.5, (carportWidth - 39.5), 2);
                    innerSVG.addStripedLine((mat.getSpacing() + 4.5), (carportLength - mat.getSpacing()), (carportWidth - 39.5), 39.5, 2);

                    break;
                case 3:
                    break;
                case 4:

                    break;
                case 5:
                    break;

            }


        }

//            svg.addStripedLine((materialList.get(1).getSpacing()+4.5),carportLength - materialList.get(1).getSpacing(),35, (carportWidth-35);
        svg.addSvg(innerSVG);
        request.setAttribute("svg", svg.toString());

        return pageToShow;
    }
}


