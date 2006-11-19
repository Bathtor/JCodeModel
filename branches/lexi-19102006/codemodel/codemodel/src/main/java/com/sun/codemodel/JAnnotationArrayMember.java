/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 * 
 * You can obtain a copy of the license at
 * https://jwsdp.dev.java.net/CDDLv1.0.html
 * See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jwsdp.dev.java.net/CDDLv1.0.html  If applicable,
 * add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your
 * own identifying information: Portions Copyright [yyyy]
 * [name of copyright owner]
 */
package com.sun.codemodel;


import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an arrays as annotation members
 *
 * <p>
 * This class implements {@link JAnnotatable} to allow
 * new annotations to be added as a member of the array.
 *
 * @author
 *     Bhakti Mehta (bhakti.mehta@sun.com)
 */
public final class JAnnotationArrayMember extends JAnnotationValue implements JAnnotatable {
    private final List<JAnnotationValue> values = new ArrayList<JAnnotationValue>();
    private final JCodeModel owner;

    JAnnotationArrayMember(JCodeModel owner) {
        this.owner = owner;
    }

    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a string value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(String value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a boolean value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(boolean value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }
    
    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a byte value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(byte value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }
    
    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a char value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(char value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a double value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(double value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a long value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(long value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }
    
    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a short value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(short value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds an array member to this annotation
     *
     * @param value Adds an int value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(int value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds an array member to this annotation
     *
     * @param value Adds a float value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(float value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(JExpr.lit(value));
        values.add(annotationValue);
        return this;
    }
    
    /**
     * Adds a enum array member to this annotation
     *
     * @param value Adds a enum value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(final Enum value) {
        JAnnotationValue annotationValue = new JAnnotationValue() {
            public void generate(JFormatter f) {
                f.t(owner.ref(value.getDeclaringClass())).p('.').p(value.name());
            }
        };
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds a enum array member to this annotation
     *
     * @param value Adds a enum value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(final JEnumConstant value) {
        JAnnotationValue annotationValue = new JAnnotationStringValue(value);
        values.add(annotationValue);
        return this;
    }
    

    /**
     * Adds a class array member to this annotation
     *
     * @param value Adds a class value to the array member
     * @return The JAnnotationArrayMember. More elements can be added by calling
     *         the same method multiple times
     */
    public JAnnotationArrayMember param(final Class value){
       JAnnotationValue annotationValue = new JAnnotationStringValue(
    		   new JExpressionImpl() {
      			 public void generate(JFormatter f) {
      				 f.p(value.getName().replace('$', '.'));
      				 f.p(".class");
      			}
      		 });
       values.add(annotationValue);
       return this;
   }

    public JAnnotationArrayMember param(JType type){
        JClass clazz = type.boxify();
        JAnnotationValue annotationValue = new JAnnotationStringValue ( clazz.dotclass() );
        values.add(annotationValue);
        return this;
    }

    /**
     * Adds a new annotation to the array.
     */
    public JAnnotationUse annotate(Class<? extends Annotation> clazz){
        return annotate(owner.ref(clazz));
    }

    /**
     * Adds a new annotation to the array.
     */
    public JAnnotationUse annotate(JClass clazz){
        JAnnotationUse a = new JAnnotationUse(clazz);
        values.add(a);
        return a;
    }

    public <W extends JAnnotationWriter> W annotate2(Class<W> clazz) {
        return TypedAnnotationWriter.create(clazz,this);
    }

    /**
     * Adds an annotation member to this annotation  array
     * This can be used for e.g &#64;XmlCollection(values= &#64;XmlCollectionItem(type=Foo.class))
     * @param value
     *        Adds a annotation  to the array member
     * @return
     *        The JAnnotationArrayMember. More elements can be added by calling
     *        the same method multiple times
     *
     * @deprecated
     *      use {@link #annotate}
     */
    public JAnnotationArrayMember param (JAnnotationUse value ){
        values.add(value);
        return this;
    }

    public void generate(JFormatter f) {
        f.p('{').nl().i();

        boolean first = true;
        for (JAnnotationValue aValue : values) {
            if (!first)
                f.p(',').nl();
            f.g(aValue);
            first = false;
        }
        f.nl().o().p('}');
    }
}

