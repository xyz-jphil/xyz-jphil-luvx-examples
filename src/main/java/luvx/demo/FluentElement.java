package luvx.demo;

import java.util.List;
import java.util.Map;
import luvx.rendering_behavior.BlockMarkupRendering;
import luvx.ContainerElement_I;
import luvx.rendering_behavior.InlineMarkupRendering;
import luvx.rendering_behavior.MarkupRenderingBehavior_I;
import luvx.Node_I;
import luvx.composable.HasAttributes;
import luvx.composable.HasChildNodes;

/**
 *
 * @
 */
public class FluentElement implements FluentElementMixin<FluentElement>,
        ContainerElement_I<FluentElement>, // AI missed this
        HasAttributes<FluentElement> {

    private final String tagName;
    private final java.util.List<Node_I<?>> children = new java.util.ArrayList<>();
    private final java.util.Map<String, String> attributes = new java.util.HashMap<>();
    private final java.util.Map<String, String> styles = new java.util.HashMap<>();
    private final java.util.Set<String> classes = new java.util.HashSet<>();
    private final String customData = "fluent-enabled";

    public FluentElement(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public FluentElement self() {
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
    public java.util.Map<String, String> getStyles() {
        return styles;
    }

    @Override
    public java.util.Set<String> getClasses() {
        return classes;
    }

    public String getCustomData() {
        return customData;
    }

    public FluentElement addChild(Node_I<?> child) {
        children.add(child);
        return self();
    }

    @Override
    public MarkupRenderingBehavior_I markupRenderingBehavior() {
        if(this instanceof HasChildNodes)
            return BlockMarkupRendering.I; // assume block
        return InlineMarkupRendering.I;
    }

}
