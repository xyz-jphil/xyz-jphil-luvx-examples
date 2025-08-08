package luvx.examples;

import luvx.Frag_I;
import luvx.ftype.*;

/**
 * Demonstration of the elegant hierarchical type discrimination pattern.
 * 
 * Shows how unsealed interfaces + final class wrappers + pattern matching
 * enable clean nested switching with exhaustive pattern matching and safe type access.
 * 
 * Pattern features:
 * - Final classes wrap interface instances: new Node_T(self())
 * - Accessor methods provide safe casting: node(), element()
 * - Type delegation methods: nodeType(), elementType()
 * - Self-documenting variable names: Attr_T a, Node_T n, Element_T e
 */
public class TypeDiscriminationDemo {
    
    public static <I extends Frag_I<I>> String getDetailedType(I frag) {
        
        return switch (frag.fragType()) {
            case Attr_T a -> "Attribute";
            
            case Node_T n -> switch (n.nodeType()) {
                case AttributelessNode_T an -> switch ( an.attributelessNodeType()) {
                    case StringNode_T s -> switch (s.stringNodeType()) {
                        case Text_T t -> "Text";
                        case Comment_T c -> "Comment";
                        case CData_T c -> "CData";
                    };
                    case Doctype_T d -> "Doctype";
                };
                case Element_T e -> switch (e.elementType()) {
                    case SelfClosingElement_T sce -> switch (sce.selfClosingElementType()) {
                        case VoidElement_T ve -> "VoidElement";
                        case ProcessingInstruction_T pi -> "ProcessingInstruction";
                    };
                    case ContainerElement_T ce -> "ContainerElement";
                };
            };
        };
    }
    
    public static <I extends Frag_I<I>> String getGeneralType(I frag) {
        return switch (frag.fragType()) {
            case Attr_T a -> "Any Attribute";
            case Node_T n -> switch (n.nodeType()) {
                case AttributelessNode_T an -> "Any AttributelessNode"; 
                case Element_T e -> "Any Element";
            };
            case Frags_T f -> "collection of fragments";
        };
    }
    
    public static <I extends Frag_I<I>> void processFragment(I frag) {
        switch (frag.fragType()) {
            case Attr_T a -> {
                var attrNode = a.attr();  
                System.out.println("Processing attribute: " + attrNode.fragType());
            }
            case Node_T n -> {
                switch (n.nodeType()) {
                    case Element_T e -> {
                        var element = e.element();
                        System.out.println("Processing element: " + element.tagName());
                        
                        switch (e.elementType()) {
                            case ContainerElement_T ce -> {
                                var containerElem = ce.containerElement();
                                System.out.println("Container has " + 
                                    containerElem.childNodes().size() + " children");
                            }
                            case SelfClosingElement_T sce -> {
                                System.out.println("Self-closing element (no children)");
                            }
                        }
                    }
                    case AttributelessNode_T an -> {
                        switch (an.attributelessNodeType()) {
                            case StringNode_T s -> {
                                var stringNode = s.stringNode();
                                System.out.println("Text content: " + stringNode.textContent());
                            }
                            case Doctype_T d -> {
                                var docType = d.doctype();
                                System.out.println("DOCTYPE: " + docType.name());
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Shows the power of extensibility - custom implementations can be added
     * without breaking existing code, as long as they implement the type functions
     * and provide appropriate final class wrappers.
     */
    public static <I extends Frag_I<I>> void handleExtensibleFragment(I frag) {
        // This will work even with custom fragment types not known at compile time
        System.out.println("Fragment type: " + getDetailedType(frag));
        
        // The nested switching pattern scales to any hierarchy depth
        // Custom fragments just need:
        // 1. Implement type functions (nodeType(), elementType(), etc.)
        // 2. Provide final class wrappers with accessor methods
        // 3. Return new WrapperClass(self()) from interfaces
    }
}