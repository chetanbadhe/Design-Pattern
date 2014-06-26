/**
 *
 */
package reflection.serDeser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import reflection.util.ClassNames;

/**
 * @author ChetanBadhe
 *
 */
public class Serialize implements Strategy {

    private String filename = null;
    private BufferedWriter bw = null;
    private SerializeTypes serializeType = null;

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the bw
     */
    public BufferedWriter getBw() {
        return bw;
    }

    /**
     * @param bw the bw to set
     */
    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    /**
     * @return the serializeType
     */
    public SerializeTypes getSerializeType() {
        return serializeType;
    }

    /**
     * @param serializeType the serializeType to set
     */
    public void setSerializeType(SerializeTypes serializeType) {
        this.serializeType = serializeType;
    }

    /* *
     *   Paramterised constructor
     */
    public Serialize(String fname, SerializeTypes serializeTypes) {
        this.setFilename(fname);
        this.setBw(CreateFile());
        this.setSerializeType(serializeTypes);
    }

    /**
     * Method to create file
     */
    public BufferedWriter CreateFile() {
        FileWriter fw = null;
        try {
            File myAllTypes = new File(System.getProperty("user.dir") + "//" + 
                    this.getFilename());
            if (!myAllTypes.exists()) {
                try {
                    myAllTypes.createNewFile();
                } catch (Exception ex) {
                    System.err.println(ex.toString());
                }
            }
            fw = new FileWriter(myAllTypes.getAbsoluteFile());
            return (new BufferedWriter(fw));
        } catch (IOException ex) {
            System.err.println(ex.toString());
            System.exit(0);
            return null;
        }
    }

    /**
     *
     * @param deserialize
     */
    @Override
    public void serializeObject(Vector deserialize) {
        try {
            String line = null;
            for (int i = 0; i < deserialize.size(); i++) {
                if (i != 0) {
                    line = System.getProperty("line.separator");
                    line += getNode(deserialize.get(i));
                } else {
                    line = getNode(deserialize.get(i));
                }
                getBw().write(line);
                line = null;
            }
            getBw().close();
        } catch (IOException ex) {
            System.err.println(ex);
            System.exit(0);
        }
    }

    /**
     *
     * @param object
     * @return string node
     */
    public String getNode(Object object) {
        String line = null;
        Object classNames = new ClassNames();

        line = this.serializeType.opentag + this.serializeType.getNode() + 
                this.serializeType.closetag + System.getProperty("line.separator");
        line += " " + this.serializeType.opentag + this.serializeType.getClsnode() + " ";
        line += this.serializeType.xsitag + this.serializeType.quotes;
        line += object.getClass().getName() + this.serializeType.quotes + 
                this.serializeType.closetag + System.getProperty("line.separator");

        if (object.getClass().getName().equalsIgnoreCase("reflection.util.MyAllTypesFirst")) {
            try {
                Class mclass = object.getClass();
                Field[] method = mclass.getDeclaredFields();
                for (int j = 0; j < method.length; j++) {
                    method[j].setAccessible(true);
                    String vname = method[j].getName().toString();
                    String[] sdttype = method[j].getType().toString().split("\\.");
                    String datatype = null;
                    if (sdttype.length > 1) {
                        datatype = sdttype[sdttype.length - 1].toLowerCase();
                    } else {
                        datatype = sdttype[0].toLowerCase();
                    }
                    line += "  " + this.serializeType.opentag + vname + " " + 
                            this.serializeType.getDatatypenode() + datatype + 
                            this.serializeType.quotes + this.serializeType.closetag 
                            + method[j].get(object) + this.serializeType.opentag +
                            "/" + vname + this.serializeType.closetag + 
                            System.getProperty("line.separator");
                }
                line += " " + this.serializeType.opentag + "/" + 
                        this.serializeType.getClsnode() + this.serializeType.closetag
                        + System.getProperty("line.separator") + 
                        this.serializeType.opentag + "/" + this.serializeType.getNode()
                        + this.serializeType.closetag;
            } catch (Exception ex) {
                System.err.println(ex);
                System.exit(0);
            }
        }
        if (object.getClass().getName().equalsIgnoreCase("reflection.util.MyAllTypesSecond")) {
            try {
                Class mclass = object.getClass();
                Field[] method = mclass.getDeclaredFields();
                for (int j = 0; j < method.length; j++) {
                    method[j].setAccessible(true);
                    String vname = method[j].getName().toString();
                    String[] sdttype = method[j].getType().toString().split("\\.");
                    String datatype = null;
                    if (sdttype.length > 1) {
                        datatype = sdttype[sdttype.length - 1].toLowerCase();
                    } else {
                        datatype = sdttype[0].toLowerCase();
                    }
                    line += "  " + this.serializeType.opentag + vname + " " + 
                            this.serializeType.getDatatypenode() + datatype + 
                            this.serializeType.quotes + this.serializeType.closetag + 
                            method[j].get(object) + this.serializeType.opentag + "/" +
                            vname + this.serializeType.closetag + 
                            System.getProperty("line.separator");
                }
                line += " " + this.serializeType.opentag + "/" + 
                        this.serializeType.getClsnode() + this.serializeType.closetag 
                        + System.getProperty("line.separator") + 
                        this.serializeType.opentag + "/" + this.serializeType.getNode()
                        + this.serializeType.closetag;
            } catch (Exception ex) {
                System.err.println(ex);
                System.exit(0);
            }
        }
        return line;
    }

    @Override
    public String toString() {
        return "Serializer{" + "filename=" + filename + ", bw=" + bw + ", serializeType=" + serializeType + '}';
    }

}
