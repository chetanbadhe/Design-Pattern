/**
 *
 */
package reflection.serDeser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ChetanBadhe
 *
 */
public class SerializeTypes {

    private String node = null;
    private String clsnode = null;
    private String datatypenode = null;
    String opentag = "<";
    String closetag = ">";
    String xsitag = "xsi:type=";
    String quotes = "\"";

    /**
     * @return the node
     */
    public String getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * @return the clsnode
     */
    public String getClsnode() {
        return clsnode;
    }

    /**
     * @param clsnode the clsnode to set
     */
    public void setClsnode(String clsnode) {
        this.clsnode = clsnode;
    }

    /**
     * @return the datatypenode
     */
    public String getDatatypenode() {
        return datatypenode;
    }

    /**
     * @param datatypenode the datatypenode to set
     */
    public void setDatatypenode(String datatypenode) {
        this.datatypenode = datatypenode;
    }

    public String getMyAllTypesFirst(String[] sarray) {
        String line = "<DPSerialization>" + System.getProperty("line.separator")
                + " <complexType xsi:type=\"reflection.util.MyAllTypesFirst\">" + System.getProperty("line.separator")
                + "  <myInt xsi:type=\"xsd:int\">" + sarray[0] + "</myInt>" + System.getProperty("line.separator")
                + "  <myString xsi:type=\"xsd:string\">" + sarray[1] + "</myString>" +System.getProperty("line.separator")
                + "  <myDouble xsi:type=\"xsd:double\">" + sarray[2] + "</myDouble>" + System.getProperty("line.separator")
                + "  <myLong xsi:type=\"xsd:long\">" + sarray[3] + "</myLong>" + System.getProperty("line.separator")
                + "  <myChar xsi:type=\"xsd:char\">" + sarray[4] + "</myChar>" + System.getProperty("line.separator")
                + " </complexType>" + System.getProperty("line.separator")
                + "</DPSerialization>";
        return line;
    }

    public String getMyAllTypesSecond(String[] sarray) {
        String line = "<DPSerialization>" + System.getProperty("line.separator")
                + " <complexType xsi:type=\"reflection.util.MyAllTypesSecond\">" + System.getProperty("line.separator")
                + "  <myIntS xsi:type=\"xsd:int\">" + sarray[0] + "</myIntS>" + System.getProperty("line.separator")
                + "  <myStringS xsi:type=\"xsd:string\">" + sarray[1] + "</myStringS>" + System.getProperty("line.separator")
                + "  <myFloatS xsi:type=\"xsd:float\">" + sarray[2] + "</myFloatS>" + System.getProperty("line.separator")
                + "  <myShortS xsi:type=\"xsd:short\">" + sarray[3] + "</myShortS>" +System.getProperty("line.separator")
                + "  <myCharS xsi:type=\"xsd:char\">" + sarray[4] + "</myCharS>" + System.getProperty("line.separator")
                + " </complexType>" + System.getProperty("line.separator")
                + "</DPSerialization>";
        return line;
    }
}
