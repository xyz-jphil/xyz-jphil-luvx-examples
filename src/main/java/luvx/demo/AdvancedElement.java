package luvx.demo;

import java.util.List;
import java.util.Map;
import luvx.BlockMarkupRendering;
import luvx.ContainerElement_I;
import luvx.MarkupRenderingBehavior_I;
import luvx.Node_I;

/**
 *
 * @
 */
public class AdvancedElement implements AdvancedElementMixin<AdvancedElement>,
        ContainerElement_I<AdvancedElement> // AI missed adding this
{

    private final String tagName;
    private final java.util.List<Node_I<?>> children = new java.util.ArrayList<>();
    private final java.util.Map<String, String> attributes = new java.util.HashMap<>();
    private final java.util.Map<String, String> customStyles = new java.util.HashMap<>();
    private long timestamp;
    
    private final MarkupRenderingBehavior_I markupRenderingBehavior;
    

    public AdvancedElement(String tagName) {
        this(tagName, BlockMarkupRendering.I);
    }

    public AdvancedElement(String tagName, MarkupRenderingBehavior_I markupRenderingBehavior) {
        this.tagName = tagName;
        this.markupRenderingBehavior = markupRenderingBehavior;
    }
    
    

    @Override
    public AdvancedElement self() {
        return this;
    }

    @Override
    public String tagName() {
        return tagName;
    }

    @Override
    public List<? extends Node_I<?>> childNodes() {
        return children;
    }

    @Override
    public Map<String, String> attributes() {
        return attributes;
    }

    @Override
    public String attr(String name) {
        return attributes.get(name);
    }

    @Override
    public java.util.Map<String, String> getCustomStyles() {
        return customStyles;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public AdvancedElement withTimestamp() {
        this.timestamp = System.currentTimeMillis();
        return self();
    }

    public String getAdvancedFeature() {
        return "advanced-processing";
    }

    @Override
    public MarkupRenderingBehavior_I markupRenderingBehavior() {
        return markupRenderingBehavior;
    }
}
