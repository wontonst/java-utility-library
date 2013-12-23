/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wontonst.util.datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test all functionality.
 *
 * @author RoyZheng
 */
public class BlockingListTest {

    public BlockingListTest() {
    }
    BlockingList<Object> instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ArrayList<Object> list2 = new ArrayList<Object>();
        instance = new BlockingList<Object>(list2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of push method, of class BlockingList.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object o = new Object();
        for (int i = 0; i != 100; i++) {
            instance.push(o);
            Assert.assertEquals(i + 1, instance.size());
        }
    }

    /**
     * Test of pop method, of class BlockingList.
     */
    @Test
    public void testPopInstant() {
        int testSize = 1000;
        for (int i = 0; i != testSize; i++) {
            instance.push(new Object());
        }
        for (int i = 0; i != testSize/2; i++) {
            instance.popInstant();
        }
        Assert.assertEquals(testSize/2, instance.size());
        for (int i = 0; i != testSize/2; i++) {
            instance.popBlocking();
        }
        Assert.assertEquals(0, this.instance.size());
    }
/**
 * Test of threading, of class BlockingList
 */
    @Test
    public void testThreading(){
        for(int i = 0; i !=)
    }
    /**
     * Test of size method, of class BlockingList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        BlockingList instance = null;
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class BlockingList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class BlockingList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object o = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.contains(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class BlockingList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        BlockingList instance = null;
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class BlockingList.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        BlockingList instance = null;
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class BlockingList.
     */
    @Test
    public void testToArray_ObjectArr() {
        System.out.println("toArray");
        Object[] a = null;
        BlockingList instance = null;
        Object[] expResult = null;
        Object[] result = instance.toArray(a);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BlockingList.
     */
    @Test
    public void testAdd_GenericType() {
        System.out.println("add");
        Object e = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.add(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BlockingList.
     */
    @Test
    public void testRemove_Object() {
        System.out.println("remove");
        Object o = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsAll method, of class BlockingList.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection c = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.containsAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class BlockingList.
     */
    @Test
    public void testAddAll_Collection() {
        System.out.println("addAll");
        Collection c = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.addAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class BlockingList.
     */
    @Test
    public void testAddAll_int_Collection() {
        System.out.println("addAll");
        int index = 0;
        Collection c = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.addAll(index, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class BlockingList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection c = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.removeAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class BlockingList.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection c = null;
        BlockingList instance = null;
        boolean expResult = false;
        boolean result = instance.retainAll(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class BlockingList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        BlockingList instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class BlockingList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        BlockingList instance = null;
        Object expResult = null;
        Object result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class BlockingList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object element = null;
        BlockingList instance = null;
        Object expResult = null;
        Object result = instance.set(index, element);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class BlockingList.
     */
    @Test
    public void testAdd_int_Object() {
        System.out.println("add");
        int index = 0;
        Object element = null;
        BlockingList instance = null;
        instance.add(index, element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BlockingList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 0;
        BlockingList instance = null;
        Object expResult = null;
        Object result = instance.remove(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class BlockingList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        BlockingList instance = null;
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastIndexOf method, of class BlockingList.
     */
    @Test
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        Object o = null;
        BlockingList instance = null;
        int expResult = 0;
        int result = instance.lastIndexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class BlockingList.
     */
    @Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        BlockingList instance = null;
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class BlockingList.
     */
    @Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int index = 0;
        BlockingList instance = null;
        ListIterator expResult = null;
        ListIterator result = instance.listIterator(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subList method, of class BlockingList.
     */
    @Test
    public void testSubList() {
        System.out.println("subList");
        int fromIndex = 0;
        int toIndex = 0;
        BlockingList instance = null;
        List expResult = null;
        List result = instance.subList(fromIndex, toIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}