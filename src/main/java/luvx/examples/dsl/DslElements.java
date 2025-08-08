package luvx.examples.dsl;

import luvx.composable.*;
import luvx.ftype.*;
import java.util.List;

/**
 * Static factory methods for beautiful DSL syntax (similar to luvml/luvg patterns)
 */
public class DslElements {
    
    // Simple text function - accepts String varargs for plain text nodes
    public static DslText text(String... strings) {
        return new DslText(String.join("", strings));
    }
    
    public static DslStyledText styledText(String content, String style){
        return new DslStyledText(content, style);
    }
    
    // Clever utility methods using DslFrags pseudo-carrier
    public static DslFrags multiLineTexts(String... lines) {
        var fragments = new DslFrag_I[lines.length * 2 - 1];
        for (int i = 0; i < lines.length; i++) {
            fragments[i * 2] = text(lines[i]);
            if (i < lines.length - 1) {
                fragments[i * 2 + 1] = br();
            }
        }
        return new DslFrags(fragments);
    }
    
    public static DslFrags frags(DslFrag_I... fragments) {
        return new DslFrags(fragments);
    }
    
    // HTML elements
    public static DslContainerElement html(DslFrag_I... fragments) { return element("html", fragments); }
    public static DslContainerElement head(DslFrag_I... fragments) { return element("head", fragments); }
    public static DslContainerElement body(DslFrag_I... fragments) { return element("body", fragments); }
    public static DslContainerElement div(DslFrag_I... fragments) { return element("div", fragments); }
    public static DslContainerElement span(String... fragments) { return element("span", fragments);}
    public static DslContainerElement span(DslFrag_I... fragments) { return element("span", fragments); }
    public static DslContainerElement p(String... strings) { return element("p", strings);}
    public static DslContainerElement p(DslFrag_I... fragments) { return element("p", fragments); }
    public static DslContainerElement h1(String... strings) { return element("h1", strings); }
    public static DslContainerElement h1(DslFrag_I... fragments) { return element("h1", fragments); }
    public static DslContainerElement h2(String... strings) { return element("h2", strings); }
    public static DslContainerElement h2(DslFrag_I... fragments) { return element("h2", fragments); }
    public static DslContainerElement h3(String... strings) { return element("h3", strings); }
    public static DslContainerElement h3(DslFrag_I... fragments) { return element("h3", fragments); }
    public static DslContainerElement title(String text) { return element("title", new DslText(text)); }
    public static DslContainerElement header(DslFrag_I... fragments) { return element("header", fragments); }
    public static DslContainerElement main(DslFrag_I... fragments) { return element("main", fragments); }
    public static DslContainerElement section(DslFrag_I... fragments) { return element("section", fragments); }
    public static DslContainerElement article(DslFrag_I... fragments) { return element("article", fragments); }
    public static DslContainerElement footer(DslFrag_I... fragments) { return element("footer", fragments); }
    public static DslContainerElement ul(DslFrag_I... fragments) { return element("ul", fragments); }
    public static DslContainerElement li(String text) { return element("li", new DslText(text)); }
    public static DslContainerElement li(DslFrag_I... fragments) { return element("li", fragments); }
    public static DslContainerElement button(DslFrag_I... fragments) { return element("button", fragments); }
    public static DslContainerElement button(String text) { return element("button", new DslText(text)); }
    public static DslContainerElement input(DslFrag_I... fragments) { return element("input", fragments); }
    public static DslContainerElement select(DslFrag_I... fragments) { return element("select", fragments); }
    public static DslContainerElement option(DslFrag_I... fragments) { return element("option", fragments); }
    public static DslContainerElement a(DslFrag_I... fragments) { return element("a", fragments); }
    public static DslContainerElement meta(DslFrag_I... fragments) { return element("meta", fragments); }
    public static DslContainerElement style(String ... cssLines) { return element("style", cssLines); }
    public static DslContainerElement style(String css) { return element("style", new DslText(css)); }
    public static DslSelfClosingElement br() { return new DslSelfClosingElement("br"); }
    public static DslContainerElement pre(DslFrag_I... fragments) { return element("pre", fragments); }
    
    // SVG elements
    public static DslContainerElement svg(DslFrag_I... fragments) { return element("svg", fragments); }
    public static DslContainerElement defs(DslFrag_I... fragments) { return element("defs", fragments); }
    public static DslContainerElement g(DslFrag_I... fragments) { return element("g", fragments); }
    public static DslContainerElement rect(DslFrag_I... fragments) { return element("rect", fragments); }
    public static DslContainerElement circle(DslFrag_I... fragments) { return element("circle", fragments); }
    public static DslText textSvg(String content) { return new DslText(content); }
    public static DslContainerElement textSvg(double x, double y, String content) { 
        return element("text", new DslText(content)).withAttribute("x", String.valueOf(x)).withAttribute("y", String.valueOf(y)); 
    }
    public static DslContainerElement linearGradient(DslFrag_I... fragments) { return element("linearGradient", fragments); }
    public static DslContainerElement stop(DslFrag_I... fragments) { return element("stop", fragments); }
    public static DslContainerElement filter(DslFrag_I... fragments) { return element("filter", fragments); }
    public static DslContainerElement feDropShadow(DslFrag_I... fragments) { return element("feDropShadow", fragments); }
    
    
    private static DslContainerElement element(String tag, String ... strings){
        return element(tag, (DslFrag_I[]) List.of(strings).stream().map(s->text(s)).toArray(i->new DslText[i]));
    }
    private static DslContainerElement element(String tag, DslFrag_I... fragments) {
        var element = new DslContainerElement(tag);
        for (var fragment : fragments) {
            switch (fragment) {
                case DslAttribute attr -> element.setAttribute(attr.name(), attr.value());
                case DslContainerElement container -> element.addChild(container);
                case DslSelfClosingElement selfClosing -> element.addChild(selfClosing);
                case DslText text -> element.addChild(text);
                case DslStyledText styled -> element.addChild(styled);
                case DslFrags frags -> {
                    // Flatten DslFrags - add each fragment directly 
                    for (var childFragment : frags.fragments()) {
                        addFragmentToElement(element, childFragment);
                    }
                }
                default -> throw new IllegalArgumentException("Unknown fragment type: " + fragment.getClass());
            }
        }
        return element;
    }
    
    private static void addFragmentToElement(DslContainerElement element, DslFrag_I fragment) {
        switch (fragment) {
            case DslAttribute attr -> element.setAttribute(attr.name(), attr.value());
            case DslContainerElement container -> element.addChild(container);
            case DslSelfClosingElement selfClosing -> element.addChild(selfClosing);
            case DslText text -> element.addChild(text);
            case DslStyledText styled -> element.addChild(styled);
            case DslFrags frags -> {
                // Recursive flattening for nested DslFrags
                for (var childFragment : frags.fragments()) {
                    addFragmentToElement(element, childFragment);
                }
            }
            default -> throw new IllegalArgumentException("Unknown fragment type: " + fragment.getClass());
        }
    }
    
    // Additional overloaded methods for mixed attribute+text convenience
    public static DslContainerElement button(DslAttribute attr, String text) { return element("button", attr, new DslText(text)); }
    public static DslContainerElement a(DslAttribute attr, String text) { return element("a", attr, new DslText(text)); }
    public static DslContainerElement option(DslAttribute attr, String text) { return element("option", attr, new DslText(text)); }
}