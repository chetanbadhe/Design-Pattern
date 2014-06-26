/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflection.serDeser;

import java.util.Vector;

/**
 *
 * @author ChetanBadhe
 */
public class Serialization {
    private Strategy strategy;

    
    /**
     * @return the strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * 
     * @param strategy
     * @param deserialize 
     */
    public void serializeobject(Strategy strategy, Vector deserialize){
        this.setStrategy(strategy);
        this.getStrategy().serializeObject(deserialize);
    }

    @Override
    public String toString() {
        return "Serialization{" + "strategy=" + strategy + '}';
    }

}
