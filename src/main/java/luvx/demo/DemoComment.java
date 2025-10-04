package luvx.demo;

import luvx.Comment_I;
import luvx.rendering_behavior.InlineMarkupRendering;
import luvx.composable.HasTextContent;

/**
 *
 * @
 */
public class DemoComment implements Comment_I<DemoComment>, HasTextContent<DemoComment> {

    private final String content;

    public DemoComment(String content) {
        this.content = content;
    }

    @Override
    public String textContent() {
        return "<!-- " + content + " -->"; // implementation specific - as it is not necessary we will always implement XML, it would be yml for example!
    }

    @Override
    public DemoComment self() {
        return this;
    }

    @Override
    public String comment() {
        return content;
    }

    @Override
    public InlineMarkupRendering markupRenderingBehavior() {
        return InlineMarkupRendering.I;
    }

}
