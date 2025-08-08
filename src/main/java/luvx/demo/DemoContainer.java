package luvx.demo;

import java.util.List;
import java.util.Map;
import luvx.BlockMarkupRendering;
import luvx.ContainerElement_I;
import luvx.Node_I;
import luvx.composable.HasAttributes;
import luvx.composable.HasChildNodes;

/**
 *
 * @
 */
public class DemoContainer implements ContainerElement_I<DemoContainer>,
        HasAttributes<DemoContainer>,
        HasChildNodes<DemoContainer> {

    private final String tagName;
    private final java.util.List<Node_I<?>> children = new java.util.ArrayList<>();
    private final java.util.Map<String, String> attributes = new java.util.HashMap<>();

    public DemoContainer(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public DemoContainer self() {
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

    public DemoContainer addChild(Node_I<?> child) {
        children.add(child);
        return self(); // self() enables fluent return
    }
    
    
    @Override
    public BlockMarkupRendering markupRenderingBehavior() {
        return BlockMarkupRendering.I;
    }

    
}
