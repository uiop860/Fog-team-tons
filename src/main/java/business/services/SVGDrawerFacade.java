package business.services;

import business.entities.Material;
import business.entities.OrderList;

import java.util.List;

public class SVGDrawerFacade {

    private OrderList orderList;
    private double carportLength;
    private double carportWidth;
    private List<Material> materialList;

    public SVGDrawerFacade(OrderList orderList, double carportLength, double carportWidth) {
        this.orderList = orderList;
        this.carportLength = carportLength;
        this.carportWidth = carportWidth;
        this.materialList = orderList.getMaterialList();
    }

    public SVG drawSVGCarport(){



        //TODO: MÅL, Sidste 3 markers
        SVG svg = new SVG(0, 0, "0 0 " + (carportLength+55) +" " + (carportWidth+55) , 100, 100);
        //Initiate end of line markers
        svg.initiateMarkers();

        //Add outer vertical line
        svg.addMarkerLine(11,56,11,carportWidth+44);
        svg.addVerticalText(10,(carportWidth/2)+44,(int)carportWidth);

        //add inner vertical line
        svg.addMarkerLine(31,50+35+6,31,carportWidth+50-6-35);
        svg.addVerticalText(30,(carportWidth/2)+44,(int)(carportWidth-70));

        //add horizontal lines
        svg.addMarkerLine(50+6,11,carportLength+46,11);
        svg.addHorizontalText((carportLength/2)+50,10, (int)carportLength);


        for (Material mat: materialList) {
            double temp = 58.25;
            double temp2 = 46.75;

            if(mat.getMaterialID() == 2){
                svg.addMarkerLine(temp,40,mat.getSpacing()+temp2,40);
                svg.addLine(temp-6,30,temp-6,51);
                svg.addHorizontalTextSmall((temp+(mat.getSpacing()/2))-6,39, (int) mat.getSpacing());
                for (int i = 1; i < mat.getAmount()-2; i++) {
                    svg.addMarkerLine(temp+=mat.getSpacing(),40,mat.getSpacing()+(temp2+=mat.getSpacing()),40);
                    svg.addLine(temp-6,30,temp-6,51);
                    svg.addHorizontalTextSmall((temp+(mat.getSpacing()/2))-6,39, (int) mat.getSpacing());
                }
                svg.addMarkerLine(temp+=mat.getSpacing(),40,(mat.getSpacing()+(temp2+=mat.getSpacing()))-2.5,40);
                svg.addLine(temp-6,30,temp-6,51);
                svg.addHorizontalTextSmall((temp+(mat.getSpacing()/2))-6,39, (int) mat.getSpacing());
                temp+=mat.getSpacing();
                svg.addLine(temp-8,30,temp-8,51);
            }
        }

        SVG innerSVG = new SVG(50, 50,"0 0 " + (carportLength+55) +" " + (carportWidth+55),100, 100 );
        innerSVG.addRect(1, 1, carportWidth, carportLength);
        for (Material mat : materialList)
        {
            switch (mat.getMaterialID())
            {
                case 1:
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
                            innerSVG.addRect((mat.getSpacing() * i)-3.5, 1, carportWidth, 4.5);
                        }
                        else
                        {
                            innerSVG.addRect(mat.getSpacing() * i, 1, carportWidth, 4.5);
                        }
                    }
                    innerSVG.addStripedLine((mat.getSpacing() + 4.5), (carportLength - mat.getSpacing()), 39.5, (carportWidth - 39.5), 2);
                    innerSVG.addStripedLine((mat.getSpacing() + 4.5), (carportLength - mat.getSpacing()), (carportWidth - 39.5), 39.5, 2);

                    break;
            }
        }
        svg.addSvg(innerSVG);
        return svg;
    }
    public SVG drawSideSVG()
    {
        SVG sideSVG = new SVG(0, 0, "0 0 " + (carportLength+150) + " 280", 100, 100);



        for(Material mat: materialList)
        {
            if(mat.getMaterialID() == 1)
            {

                if(mat.getAmount() >= 4)
                {
                    for (int i = 0; i < (mat.getAmount()/2); i++)
                    {
                        sideSVG.addRect(((mat.getSpacing()*i)+100)+100, 40, mat.getLength()-110, 9.7 );
                        if(i == 1)
                        {
                            sideSVG.addMarkerLine(206, 260, mat.getSpacing() * i + 194, 260);
                            sideSVG.addHorizontalText(((mat.getSpacing()*i+200)/2)+(100*i), 255, (int)mat.getSpacing());
                        }
                        else if(i > 1)
                        {
                            sideSVG.addMarkerLine(mat.getSpacing()*(i-1)+206, 260, mat.getSpacing() * i + 194, 260);
                            sideSVG.addHorizontalText(((mat.getSpacing()*i+200)/2)+(100*i), 255, (int)mat.getSpacing());
                        }
                    }
                }
            }
        }

        sideSVG.addLine(100, 0, carportLength+100, 10);
        sideSVG.addLine(100, 0, 100, 20);


        sideSVG.addLine(100, 20,100, 40);
//        sideSVG.addLine(0, 20, carportLength, 30);
        sideSVG.addLine(100, 40, carportLength+100, 40);
        sideSVG.addLine(carportLength+100, 20, carportLength+100, 40);


        sideSVG.addLine(100, 20, carportLength+100, 30);
        sideSVG.addLine(carportLength+100, 10, carportLength+100, 30);



        sideSVG.addLine(100, 230, carportLength+100, 230);

        sideSVG.initiateMarkers();
        //Outer left
        sideSVG.addMarkerLine(50, 6, 50, 224);
        sideSVG.addVerticalText(45, 115, 230);
        //Inner left
        sideSVG.addMarkerLine(75, 26, 75, 224);
        sideSVG.addVerticalText(70, 115, 210);
        //Right
        sideSVG.addMarkerLine(carportLength+125, 16, carportLength+125, 224);
        sideSVG.addVerticalText(carportLength+120, 115, 220);
        //Down left
        sideSVG.addMarkerLine(106, 260, 194, 260);
        sideSVG.addHorizontalText(150, 255, 100);
        return sideSVG;
    }
}
