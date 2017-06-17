package com.softindex.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SomeHashMapTest {

    private SomeHashMap hashMap;

    /**
     * Constructors to initialize the size of an internal array in the list
     */
    @Before
    public void setUp() {
        hashMap = new SomeHashMap(10);
    }

    @After
    public void tearDown(){
        hashMap = null;
    }

    /**
     * test NotCollision
     */
    @Test
    public void testNotCollision(){
        Assert.assertEquals("1", hashMap.hashFunc(0), 0);
        Assert.assertEquals("2", hashMap.hashFunc(1), 1);
        Assert.assertEquals("3", hashMap.hashFunc(9), 9);
    }

    /**
     * test IsCollision
     */
    @Test
    public void testIsCollision(){
        Assert.assertEquals("1", hashMap.hashFunc(10), 0);
        Assert.assertEquals("1", hashMap.hashFunc(11), 1);
        Assert.assertEquals("7", hashMap.hashFunc(99), 9);
    }

    /**
     * test Put Add.Null
     */
    @Test
    public void testPutAddNull(){
        Assert.assertEquals("null,100l", hashMap.put(null, 100l), 100l);
        Assert.assertEquals("null,101l", hashMap.put(null, 101l), 101l);
        Assert.assertEquals("null,200l", hashMap.put(null, 200l), 200l);
    }

    /**
     * test Put Add.Illegal
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPutAddIllegal() throws IllegalArgumentException {
        Assert.assertEquals("-1,100l", hashMap.put(-1, 100l), 100l);
    }

    /**
     * test Put.Add (Valid)
     */
    @Test
    public void testPutAddValid(){
        Assert.assertEquals("1,100l", hashMap.put(1, 100l), 100l);
        Assert.assertEquals("11,102l", hashMap.put(11, 102l), 102l);
        Assert.assertEquals("2,200l", hashMap.put(2, 200l), 200l);
        Assert.assertEquals("3,300l", hashMap.put(3, 300l), 300l);
        Assert.assertEquals("77,707l", hashMap.put(77, 707l), 707l);
    }

    /**
     * test Put.Update
     */
    @Test
    public void testPutUpdate(){
        Assert.assertEquals("1,100l", hashMap.put(1, 100l), 100l);
        Assert.assertEquals("1,101l", hashMap.put(1, 101l), 101l);
    }

    /**
     * test GetIsFound
     */
    @Test
    public void testGetIsFound(){
        hashMap.put(1, 100l);
        hashMap.put(1, 101l);
        hashMap.put(11, 102l);
        hashMap.put(2, 200l);
        hashMap.put(3, 300l);
        hashMap.put(77, 707l);

        Assert.assertEquals("101l", hashMap.get(1), 101l);
        Assert.assertEquals("102l", hashMap.get(11), 102l);
        Assert.assertEquals("200l", hashMap.get(2), 200l);
        Assert.assertEquals("300l", hashMap.get(3), 300l);
        Assert.assertEquals("707l", hashMap.get(77), 707l);
    }

    /**
     * test GetNotFound
     */
    @Test
    public void testGetNotFound(){
        final Long expected = null;

        Assert.assertEquals("null", hashMap.get(5), expected);
        Assert.assertEquals("null", hashMap.get(7), expected);
    }

    /**
     * test size
     */
    @Test
    public void testSize(){
        hashMap.put(1, 100l);
        hashMap.put(1, 101l);
        hashMap.put(11, 102l);
        hashMap.put(2, 200l);
        hashMap.put(3, 300l);
        hashMap.put(77, 707l);

        final int expected = 5;

        Assert.assertEquals("5", hashMap.size(), expected);
    }

    /**
     * test HashMap Content
     */
    @Test
    public void testHashMapContent(){
        hashMap.put(1, 100l);
        hashMap.put(1, 101l);
        hashMap.put(11, 102l);
        hashMap.put(2, 200l);
        hashMap.put(3, 300l);
        hashMap.put(77, 707l);

        String actual = hashMap.toString();
        final String expected = "[{key=1, value=101},{key=11, value=102},{key=2, value=200},{key=3, value=300},{key=77, value=707},]";

        Assert.assertEquals(actual, expected);
    }
}
