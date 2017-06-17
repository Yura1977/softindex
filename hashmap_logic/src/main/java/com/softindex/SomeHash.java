package com.softindex;

import org.apache.log4j.Logger;


public abstract class SomeHash {

    private static final Logger logger = Logger.getLogger(SomeHash.class);

    protected abstract int getCapacity();

    /**
     * Function for emulating the hash code
     * It returns the index number on the last digit of the number
     *
     * @param hashCode
     * @return hash
     */
    public final int hashFunc(final int hashCode){
        int hash = (hashCode < getCapacity())
                ? hashCode
                : hashFunc(hashCode - getCapacity());
        logger.debug("'" + hash + "';");
        return hash;
    }
}
