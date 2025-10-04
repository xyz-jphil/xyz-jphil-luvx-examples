package luvx.examples.dsl;

import luvx.composable.*;
import luvx.VoidElement_I;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import luvx.rendering_behavior.InlineMarkupRendering;
import luvx.rendering_behavior.MarkupRenderingBehavior_I;

/**
 * Styled text element - like HTML span with style attribute
 * This IS an element (span), not pure text
 */
public class DslStyledText implements DslFrag_I, VoidElement_I<DslStyledText>, HasAttributes<DslStyledText>, HasTextContent<DslStyledText> {
    private final String content;
    private final Map<String, String> attributes = new HashMap<>();
    
    public DslStyledText(String content, String style) { 
        this.content = content; 
        this.attributes.put("style", style);
    }
    
    @Override public DslStyledText self() { return this; }
    @Override public String textContent() { return content; }
    @Override public String tagName() { return "span"; }
    
    // HasAttributes implementation
    @Override public Map<String, String> attributes() { return attributes; }
    @Override public String attr(String name) { return attributes.get(name); }
    
    public DslStyledText setAttribute(String name, String value) {
        attributes.put(name, value);
        return self();
    }
    
    @Override public String toString() { return content; }
    
    
    @Override
    public MarkupRenderingBehavior_I markupRenderingBehavior() {
        return InlineMarkupRendering.I;
    }
}