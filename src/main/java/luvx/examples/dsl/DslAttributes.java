package luvx.examples.dsl;

/**
 * Static factory methods for DSL attributes
 */
public class DslAttributes {
    
    // Common HTML attributes
    public static DslAttribute id(String value) { return new DslAttribute("id", value); }
    public static DslAttribute className(String value) { return new DslAttribute("class", value); }
    public static DslAttribute href(String value) { return new DslAttribute("href", value); }
    public static DslAttribute onClick(String value) { return new DslAttribute("onclick", value); }
    public static DslAttribute type(String value) { return new DslAttribute("type", value); }
    public static DslAttribute placeholder(String value) { return new DslAttribute("placeholder", value); }
    public static DslAttribute value(String value) { return new DslAttribute("value", value); }
    public static DslAttribute name(String value) { return new DslAttribute("name", value); }
    public static DslAttribute content(String value) { return new DslAttribute("content", value); }
    public static DslAttribute charset(String value) { return new DslAttribute("charset", value); }
    
    // SVG attributes
    public static DslAttribute xmlns(String value) { return new DslAttribute("xmlns", value); }
    public static DslAttribute viewBox(double x, double y, double width, double height) { 
        return new DslAttribute("viewBox", x + " " + y + " " + width + " " + height); 
    }
    public static DslAttribute width(double value) { return new DslAttribute("width", String.valueOf(value)); }
    public static DslAttribute height(double value) { return new DslAttribute("height", String.valueOf(value)); }
    public static DslAttribute x(double value) { return new DslAttribute("x", String.valueOf(value)); }
    public static DslAttribute y(double value) { return new DslAttribute("y", String.valueOf(value)); }
    public static DslAttribute cx(double value) { return new DslAttribute("cx", String.valueOf(value)); }
    public static DslAttribute cy(double value) { return new DslAttribute("cy", String.valueOf(value)); }
    public static DslAttribute r(double value) { return new DslAttribute("r", String.valueOf(value)); }
    public static DslAttribute fill(String value) { return new DslAttribute("fill", value); }
    public static DslAttribute stroke(String value) { return new DslAttribute("stroke", value); }
    public static DslAttribute strokeWidth(double value) { return new DslAttribute("stroke-width", String.valueOf(value)); }
    public static DslAttribute transform(String value) { return new DslAttribute("transform", value); }
    public static DslAttribute textAnchor(String value) { return new DslAttribute("text-anchor", value); }
    public static DslAttribute fontSize(double value) { return new DslAttribute("font-size", String.valueOf(value)); }
    public static DslAttribute fontWeight(String value) { return new DslAttribute("font-weight", value); }
    public static DslAttribute offset(String value) { return new DslAttribute("offset", value); }
    public static DslAttribute stopColor(String value) { return new DslAttribute("stop-color", value); }
    public static DslAttribute filter(String value) { return new DslAttribute("filter", value); }
    public static DslAttribute dx(double value) { return new DslAttribute("dx", String.valueOf(value)); }
    public static DslAttribute dy(double value) { return new DslAttribute("dy", String.valueOf(value)); }
    public static DslAttribute stdDeviation(double value) { return new DslAttribute("stdDeviation", String.valueOf(value)); }
}