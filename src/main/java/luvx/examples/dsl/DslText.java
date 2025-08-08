package luvx.examples.dsl;

import luvx.composable.*;
import luvx.Text_I;
import java.util.List;
import luvx.InlineMarkupRendering;
import luvx.MarkupRenderingBehavior_I;

/**
 * Pure text content - implements Text_I directly, no attributes
 */
public class DslText implements DslFrag_I, Text_I<DslText>, HasTextContent<DslText> {
    private final String content;
    
    public DslText(String content) { this.content = content; }
    
    @Override public DslText self() { return this; }
    @Override public String textContent() { return content; }
    @Override public String toString() { return content; }
    
    
    @Override
    public MarkupRenderingBehavior_I markupRenderingBehavior() {
        return InlineMarkupRendering.I;
    }
}