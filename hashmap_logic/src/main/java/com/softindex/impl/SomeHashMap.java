package com.softindex.impl;

import com.softindex.SomeHash;
import com.softindex.SomeMap;
import org.apache.log4j.Logger;
import java.util.LinkedList;
import java.util.List;


public class SomeHashMap<K,V>  extends SomeHash implements SomeMap<K,V>, Cloneable {

    private static final Logger logger = Logger.getLogger(SomeHashMap.class);

    private int  DEFAULT_CAPACITY;
    private volatile int     size;
    private List<Entry>[] entries;
    private Entry entryNull;

    public SomeHashMap(){
        DEFAULT_CAPACITY = 16;
        entries = new LinkedList[DEFAULT_CAPACITY];
        logger.warn("'" + DEFAULT_CAPACITY + "';");
    }

    public SomeHashMap(final int capacity) throws IllegalArgumentException {
        if (capacity<1) {
            logger.debug("'Illegal Argument';");
            throw new IllegalArgumentException("Illegal Argument");
        }
        DEFAULT_CAPACITY = capacity;
        entries          = new LinkedList[capacity];
        logger.debug("'" + DEFAULT_CAPACITY + "';");
    }

    @Override
    public int getCapacity(){
        return DEFAULT_CAPACITY;
    }

    @Override
    public V put(final K key, final V val) throws IllegalArgumentException {
        synchronized(entries){
            int hash = 0;
            if (key==null){
                logger.debug("'null';");
                entryNull = new Entry();
                entryNull.setValue(val);
                return val;
            } else if (key.hashCode()<0){
                logger.debug("'Illegal Argument';");
                throw new IllegalArgumentException("Illegal Argument");
            } else {
                hash = hashFunc(key.hashCode());
            }
            if (entries[ hash ] != null){
                for (Entry e : entries[ hash ]){
                    if (key.equals(e.getKey())){
                        e.setValue(val);
                        logger.debug("'update';");
                        return val;
                    }
                }
            } else {
                entries[ hash ] = new LinkedList<>();
                logger.debug("'create';");
            }
            entries[ hash ].add(new Entry(key,val));
            logger.debug("'add';");
            ++size;
        }
        return val;
    }

    @Override
    public V get(final K key) {
        synchronized(entries){
            int hash = hashFunc(key.hashCode());
            if (entries[ hash ] != null){
                for (Entry e : entries[ hash ]){
                    if (key.equals(e.getKey())){
                        logger.debug("'" + e.getValue() + "';");
                        return e.getValue();
                    }
                }
            }
        }
        logger.debug("'null';");
        return null;
    }

    @Override
    public int size(){
        logger.debug("'" + size + "';");
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (List<Entry> entry : entries) {
            if (entry != null){
                for (Entry e : entry) {
                    sb.append(e + ",");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }


    private class Entry {
        private K key;
        private V value;

        protected Entry(){
        }

        protected Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        protected K getKey() {
            return key;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        protected V getValue() {
            return value;
        }

        protected void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
