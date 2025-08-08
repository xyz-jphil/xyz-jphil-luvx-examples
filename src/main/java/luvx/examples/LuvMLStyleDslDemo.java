package luvx.examples;

import luvx.examples.dsl.*;
import luvx.ftype.*;

import static luvx.examples.dsl.DslElements.*;
import static luvx.examples.dsl.DslAttributes.*;

/**
 * Demonstration of LuvML-style Beautiful DSL Trees
 * 
 * This showcases the power of LuvX to create beautiful, readable domain-specific languages
 * similar to the elegant CroppedResponsiveSVG example.
 * 
 * Key features demonstrated:
 * - Static factory methods for clean syntax  
 * - String varargs patterns: p("hello", "world")
 * - Multi-line text utilities: multiLineTexts("line1", "line2")
 * - Mixed content: text() + styledText() combinations
 * - Nested element composition
 * - Breaking large HTML into smaller functions
 * - Comparison with JSX patterns
 * - Type-safe fluent APIs
 * - Beautiful tree-like structure
 * 
 * Inspired by: /mnt/f/Sharabheshwara/code/xyz-jphil/public_xyz-jphil/xyz-jphil-js/xyz-jphil-js-crsvgimg/src/main/java/xyz/jphil/js/CroppedResponsiveSVG.java
 */
public class LuvMLStyleDslDemo {

    /**
     * Beautiful DSL for creating HTML-like documents
     * Shows the elegant syntax possible with LuvX design
     */
    public static DslContainerElement createBeautifulDocument() {
        return html(
            createDocumentHead(),
            createDocumentBody()
        );
    }
    
    /**
     * Document head - broken into separate function for modularity
     */
    private static DslContainerElement createDocumentHead() {
        return head(
            title("LuvX Revolutionary Design"),
            meta(charset("UTF-8")),
            meta(name("viewport"), content("width=device-width, initial-scale=1.0")),
            createStyles()
        );
    }
    
    /**
     * Document styles - separate function for clean organization
     */
    private static DslContainerElement createStyles() {
        return style(
            "body { font-family: 'Arial', sans-serif; margin: 0; padding: 20px; }",
            ".container { max-width: 1200px; margin: 0 auto; }",
            ".header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 40px; border-radius: 10px; }",
            ".revolution { background: #f8f9fa; padding: 30px; margin: 20px 0; border-left: 5px solid #007bff; }",
            ".code-block { background: #2d3748; color: #e2e8f0; padding: 20px; border-radius: 8px; font-family: 'Courier New', monospace; }",
            ".demo-grid { display: grid; grid-template-columns: repeat(3, 1fr); gap: 20px; margin: 20px 0; }"
        );
    }
    
    /**
     * Document body - broken into separate function
     */
    private static DslContainerElement createDocumentBody() {
        return body(
            div(className("container"),
                createHeader(),
                createMainContent(),
                createFooter()
            )
        );
    }
    
    /**
     * Header section - separate function for modularity
     */
    private static DslContainerElement createHeader() {
        return header(className("header"),
            h1("LuvX: Revolutionary Java Design"),
            p(
                text("Achieving "), 
                styledText("union types", "font-weight: bold"), 
                text(" and solving interface "), 
                styledText("'this'", "color: #ffeb3b"), 
                text(" problem in pure Java")
            )
        );
    }
    
    /**
     * Main content - broken into logical sections
     */
    private static DslContainerElement createMainContent() {
        return DslElements.main(
            createUnionTypesSection(),
            createSelfPatternSection(), 
            createDiscriminationSection(),
            createInteractiveDemo()
        );
    }
    
    /**
     * Union types section
     */
    private static DslContainerElement createUnionTypesSection() {
        return section(className("revolution"),
            h2("Union Types in Java"),
            p("For the first time in Java history, we have true union types that work seamlessly with ",
              "pattern matching and provide compile-time safety. This revolutionary approach combines ",
              "the best of functional programming with Java's strong type system."),
            div(className("code-block"),
                multiLineTexts(
                    "FragType_I = Attr_T | Node_T",
                    "NodeType_I = AttributelessNode_T | Element_T", 
                    "ElementType_I = SelfClosingElement_T | ContainerElement_T"
                )
            )
        );
    }
    
    /**
     * self() Pattern section  
     */
    private static DslContainerElement createSelfPatternSection() {
        return section(className("revolution"),
            h2("Self-Bounded Generics + self()"),
            p("The interface 'this' problem has plagued Java developers for years. With self-bounded generics ",
              "and the self() pattern, we finally have a clean solution that enables true fluent APIs ",
              "without casting or losing type information."),
            div(className("code-block"),
                multiLineTexts(
                    "interface Element_I<I extends Element_I<I>> {",
                    "    I self(); // Provides access to actual 'this'",
                    "    default I addChild(Node_I<?> child) {",
                    "        return self(); // Fluent chaining!",
                    "    }",
                    "}"
                )
            )
        );
    }
    
