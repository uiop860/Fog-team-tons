package business.services;

public class SVG
{
    StringBuilder svg = new StringBuilder();

    private int x;
    private int y;
    private String viewBox;
    private int width;
    private int height;

    private final String headerTemplate = "<svg height=\"%d%%\" " +
            "width=\"%d%%\" " +
            "viewBox=\"%s\" " +
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String StripedLineTemplate = "<line x1=\"%f\" x2=\"%f\" y1=\"%f\" y2=\"%f\" stroke=\"#000000\" stroke-width=\"%d\" stroke-linecap=\"square\" stroke-dasharray=\"3 3 2 3\"/>";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String rectOpacityTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill-opacity=\"%f\" />";

    private final String LineTemplate = "<Line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" stroke=\"#000000\"/>";

    private final String markerTemplate = "<defs>\n" +
            "                        <marker\n" +
            "                                id=\"beginArrow\"\n" +
            "                                markerWidth=\"12\"\n" +
            "                                markerHeight=\"12\"\n" +
            "                                refX=\"6\"\n" +
            "                                refY=\"6\"\n" +
            "                                orient=\"auto\">\n" +
            "                            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\"/>\n" +
            "                        </marker>\n" +
            "                        <marker\n" +
            "                                id=\"endArrow\"\n" +
            "                                markerWidth=\"12\"\n" +
            "                                markerHeight=\"12\"\n" +
            "                                refX=\"6\"\n" +
            "                                refY=\"6\"\n" +
            "                                orient=\"auto\">\n" +
            "                            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\"/>\n" +
            "                        </marker>\n" +
            "                    </defs>";

    private final String markerLine = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\"\n" +
            "              style=\"stroke: #000000;\n" +
            "\tmarker-end: url(#endArrow); marker-start: url(#beginArrow);\"\"/>";





    public SVG(int x, int y, String viewBox, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y) + "\n");
    }

    public void addRect(double x, double y, double height, double width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width) + "\n");
    }

    public void addOpacityRect(double x, double y, double height, double width, double opacity)
    {
        svg.append(String.format(rectTemplate, x, y, height, width, opacity) + "\n");
    }

    public void addStripedLine(double x1, double x2, double y1, double y2, int strokeWidth)
    {
        svg.append(String.format(StripedLineTemplate, x1, x2, y1, y2, strokeWidth));
    }

    public void addLine(double x1, double y1, double x2, double y2)
    {
        svg.append(String.format(LineTemplate, x1, y1, x2, y2));
    }

    public void addMarkerLine(double x1, double y1, double x2, double y2)
    {
        svg.append(String.format(markerLine, x1, y1, x2, y2));
    }

    public void initiateMarkers()
    {
        svg.append(markerTemplate);
    }


    public void addSvg(SVG innerSVG)
    {
        svg.append(innerSVG.toString());
    }

    @Override
    public String toString()
    {
        return svg.toString() + "</svg>";
    }
}