package com.softindex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SomeHashMapTest {

    private SomeHashMap hashMap;

    @Before
    public void setUp() {
        hashMap = new SomeHashMap();
    }

    /**
     * test GetIsFound
     */
    @Test
    public void testGetIsFound(){
        hashMap.put(1, 100);
        hashMap.put(1, 101);
        hashMap.put(11, 102);
        hashMap.put(2, 200);
        hashMap.put(3, 300);
        hashMap.put(77, 707);

        Assert.assertEquals("101", hashMap.get(1), 101);
        Assert.assertEquals("102", hashMap.get(11), 102);
        Assert.assertEquals("200", hashMap.get(2), 200);
        Assert.assertEquals("300", hashMap.get(3), 300);
        Assert.assertEquals("707", hashMap.get(77), 707);
    }

    /**
     * test size
     */
    @Test
    public void testSize(){
        hashMap.put(1, 100);
        hashMap.put(1, 101);
        hashMap.put(11, 102);
        hashMap.put(2, 200);
        hashMap.put(3, 300);
        hashMap.put(77, 707);

        final int expected = 6;

        Assert.assertEquals("5", hashMap.size(), expected);
    }

    /**
     * test HashMap Content
     */
    @Test
    public void testHashMapContent(){
        hashMap.put(1, 100);
        hashMap.put(1, 101);
        hashMap.put(11, 102);
        hashMap.put(2, 200);
        hashMap.put(3, 300);
        hashMap.put(77, 707);

        String actual = hashMap.toString();
        final String expected = "[{key=1, value=101},{key=2, value=200},{key=3, value=300},{key=11, value=102},{key=77, value=707},]";

        Assert.assertEquals(actual, expected);
    }
}
