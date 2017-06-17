package com.softindex;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class SomeMapTest {

    /**
     * test Put Add.Null
     */
    @Test
    public void testPutAddNull(){
        SomeMap<Integer, Long> some = mock(SomeMap.class);
        when(some.put(null,100l)).thenReturn(100l);
        when(some.put(null,101l)).thenReturn(101l);
        when(some.put(null,200l)).thenReturn(200l);

        assertEquals(100l, (Object)some.put(null,100l));
        assertEquals(101l, (Object)some.put(null,101l));
        assertEquals(200l, (Object)some.put(null,200l));
    }

    /**
     * test Put.Add (Valid)
     */
    @Test
    public void testPutAdd() {
        SomeMap<Integer, Long> some = mock(SomeMap.class);
        when(some.put(1,100l)).thenReturn(100l);
        when(some.put(2,200l)).thenReturn(200l);

        assertEquals(100l, (Object)some.put(1, 100l));
        assertEquals(200l, (Object)some.put(2, 200l));
    }

    /**
     * test-mock Put.Update
     */
    @Test
    public void testPutUpdate() {
        SomeMap<Integer, Long> some = mock(SomeMap.class);
        when(some.put(1,100l)).thenReturn(100l);
        when(some.put(1,101l)).thenReturn(101l);

        assertEquals(100l, (Object)some.put(1, 100l));
        assertEquals(101l, (Object)some.put(1, 101l));
    }

    /**
     * test-mock GetIsFound
     */
    @Test
    public void testGetIsFound() {
        SomeMap<Integer, Long> some = mock(SomeMap.class);
        when( some.get(1) ).thenReturn(100l);

        assertEquals(100l, (Object)some.get(1));
    }

    /**
     * test-mock GetNotFound
     */
    @Test
    public void testGetNotFound() {
        SomeMap<Integer, Long> some = mock(SomeMap.class);
        when( some.get(anyInt()) ).thenReturn(null);

        assertEquals(null, some.get(5));
    }
}
