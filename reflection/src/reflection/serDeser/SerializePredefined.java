/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflection.serDeser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import reflection.util.ClassNames;

/**
 *
 * @author ChetanBadhe
 */
public class SerializePredefined implements Strategy {

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
    public SerializePredefined(String fname, SerializeTypes serializeTypes) {
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
            File myAllTypes = new File(System.getProperty("user.dir") + "//"+this.getFilename());
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

    @Override
    public void serializeObject(Vector deserialize) {
        try {
            CreateFile();
            String line = null;
            for (int i = 0; i < deserialize.size(); i++) {
                 if (i == 0) {
                    line = getNode(deserialize.get(i));
                } else {
                    line =System.getProperty("line.separator") + getNode(deserialize.get(i));
                }
                getBw().write(line);
                line = null;
            }
            getBw().close();
        } catch (Exception ex) {
            System.err.println(ex.toString());
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
        String[] sarray = null;
        try {
            if (object.getClass().getName().equalsIgnoreCase("reflection.util.MyAllTypesFirst")) {
                sarray = new String[5];
                Class mclass = object.getClass();
                Field[] method = mclass.getDeclaredFields();
                for (int i = 0; i < method.length; i++) {
                    method[i].setAccessible(true);
                    sarray[i] = method[i].get(object).toString();
                }
                line = this.serializeType.getMyAllTypesFirst(sarray);
            }
            if (object.getClass().getName().equalsIgnoreCase("reflection.util.MyAllTypesSecond")) {
                sarray = new String[5];
                Class mclass = object.getClass();
                Field[] method = mclass.getDeclaredFields();
                for (int i = 0; i < method.length; i++) {
                    method[i].setAccessible(true);
                    sarray[i] = method[i].get(object).toString();
                }
                line = this.serializeType.getMyAllTypesSecond(sarray);
            }
        } catch (Exception ex) {
            System.err.println(ex);
            System.exit(0);
        } 
        return line;
    }

    @Override
    public String toString() {
        return "SerializerPredefined{" + "filename=" + filename + ", bw=" + 
                bw + ", serializeType=" + serializeType + '}';
    }

}
