package luvx.examples.dsl;

import java.util.List;
import java.util.Arrays;

/**
 * Pseudo-carrier for multiple DslFrag_I - like ScalaTags Frag
 * Gets flattened when added to containers, not a real container itself
 */
public class DslFrags implements DslFrag_I {
    private final List<DslFrag_I> fragments;
    
    public DslFrags(DslFrag_I... fragments) {
        this.fragments = Arrays.asList(fragments);
    }
    
    public DslFrags(List<DslFrag_I> fragments) {
        this.fragments = fragments;
    }
    
    public List<DslFrag_I> fragments() {
        return fragments;
    }
}