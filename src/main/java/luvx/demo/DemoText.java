package luvx.demo;

import luvx.rendering_behavior.InlineMarkupRendering;
import luvx.rendering_behavior.MarkupRenderingBehavior_I;
import luvx.Text_I;
import luvx.composable.HasTextContent;

/**
 *
 * @
 */
public class DemoText implements Text_I<DemoText>, HasTextContent<DemoText> {

    private final String content;

    public DemoText(String content) {
        this.content = content;
    }

    @Override
    public DemoText self() {
        return this;
    } // Provides interface `this`

    @Override
    public String text() {
        return content;
    }

    @Override
    public String textContent() {
        return content;
    }

    @Override
    public InlineMarkupRendering markupRenderingBehavior() {
        return InlineMarkupRendering.I;
    }

    
    
}
