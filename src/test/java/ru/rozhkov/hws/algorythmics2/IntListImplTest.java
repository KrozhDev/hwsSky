package ru.rozhkov.hws.algorythmics2;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.rozhkov.hws.algorythmics1.StringListImpl;
import ru.rozhkov.hws.algorythmics2.exceptions.NoElementException;
import ru.rozhkov.hws.algorythmics2.exceptions.OutOfBoundsException;

public class IntListImplTest extends TestCase {

    private IntList testIntList;

    @BeforeEach
    public void setUp() {
        testIntList = createTestIntList();
    }

    private IntList createTestIntList() {
        IntList tSL = new IntListImpl(4);
        tSL.add(1);
        tSL.add(5);
        tSL.add(10);
        return tSL;
    }


    @Test
    public void testAdd() {
        Integer expected = 6;
        Integer actual = testIntList.add(6);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testTestAdd() {
        Integer expected = 6;
        Integer actual = testIntList.add(2,6);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected,testIntList.toArray()[2]);
        Assertions.assertEquals(10,testIntList.toArray()[3]);
        Assertions.assertThrows(OutOfBoundsException.class, () -> testIntList.add(6,7));
    }
    @Test
    public void testSet() {
        Integer expected = 6;
        Integer actual = testIntList.set(1,6);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected,testIntList.toArray()[1]);
        Assertions.assertEquals(10,testIntList.toArray()[2]);
        Assertions.assertThrows(OutOfBoundsException.class, () -> testIntList.set(5,7));
    }

    @Test
    public void testRemove() {
        Integer expected = 1;
        Integer actual = testIntList.remove((Integer) 1);
        Assertions.assertEquals(expected, actual);
        expected = 10;
        Assertions.assertEquals(expected,testIntList.toArray()[1]);
        Assertions.assertThrows(NoElementException.class, () -> testIntList.remove((Integer) 4));
    }
    @Test
    public void testTestRemove() {
        Integer expected = 5;
        Integer actual = testIntList.remove(1);
        Assertions.assertEquals(expected, actual);
        expected = 10;
        Assertions.assertEquals(expected,testIntList.toArray()[1]);
        Assertions.assertThrows(OutOfBoundsException.class, () -> testIntList.remove(6));
    }
    @Test
    public void testContains() {
        boolean expected = true;
        Assertions.assertEquals(expected, testIntList.contains(5) );
        expected = false;
        Assertions.assertEquals(expected, testIntList.contains(6) );
    }
    @Test
    public void testIndexOf() {
        testIntList.add(1);
        int expected = 0;
        Assertions.assertEquals(expected, testIntList.indexOf(1) );
        expected = -1;
        Assertions.assertEquals(expected, testIntList.indexOf(3) );
    }
    @Test
    public void testLastIndexOf() {
        testIntList.add(1);
        int expected = 3;
        Assertions.assertEquals(expected, testIntList.lastIndexOf(1) );
        expected = -1;
        Assertions.assertEquals(expected, testIntList.lastIndexOf(6) );
    }
    @Test
    public void testGet() {
        Assertions.assertEquals(5,testIntList.get(1));
        Assertions.assertThrows(OutOfBoundsException.class, () -> testIntList.get(-3));
        Assertions.assertThrows(OutOfBoundsException.class, () -> testIntList.get(6));
    }
    @Test
    public void testTestEquals() {
        Assertions.assertEquals(true, testIntList.equals(createTestIntList()));
        Assertions.assertEquals(false, testIntList.equals(new IntListImpl(4)));
    }
    @Test
    public void testSize() {
        Assertions.assertEquals(3,testIntList.size());
    }
    @Test
    public void testIsEmpty() {
        Assertions.assertEquals(false,testIntList.isEmpty());
        Assertions.assertEquals(true,new StringListImpl(5).isEmpty());
    }
    @Test
    public void testClear() {
        testIntList.clear();
        Assertions.assertEquals(true,testIntList.isEmpty());
    }

    @Test
    public void testSortInsertion() {
        IntList tSL2 = new IntListImpl(4);
        tSL2.add(5);
        tSL2.add(1);
        tSL2.add(10);
        tSL2.add(7);
        tSL2.sortInsertion();
        Assertions.assertEquals(1,tSL2.get(0));
        Assertions.assertEquals(5,tSL2.get(1));
        Assertions.assertEquals(7,tSL2.get(2));
        Assertions.assertEquals(10,tSL2.get(3));
    }

}