    /**
     * Discrimination section
     */
    private static DslContainerElement createDiscriminationSection() {
        return section(className("revolution"),
            h2("Method-Based Discriminated Union Interfaces"),
            p("Traditional inheritance hierarchies suffer from the diamond problem and brittle coupling. ",
              "Our method-based discriminated unions prevent diamond inheritance through intentional method conflicts, ",
              "creating clean, extensible type hierarchies that work perfectly with pattern matching."),
            ul(
                li("Union behavior without diamond problems"),
                li("Exhaustive pattern matching like sealed types"),
                li("But extensible unlike sealed types"),
                li("Zero-cast type discrimination")
            )
        );
    }
    
    /**
     * Interactive demo section
     */
    private static DslContainerElement createInteractiveDemo() {
        return article(id("demo-showcase"),
            h3("Interactive Elements Demo"),
            div(className("demo-grid"),
                button(onClick("alert('Union types in action!')"), "Click for Union Demo"),
                input(type("text"), placeholder("Type-safe input"), value("LuvX rocks!")),
                select(
                    option(value("union"), "Union Types"),
                    option(value("self"), "self() Pattern"), 
                    option(value("discrimination"), "Type Discrimination")
                )
            )
        );
    }
    
    /**
     * Footer section
     */
    private static DslContainerElement createFooter() {
        return footer(
            p("Built with LuvX - Revolutionary Java Design Pattern"),
            div(
                a(href("https://github.com/uskoag"), "GitHub"),
                text(" | "),
                a(href("mailto:contact@example.com"), "Contact"), 
                text(" | "),
                span("Made with ❤️ and revolutionary thinking")
            )
        );
    }

    /**
     * JSX vs LuvX Comparison Demo
     */
    public static void demonstrateJSXComparison() {
        System.out.println("\n=== JSX vs LuvX Comparison ===");
        
        System.out.println("JSX (React):");
        System.out.println("const MyComponent = () => (");
        System.out.println("  <div className=\"container\">");
        System.out.println("    <header className=\"header\">");
        System.out.println("      <h1>My App</h1>");
        System.out.println("      <p>Welcome to <strong>revolutionary</strong> design</p>");
        System.out.println("    </header>");
        System.out.println("    <main>");
        System.out.println("      <section className=\"content\">");
        System.out.println("        <button onClick={() => alert('Hello')}>Click me</button>");
        System.out.println("      </section>");
        System.out.println("    </main>");
        System.out.println("  </div>");
        System.out.println(");");
        
        System.out.println("\nLuvX (Java):");
        var jsxEquivalent = div(className("container"),
            header(className("header"),
                h1("My App"),
                p(
                    text("Welcome to "), 
                    styledText("revolutionary", "font-weight: bold"), 
                    text(" design")
                )
            ),
            DslElements.main(
                section(className("content"),
                    button(onClick("alert('Hello')"), "Click me")
                )
            )
        );
        
        System.out.println("✓ Created equivalent structure with type safety");
        System.out.println("✓ String varargs and mixed content patterns");
        System.out.println("✓ Modular composition like JSX components");
        System.out.println("✓ But with compile-time guarantees JSX lacks!");
    }

    /**
     * Beautiful DSL for creating SVG graphics (similar to CroppedResponsiveSVG example)
     */
    public static DslContainerElement createBeautifulSVG() {
        final double width = 400, height = 300;
        final String gradientId = "revolutionGradient";
        
        return svg(
            xmlns("http://www.w3.org/2000/svg"),
            viewBox(0, 0, width, height),
            width(width), 
            height(height),
            
            createSVGDefinitions(gradientId),
            createSVGBackground(width, height, gradientId),
            createSVGContent(width),
            createSVGFeatureBoxes()
        );
    }
    
    private static DslContainerElement createSVGDefinitions(String gradientId) {
        return defs(
            linearGradient(id(gradientId),
                stop(offset("0%"), stopColor("#667eea")),
                stop(offset("100%"), stopColor("#764ba2"))
            ),
            filter(id("shadow"),
                feDropShadow(dx(2), dy(2), stdDeviation(3))
            )
        );
    }
    
    private static DslContainerElement createSVGBackground(double width, double height, String gradientId) {
        return rect(x(0), y(0), width(width), height(height), 
                   fill("url(#" + gradientId + ")"), 
                   filter("url(#shadow)"));
    }
    
    private static DslContainerElement createSVGContent(double width) {
        return g(
            // Title
            textSvg(width/2, 50, "LuvX Revolution").withAttribute("text-anchor", "middle")
                                                   .withAttribute("fill", "white")
                                                   .withAttribute("font-size", "24")
                                                   .withAttribute("font-weight", "bold"),
            
            // Union symbol
            g(transform("translate(200, 150)"),
                circle(cx(-50), cy(0), r(30), fill("rgba(255,255,255,0.2)"), stroke("white"), strokeWidth(2)),
                circle(cx(50), cy(0), r(30), fill("rgba(255,255,255,0.2)"), stroke("white"), strokeWidth(2)),
                textSvg(0, 5, "∪").withAttribute("text-anchor", "middle")
                                  .withAttribute("fill", "white")
                                  .withAttribute("font-size", "16")
            )
        );
    }
    
