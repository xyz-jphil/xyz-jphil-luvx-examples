package luvx.examples.dsl;

import luvx.Node_I;

/**
 * Common interface for all DSL nodes (elements and text) - implements Node_I from Frag_I hierarchy
 */
public interface DslNode extends DslFrag_I, Node_I<DslNode> {
    @Override
    DslNode self();
}