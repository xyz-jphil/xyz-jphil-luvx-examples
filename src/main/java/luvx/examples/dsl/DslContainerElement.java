package luvx.examples.dsl;

import luvx.composable.*;
import luvx.ContainerElement_I;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import luvx.rendering_behavior.BlockMarkupRendering;
import luvx.rendering_behavior.MarkupRenderingBehavior_I;

/**
 * Container element implementation - composable design using interfaces
 */
public class DslContainerElement implements DslFrag_I, ContainerElement_I<DslContainerElement>, HasAttributes<DslContainerElement>, HasChildNodes<DslContainerElement> {
    private final String tagName;
    private final List<luvx.Node_I<?>> children = new java.util.ArrayList<>();
    private final Map<String, String> attributes = new HashMap<>();
    
    public DslContainerElement(String tagName) { this.tagName = tagName; }
    
    @Override public DslContainerElement self() { return this; }
    @Override public String tagName() { return tagName; }
    @Override public List<? extends luvx.Node_I<?>> childNodes() { return children; }
    @Override public Map<String, String> attributes() { return attributes; }
    @Override public String attr(String name) { return attributes.get(name); }
    
    public DslContainerElement addChild(Object child) {
        if (child instanceof luvx.Node_I<?> node) {
            children.add(node);
        }
        return self();
    }
    
    public DslContainerElement setAttribute(String name, String value) {
        attributes.put(name, value);
        return self();
    }
    
    public DslContainerElement withAttribute(String name, String value) {
        return setAttribute(name, value);
    }

    @Override
    public MarkupRenderingBehavior_I markupRenderingBehavior() {
        return BlockMarkupRendering.I;
    }
}