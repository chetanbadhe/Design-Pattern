/**
 *
 */
package reflection.serDeser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;
import reflection.util.ClassNames;
import reflection.util.Debug;
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;

/**
 * @author ChetanBadhe
 *
 */
public class Deserialize {

    private String filename = null;
    private BufferedReader br = null;
    private Vector<Object> arrayObject = null;
    private SerializeTypes serializeTypes = null;

    /* *
     *   Paramterised constructor
     */
    public Deserialize(String fname) {
        try {
            this.setFilename(fname);
            this.setBr(new BufferedReader(new FileReader(
                    System.getProperty("user.dir") + "//" + this.getFilename())));
            this.setArrayObject(new Vector<Object>());
            this.setSerializeTypes(new SerializeTypes());
        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(0);
        }
    }

    /**
     * @return the br
     */
    public BufferedReader getBr() {
        return br;
    }

    /**
     * @param br the br to set
     */
    public void setBr(BufferedReader br) {
        this.br = br;
    }

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
     * @return the arrayObject
     */
    public Vector<Object> getArrayObject() {
        return arrayObject;
    }

    /**
     * @param arrayObject the arrayObject to set
     */
    public void setArrayObject(Vector<Object> arrayObject) {
        this.arrayObject = arrayObject;
    }

    /**
     * @return the serializeTypes
     */
    public SerializeTypes getSerializeTypes() {
        return serializeTypes;
    }

    /**
     * @param serializeTypes the serializeTypes to set
     */
    public void setSerializeTypes(SerializeTypes serializeTypes) {
        this.serializeTypes = serializeTypes;
    }

    /**
     * deserializeObject
     *
     * @return ArrayList
     */
    public Vector deserializeObject() {
        Object obj = null;
        String node = null;
        String snode = null;
        try {
            while ((node = getBr().readLine()) != null) {
                if (this.serializeTypes.getNode() == null) {
                    snode = node.replace("<", "").replace(">", "");
                    this.serializeTypes.setNode(snode);
                }
                obj = getObject(node);

                getArrayObject().add(obj);
                obj = null;

            }
        } catch (Exception e) {
            System.err.println(e.toString());
            System.exit(0);
        }
        Debug.println(1, getArrayObject().toString());
        return getArrayObject();
    }

    /**
     * Creates new instance of the object and return it
     *
     * @param node
     * @return Object
     */
    public Object getObject(String node) {
        Object clsobject = null;
        try {
            String line = null;
            DeserializeTypes deserializeTypes = new DeserializeTypes();
            ClassNames clsName = new ClassNames();
            Class mclass = null;
            String name = null;
            String dttype = null;
            String dtname = null;
            String dtvalue = null;

            do {
                dttype = null;
                line = br.readLine().trim();
                if ((dttype = deserializeTypes.getDataType(line)) != "DatatypeNotFound") {
                    if (this.serializeTypes.getDatatypenode() == null) {
                        int start_index = line.indexOf(" ");
                        int end_index = line.indexOf("d:");
                        this.serializeTypes.setDatatypenode(line.substring(
                                start_index + 1, end_index + 2));
                    }
                    dtname = deserializeTypes.getVaraibleName(line);
                    dtvalue = deserializeTypes.getValue(line);
                    Field myfield = mclass.getDeclaredField(dtname);
                    myfield.setAccessible(true);
                    if (dttype.equalsIgnoreCase("Int")) {
                        myfield.set(clsobject, Integer.parseInt(dtvalue));
                    } else if (dttype.equalsIgnoreCase("double")) {
                        myfield.set(clsobject, Double.parseDouble(dtvalue));
                    } else if (dttype.equalsIgnoreCase("String")) {
                        myfield.set(clsobject, dtvalue);
                    } else if (dttype.equalsIgnoreCase("long")) {
                        myfield.set(clsobject, Long.parseLong(dtvalue));
                    } else if (dttype.equalsIgnoreCase("char")) {
                        myfield.set(clsobject, dtvalue.charAt(0));
                    } else if (dttype.equalsIgnoreCase("short")) {
                        myfield.set(clsobject, Short.parseShort(dtvalue));
                    } else if (dttype.equalsIgnoreCase("float")) {
                        myfield.set(clsobject, Float.parseFloat(dtvalue));
                    }
                    //System.out.println(myfield.get(clsobject));
                } else if (((name = clsName.getClassName(line)) != "ClassNotFound") 
                        && (line != "</complexType>")) {
                    mclass = Class.forName(name);
                    clsobject = mclass.newInstance();
                    if (this.serializeTypes.getClsnode() == null) {
                        String[] sarray = line.split(" ");
                        String clsnode = sarray[0].replace("<", "").replace(">", "");
                        this.serializeTypes.setClsnode(clsnode);
                    }
                }

                //System.out.println(line);
            } while (!line.equalsIgnoreCase("</DPSerialization>"));
        } catch (Exception e) {
            System.err.println("Deserialize -" + e.toString());
            System.exit(0);
        }
        return clsobject;
    }

