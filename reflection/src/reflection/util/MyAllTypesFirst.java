/**
 *
 */
package reflection.util;

import java.lang.reflect.Field;

/**
 * @author ChetanBadhe
 *
 */
public class MyAllTypesFirst {

    int myInt;
    String myString;
    Double myDouble;
    Long myLong;
    char myChar;

    /**
     * @return the myInt
     */
    public int getMyInt() {
        return myInt;
    }

    /**
     * @param myInt the myInt to set
     */
    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

    /**
     * @return the myString
     */
    public String getMyString() {
        return myString;
    }

    /**
     * @param myString the myString to set
     */
    public void setMyString(String myString) {
        this.myString = myString;
    }

    /**
     * @return the myDouble
     */
    public Double getMyDouble() {
        return myDouble;
    }

    /**
     * @param myDouble the myDouble to set
     */
    public void setMyDouble(Double myDouble) {
        this.myDouble = myDouble;
    }

    /**
     * @return the myLong
     */
    public Long getMyLong() {
        return myLong;
    }

    /**
     * @param myLong the myLong to set
     */
    public void setMyLong(Long myLong) {
        this.myLong = myLong;
    }

    /**
     * @return the myChar
     */
    public char getMyChar() {
        return myChar;
    }

    /**
     * @param myChar the myChar to set
     */
    public void setMyChar(char myChar) {
        this.myChar = myChar;
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
                if (method[j].get(obja) != method[j].get(this)) {
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
        int hash = 7;
        hash = 31 * hash + this.getMyInt();
        hash = 31 * hash + this.getMyString().hashCode();
        hash = 31 * hash + this.getMyDouble().hashCode();
        hash = 31 * hash + this.getMyLong().hashCode();
        hash = 31 * hash + this.getMyChar();
        return hash;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "MyAllTypesFirst [myInt=" + myInt + ", myString=" + myString
                + ", myDouble=" + myDouble + ", myLong=" + myLong + ", myChar="
                + myChar + ", getMyInt()=" + getMyInt() + ", getMyString()="
                + getMyString() + ", getMyDouble()=" + getMyDouble()
                + ", getMyLong()=" + getMyLong() + ", getMyChar()="
                + getMyChar() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
