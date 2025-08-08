package luvx.demo;

import luvx.Element_I;
import luvx.Node_I;
import luvx.composable.HasAttributes;
import luvx.composable.HasChildNodes;

/**
 * Advanced element with fluent interface defaults
 *
 * @
 */
public interface AdvancedElementMixin<I extends AdvancedElementMixin<I>> extends Element_I<I>,
        HasAttributes<I>,
        HasChildNodes<I>,
        Timestamped<I> {
    // All these are INTERFACE DEFAULT METHODS enabled by self()!

    default I withAttribute(String name, String value) {
        attributes().put(name, value);
        return self(); // Fluent interface default method!
    }

    default I withChild(Node_I<?> child) {
        ((java.util.List<Node_I<?>>) childNodes()).add(child);
        return self(); // Fluent interface default method!
    }

    default I withStyle(String property, String value) {
        getCustomStyles().put(property, value);
        return self(); // Fluent interface default method!
    }

    java.util.Map<String, String> getCustomStyles();
}
