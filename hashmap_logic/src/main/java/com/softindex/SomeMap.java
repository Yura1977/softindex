package com.softindex;


public interface SomeMap<K,V> {

    /**
     * 1. If the backset is empty - then create a list object
     * 2. If there is no element on the key in the list, then add a new one
     * 3. Invalid - replace the old item in the list
     *
     * @param key
     * @param val
     * @return val
     */
    V put(K key, V val);

    /**
     * If the element is missing or referenced to a non-existent element - then returns null
     * Invalid return value
     *
     * @param key
     * @return val
     */
    V get(K key);

    int size();

}
