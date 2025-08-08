package luvx.demo;

import java.util.Map;
import java.util.Set;
import luvx.Element_I;
import luvx.composable.HasChildNodes;

/**
 *
 * @
 */
public interface FluentElementMixin<I extends FluentElementMixin<I>> extends Element_I<I>, HasChildNodes<I> {
    // These default methods are ONLY possible because of self()!

    default I setStyle(String property, String value) {
        getStyles().put(property, value);
        return self(); // WITHOUT self(), this would be impossible!
    }

    default I addClass(String className) {
        getClasses().add(className);
        return self(); // Interface default method returns exact type!
    }

    // Required by implementers
    Map<String, String> getStyles();

    Set<String> getClasses();
}
