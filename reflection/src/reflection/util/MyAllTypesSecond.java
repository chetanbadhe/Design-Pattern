/**
 *
 */
package reflection.util;

import java.lang.reflect.Field;

/**
 * @author ChetanBadhe
 *
 */
public class MyAllTypesSecond {

    int myIntS;
    String myStringS;
    float myFloatS;
    short myShortS;
    private char myCharS;

    /**
     * @return the myIntS
     */
    public int getMyIntS() {
        return myIntS;
    }

    /**
     * @param myIntS the myIntS to set
     */
    public void setMyIntS(int myIntS) {
        this.myIntS = myIntS;
    }

    /**
     * @return the myStringS
     */
    public String getMyStringS() {
        return myStringS;
    }

    /**
     * @param myStringS the myStringS to set
     */
    public void setMyStringS(String myStringS) {
        this.myStringS = myStringS;
    }

    /**
     * @return the myFloatS
     */
    public float getMyFloatS() {
        return myFloatS;
    }

    /**
     * @param myFloatS the myFloatS to set
     */
    public void setMyFloatS(float myFloatS) {
        this.myFloatS = myFloatS;
    }

    /**
     * @return the myShortS
     */
    public short getMyShortS() {
        return myShortS;
    }

    /**
     * @param myShortS the myShortS to set
     */
    public void setMyShortS(short myShortS) {
        this.myShortS = myShortS;
    }

 
 /**
     * @return the myCharS
     */
    public char getMyCharS() {
        return myCharS;
    }

    /**
     * @param myCharS the myCharS to set
     */
    public void setMyCharS(char myCharS) {
        this.myCharS = myCharS;
    }
    @Override
    public boolean equals(Object obja) {
        if (this == null) {
            return false;
        }
        if (obja == null) {
            return false;
        }
        if (this.getClass() != obja.getClass()) {
            return false;
        }
        Class mclass = obja.getClass();
        Field[] method = mclass.getDeclaredFields();
        for (int j = 0; j < method.length; j++) {
            try {
                method[j].setAccessible(true);
                if (method[j].get(obja).hashCode() != method[j].get(this).hashCode()) {
                    return false;
                }
            } catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 31 * hash + this.getMyIntS();
        hash = 31 * hash + this.getMyStringS().hashCode();
        hash = 31 * hash + Float.toString(this.getMyFloatS()).hashCode();
        hash = 31 * hash + Short.toString(this.getMyShortS()).hashCode();
        hash = 31 * hash + this.getMyCharS();
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MyAllTypesSecond [myIntS=" + myIntS + ", myStringS="
                + myStringS + ", myFloatS=" + myFloatS + ", myShortS="
                + myShortS + ", myCharS=" + getMyCharS() + ", getMyIntS()="
                + getMyIntS() + ", getMyStringS()=" + getMyStringS()
                + ", getMyFloatS()=" + getMyFloatS() + ", getMyShortS()="
                + getMyShortS() + ", getMyChar()=" + getMyCharS()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

   
}
