package luvx.examples.dsl;

import luvx.composable.*;
import luvx.VoidElement_I;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import luvx.rendering_behavior.InlineMarkupRendering;
import luvx.rendering_behavior.MarkupRenderingBehavior_I;

/**
 * Self-closing element implementation - composable design using interfaces
 */
public class DslSelfClosingElement implements DslFrag_I, VoidElement_I<DslSelfClosingElement>, HasAttributes<DslSelfClosingElement> {
    private final String tagName;
    private final Map<String, String> attributes = new HashMap<>();
    
    public DslSelfClosingElement(String tagName) { this.tagName = tagName; }
    
    @Override public DslSelfClosingElement self() { return this; }
    @Override public String tagName() { return tagName; }
    
    @Override public Map<String, String> attributes() { return attributes; }
    @Override public String attr(String name) { return attributes.get(name); }
    
    public DslSelfClosingElement setAttribute(String name, String value) {
        attributes.put(name, value);
        return self();
    }
    
    public DslSelfClosingElement withAttribute(String name, String value) {
        return setAttribute(name, value);
    }

    @Override
    public MarkupRenderingBehavior_I markupRenderingBehavior() {
        return InlineMarkupRendering.I;
    }
    
    
}