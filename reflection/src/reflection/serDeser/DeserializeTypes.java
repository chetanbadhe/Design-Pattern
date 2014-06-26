/**
 *
 */
package reflection.serDeser;

import java.lang.reflect.Method;

/**
 * @author ChetanBadhe
 *
 */
public class DeserializeTypes {

    /**
     * 
     * @param line
     * @return 
     */
    public String getDataType(String line) {
        String sstring = "xsi:type=\"xsd:";
        int start_index = line.indexOf(sstring);
        int end_index = line.indexOf("\">");
        if (start_index != -1) {
            String datatype = line.substring(start_index + sstring.length(), end_index);
            return datatype;
        }
        return "DatatypeNotFound";
    }

    /**
     * 
     * @param line
     * @return 
     */
    public String getVaraibleName(String line) {
        int start_index = line.indexOf("<");
        int end_index = line.indexOf(" ");
        String variable = line.substring(start_index + 1, end_index);
        //System.out.println(variable);
        return variable;
    }

    /**
     * 
     * @param line
     * @return 
     */
    public String getValue(String line) {
        int start_index = line.indexOf(">");
        int end_index = line.indexOf("</");
        String value = line.substring(start_index + 1, end_index);
        //System.out.println(value);
        return value;
    }
    
    /**
     * 
     * @return 
     */
    public String getMethodName(String fieldname, Class mclass){
        Method[] allMethods = mclass.getDeclaredMethods();
        for(Method m : allMethods){
            String mname = m.getName().toLowerCase();
            if(mname.contains(fieldname.toLowerCase()) && mname.contains("set"))
                return m.getName();
       }   
        return null;
    }

    @Override
    public String toString() {
        return "DeserializeTypes{" + '}';
    }

}
