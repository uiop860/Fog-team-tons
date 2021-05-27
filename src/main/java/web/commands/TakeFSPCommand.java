package web.commands;

import business.entities.Material;
import business.entities.MaterialListItem;
import business.entities.OrderList;
import business.entities.Request;
import business.exceptions.UserException;
import business.services.RequestFacade;
import business.services.SVG;
import business.services.SVGDrawerFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

        List<Material> drawingList = requestFacade.getDrawingfromDB(requestID);
        for (Material mat: drawingList)
        {
            mat.calculateAmountAndPrice(request1.getCarportWidth(), request1.getCarportLength());
        }
        OrderList orderList = new OrderList(drawingList);

        SVGDrawerFacade svgDrawerFacade = new SVGDrawerFacade(orderList, request1.getCarportLength(), request1.getCarportWidth());
        SVG svg = svgDrawerFacade.drawSVGCarport();
        SVG sideSVG = svgDrawerFacade.drawSideSVG();
        request.setAttribute("SVG", svg.toString());
        request.setAttribute("sideSvg", sideSVG.toString());


        request.setAttribute("request", request1);
        List<MaterialListItem> materialList = requestFacade.getMaterialList(requestID);
        request.setAttribute("materialList", materialList);
        return pageToShow;
    }
}
