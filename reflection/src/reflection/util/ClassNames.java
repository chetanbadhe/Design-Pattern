/**
 *
 */
package reflection.util;

/**
 * @author ChetanBadhe
 *
 */
public class ClassNames {

    /**
     * 
     * @param line
     * @return 
     */
    public String getClassName(String line) {
        String sstring = "xsi:type=\"";
        int start_index = line.indexOf("xsi:type=\"");
        int end_index = line.indexOf("\">");
        
        if (start_index != -1) {
            String classname = line.substring(start_index + sstring.length(), end_index);
            if ("reflection.util.MyAllTypesFirst".contains(classname)) {
                return "reflection.util.MyAllTypesFirst";
            } else if ("reflection.util.MyAllTypesSecond".contains(classname)) {
                return "reflection.util.MyAllTypesSecond";
            }
            return "ClassNotFound";
        } else {
            return "ClassNotFound";
        }
    }

    @Override
    public String toString() {
        return "ClassNames{" + '}';
    }

}
