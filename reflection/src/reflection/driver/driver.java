/**
 * Assignment 3 Name- Chetan Badhe
 */
package reflection.driver;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import reflection.serDeser.Deserialize;
import reflection.serDeser.Serialization;
import reflection.serDeser.Serialize;
import reflection.serDeser.SerializePredefined;
import reflection.serDeser.Strategy;
import reflection.util.Debug;

/**
 * @author ChetanBadhe Driver code
 */
public class driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        if (args.length == 3) {
            File myAllTypes = new File(System.getProperty("user.dir") + "//" + args[0]);
            Debug.setDEBUG_VALUE(Integer.parseInt(args[2]));
			int debug = Integer.parseInt(args[2]);
            if (myAllTypes.exists() && debug <=1 && debug >= 0) {

                // Deserialization
                Deserialize deserialize = new Deserialize(args[0]);
                Vector deserializearray = deserialize.deserializeObject();

                //Invoke method to count unique instances
                deserialize.checkUniqueInstances(deserializearray);

                //Serialization strategies
                Strategy searialize = new Serialize(args[1], 
                        deserialize.getSerializeTypes());
                Strategy serializePredefined = new SerializePredefined(args[1],
                        deserialize.getSerializeTypes());

                Serialization serialization = new Serialization();

                //Invoke serializeObject method to write file
                serialization.serializeobject(searialize, deserializearray);
                serialization.serializeobject(serializePredefined, deserializearray);
            } else {
                System.err.println("Driver -"+"File does not exist!!!");
                System.exit(0);
            }
        } else {
            System.err.println("Driver -"+"Illegal paramter length");
            System.exit(0);
        }
    }

}
