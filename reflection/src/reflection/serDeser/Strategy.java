/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflection.serDeser;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ChetanBadhe
 */
public interface Strategy {
    public void serializeObject(Vector deserialize);
}
