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
            "viewBox=\"%s\" "+
            "x=\"%d\"   " +
            "y=\"%d\"   " +
            " preserveAspectRatio=\"xMinYMin\">";

    private final String StripedLineTemplate = "<line x1=\"%d\" x2=\"%d\" y1=\"%d\" y2=\"%d\" stroke=\"#000000\" stroke-witdh=\"%d\" stroke-linecap=\"square\" stroke-dasharray=\"1 3\"/>";

    private final String rectTemplate = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";

    private final String LineTemplate = "<Line x1=\"%d\" x2=\"%d\" y1=\"%d\" y2=\"%d\" stroke=\"#000000\"/>";

    public SVG(int x, int y, String viewBox, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.viewBox = viewBox;
        this.width = width;
        this.height = height;
        svg.append(String.format(headerTemplate, height, width, viewBox, x, y )+"\n");
    }

    public void addRect(double x, double y, double height, double width)
    {
        svg.append(String.format(rectTemplate, x, y, height, width)+"\n");
    }

    public void addStripedLine(int x1, int x2, int y1, int y2, int strokeWidth)
    {
        svg.append(String.format(StripedLineTemplate, x1, x2, y1, y2, strokeWidth));
    }

    public void addLine(int x1, int x2, int y1, int y2)
    {
        svg.append(String.format(LineTemplate, x1, x2, y1, y2));
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