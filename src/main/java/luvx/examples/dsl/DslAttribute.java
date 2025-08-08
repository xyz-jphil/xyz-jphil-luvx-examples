package luvx.examples.dsl;

import luvx.Attr_I;

/**
 * Attribute implementation - implements Attr_I from Frag_I hierarchy
 */
public class DslAttribute implements DslFrag_I, Attr_I<DslAttribute> {
    private final String name;
    private final String value;
    
    public DslAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    @Override public DslAttribute self() { return this; }
    @Override public String name() { return name; }
    @Override public String value() { return value; }
}