    /**
     * Creates new instance of the object and return it
     *
     * @param node
     * @return Object
     */
    public Object getObject1(String node) {
        Object clsobject = null;
        try {
            String line = null;
            DeserializeTypes deserializeTypes = new DeserializeTypes();
            ClassNames clsName = new ClassNames();
            Class mclass = null;
            String name = null;
            String dttype = null;
            String dtname = null;
            String dtvalue = null;
            Method method = null;
            Class[] param = null;
            do {
                dttype = null;
                line = br.readLine().trim();
                if ((dttype = deserializeTypes.getDataType(line)) != "DatatypeNotFound") {
                    if (this.serializeTypes.getDatatypenode() == null) {
                        int start_index = line.indexOf(" ");
                        int end_index = line.indexOf("d:");
                        this.serializeTypes.setDatatypenode(line.substring(
                                start_index + 1, end_index + 2));
                    }
                    dtname = deserializeTypes.getVaraibleName(line);
                    dtvalue = deserializeTypes.getValue(line);
                    method = null;
                    param = new Class[1];

                    String mname = deserializeTypes.getMethodName(dtname, mclass);

                    if (dttype.equalsIgnoreCase("Int")) {
                        param[0] = Integer.TYPE;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, Integer.parseInt(dtvalue));
                    } else if (dttype.equalsIgnoreCase("double")) {
                        param[0] = Double.class;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, Double.parseDouble(dtvalue));

                    } else if (dttype.equalsIgnoreCase("String")) {
                        param[0] = String.class;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, dtvalue);

                    } else if (dttype.equalsIgnoreCase("long")) {
                        param[0] = Long.class;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, Long.parseLong(dtvalue));

                    } else if (dttype.equalsIgnoreCase("char")) {
                        param[0] = char.class;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, dtvalue.charAt(0));

                    } else if (dttype.equalsIgnoreCase("short")) {
                        param[0] = Short.TYPE;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, Short.parseShort(dtvalue));

                    } else if (dttype.equalsIgnoreCase("float")) {
                        param[0] = Float.TYPE;
                        method = mclass.getDeclaredMethod(mname, param);
                        method.invoke(clsobject, Float.parseFloat(dtvalue));

                    }
                    //System.out.println(myfield.get(clsobject));
                } else if (((name = clsName.getClassName(line)) != "ClassNotFound")
                        && (line != "</complexType>")) {
                    mclass = Class.forName(name);
                    clsobject = mclass.newInstance();
                    if (this.serializeTypes.getClsnode() == null) {
                        String[] sarray = line.split(" ");
                        String clsnode = sarray[0].replace("<", "").replace(">", "");
                        this.serializeTypes.setClsnode(clsnode);
                    }
                }

                //System.out.println(line);
            } while (!line.equalsIgnoreCase("</DPSerialization>"));
        } catch (Exception e) {
            System.err.println("Deserialize -" + e.toString());
            System.exit(0);
        }
        return clsobject;
    }

    /**
     * Check unique instance of the object
     *
     * @param list
     */
    public void checkUniqueInstances(Vector list) {
        int MyAllTypesFirst = 0;
        int MyAllTypesSecond = 0;
        boolean isuniquea = true;

        boolean isuniqueb = true;
        Vector<Integer> onearrayObject = new Vector<Integer>();
        Vector<Integer> secarrayObject = new Vector<Integer>();

        for (int i = 0; i < list.size(); i++) {
            Object o = list.elementAt(i);
            //System.out.println(o.hashCode());
            if (o.getClass().getName().equalsIgnoreCase("reflection.util.MyAllTypesFirst")
                    && !onearrayObject.contains(o.hashCode())) {
                onearrayObject.add(o.hashCode());
            }
            if (o.getClass().getName().equalsIgnoreCase("reflection.util.MyAllTypesSecond")
                    && !secarrayObject.contains(o.hashCode())) {
                secarrayObject.add(o.hashCode());
            }

        }
        String println = "Unique MyAllTypesFirst = " + onearrayObject.size() + 
                " Unique MyAllTypesSecond = " + secarrayObject.size();
        Debug.println(0, println);
    }

    @Override
    public String toString() {
        String returnString = "[Deserialize]: ";
        for (int i = 0; i < this.getArrayObject().size(); i++) {
            if(this.getArrayObject().elementAt(i).getClass().getName().
                    equalsIgnoreCase("reflection.util.MyAllTypesFirst")){
                MyAllTypesFirst myAllTypesFirst = (MyAllTypesFirst) 
                        this.getArrayObject().elementAt(i);
                returnString +=  myAllTypesFirst.toString() + 
                        System.getProperty("line.separator");
            }
            else
            {
            MyAllTypesSecond myAllTypesSecond = (MyAllTypesSecond) 
                    this.getArrayObject().elementAt(i);
                returnString +=  myAllTypesSecond.toString() + 
                        System.getProperty("line.separator");
            }
                
        }
        return returnString;

    }

}
