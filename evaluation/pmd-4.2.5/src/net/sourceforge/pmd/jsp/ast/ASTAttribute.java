/* Generated By:JJTree: Do not edit this line. ASTAttribute.java */

package net.sourceforge.pmd.jsp.ast;

public class ASTAttribute extends SimpleNode {
    /* BEGIN CUSTOM CODE */
    private String name;

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return boolean - true if the element has a namespace-prefix, false otherwise
     */
    public boolean isHasNamespacePrefix() {
        return (name.indexOf(':') >= 0);
    }

    /**
     * @return String - the part of the name that is before the (first) colon (":")
     */
    public String getNamespacePrefix() {
        int colonIndex = name.indexOf(':');
        return ((colonIndex >= 0)
                ? name.substring(0, colonIndex)
                : "");
    }

    /**
     * @return String - The part of the name that is after the first colon (":").
     *         If the name does not contain a colon, the full name is returned.
     */
    public String getLocalName() {
        int colonIndex = name.indexOf(':');
        return ((colonIndex >= 0)
                ? name.substring(colonIndex + 1)
                : name);
    }

    /* (non-Javadoc)
     * @see com.applicationengineers.pmd4jsp.ast.SimpleNode#toString(java.lang.String)
     */
    public String toString(String prefix) {
        return super.toString(prefix) + " name=[" + name + "]";
    }

/* END CUSTOM CODE */


    public ASTAttribute(int id) {
        super(id);
    }

    public ASTAttribute(JspParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor. *
     */
    public Object jjtAccept(JspParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }
}
