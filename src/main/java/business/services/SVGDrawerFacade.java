package business.services;

import business.entities.Material;
import business.entities.OrderList;

import java.util.List;

public class SVGDrawerFacade {

    private OrderList orderList;
    private double carportLength;
    private double carportWidth;

    public SVGDrawerFacade(OrderList orderList, double carportLength, double carportWidth) {
        this.orderList = orderList;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
    }


    public SVG drawSVGCarport(){

        List<Material> materialList = orderList.getMaterialList();

        //TODO: MÅL, Sidste 3 markers
        SVG svg = new SVG(0, 0, "0 0 " + (carportLength+10) +" " + (carportWidth+75) , 70, 70);
        //Initiate end of line markers
        svg.initiateMarkers();

        //Add outer vertical line
        double endOfOL = (carportWidth-7) * 0.7;
        svg.addMarkerLine(20, 57, 20, endOfOL);
        svg.addLine(20, 51, 30, 51);
        svg.addLine(20, carportWidth*0.7, 30, carportWidth*0.7);
        svg.addVerticalText(15,(carportWidth/2) * 0.7,(int) carportWidth);

        //add inner vertical line
        double endOfIL = (carportWidth+8)*0.7;
        double startOfIL = 80/*92*0.7*/; //35+1+6+50
        double firstLine = 84*0.7;
        double secondLine = (carportWidth+15)*0.7;
        svg.addMarkerLine(50, startOfIL, 50, endOfIL);
        svg.addLine(50, firstLine, 60, firstLine);
        svg.addLine(50, secondLine, 60, secondLine);
        svg.addVerticalText(45, (carportWidth/2) * 0.7, (int) carportWidth-70);

        //add horizontal lines
        double horiLineY = (carportWidth+100)*0.7;
        double endOfHoriLine = (carportLength+94)*0.7;
        svg.addMarkerLine(81, horiLineY, endOfHoriLine, horiLineY);
        svg.addLine(76,(carportWidth+40)*0.7,76, horiLineY);
        svg.addLine(endOfHoriLine+6, (carportWidth+40)*0.7, endOfHoriLine+6, horiLineY );
        svg.addHorizontalText((carportLength+76)/2,horiLineY-5, (int) carportLength );




//        svg.addLine(10, 50, 20, 500);
        SVG innerSVG = new SVG(75, 50,"0 0 " + (carportLength+10) +" " + (carportWidth+10),70, 70 );
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

        return svg;

    }


}