    private static DslContainerElement createSVGFeatureBoxes() {
        return g(
            // Union Types box
            g(transform("translate(50, 200)"),
                rect(x(0), y(0), width(90), height(60), fill("rgba(255,255,255,0.1)"), stroke("white")),
                textSvg(45, 20, "Union").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "12"),
                textSvg(45, 35, "Types").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "12"), 
                textSvg(45, 50, "A | B").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "10")
            ),
            
            // self() Pattern box
            g(transform("translate(160, 200)"),
                rect(x(0), y(0), width(90), height(60), fill("rgba(255,255,255,0.1)"), stroke("white")),
                textSvg(45, 20, "self()").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "12"),
                textSvg(45, 35, "Pattern").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "12"),
                textSvg(45, 50, "I self()").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "10")
            ),
            
            // Zero Cast box  
            g(transform("translate(270, 200)"),
                rect(x(0), y(0), width(90), height(60), fill("rgba(255,255,255,0.1)"), stroke("white")),
                textSvg(45, 20, "Zero").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "12"),
                textSvg(45, 35, "Cast").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "12"),
                textSvg(45, 50, "var x = t.text()").withAttribute("text-anchor", "middle").withAttribute("fill", "white").withAttribute("font-size", "10")
            )
        );
    }

    public static void main(String[] args) {
        System.out.println("LuvML-Style DSL Demonstration");
        System.out.println("=============================");
        
        // Create beautiful documents using DSL
        var htmlDoc = createBeautifulDocument();
        var svgGraphic = createBeautifulSVG();
        
        System.out.println("✓ Created beautiful HTML document with modular composition");
        System.out.println("✓ Created elegant SVG graphic with component breakdown"); 
        System.out.println("✓ Demonstrated String varargs and mixed content patterns");
        
        System.out.println("\nDSL Features Demonstrated:");
        System.out.println("- Static factory methods for clean syntax");
        System.out.println("- String varargs: p(\"hello\", \"world\")");
        System.out.println("- Multi-line utilities: multiLineTexts(\"line1\", \"line2\")");
        System.out.println("- Mixed content: text() + styledText() combinations");
        System.out.println("- Modular composition breaking large structures into functions");
        System.out.println("- Type-safe construction throughout");
        System.out.println("- Beautiful tree-like readable structure");
        System.out.println("- Zero casting with full type safety");
        
        // Show JSX comparison
        demonstrateJSXComparison();
        
        // Show the power of type discrimination even in complex DSL
        System.out.println("\nType discrimination works even in complex DSL:");
        System.out.println("HTML: " + discriminateElement(htmlDoc));
        System.out.println("SVG: " + discriminateElement(svgGraphic));
        
        // Demonstrate simple text mixing
        System.out.println("\n=== Simple Text Mixing Demo ===");
        var textMixingDemo = p(
            text("This mixes "), 
            styledText("styled text", "color: red"),
            text(" with "),
            br(),
            text("regular strings and "),
            styledText("another styled piece", "font-weight: bold"),
            text(" seamlessly!")
        );
        System.out.println("Text mixing element: " + discriminateElement(textMixingDemo));
        
        // Demonstrate multiLineTexts pseudo-carrier
        System.out.println("\n=== Multi-Line Texts Demo ===");
        var multiLineDemo = div(
            h3("Code Example:"),
            pre(multiLineTexts(
                "interface Element_I<I extends Element_I<I>> {",
                "    I self(); // Provides access to actual 'this'", 
                "    default I addChild(Node_I<?> child) {",
                "        return self(); // Fluent chaining!",
                "    }",
                "}"
            ))
        );
        System.out.println("Multi-line element: " + discriminateElement(multiLineDemo));
    }
    
    private static String discriminateElement(DslFrag_I element) {
        return switch (element) {
            case DslContainerElement container -> "ContainerElement[tag=" + container.tagName() + 
                                                 ", children=" + container.childNodes().size() + "]";
            case DslSelfClosingElement selfClosing -> "SelfClosingElement[tag=" + selfClosing.tagName() + "]";
            case DslText text -> "Text[content=" + text.textContent() + "]";
            case DslStyledText styled -> "StyledText[content=" + styled.textContent() + ", style=" + styled.attr("style") + "]";
            case DslFrags frags -> "Frags[fragments=" + frags.fragments().size() + "]";
            case DslAttribute attr -> "Attribute[" + attr.name() + "=" + attr.value() + "]";
            default -> "Unknown[" + element.getClass().getSimpleName() + "]";
        };
    }
}