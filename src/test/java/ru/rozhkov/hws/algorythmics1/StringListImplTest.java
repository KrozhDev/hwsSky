package ru.rozhkov.hws.algorythmics1;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.rozhkov.hws.algorythmics1.exceptions.NoElementException;
import ru.rozhkov.hws.algorythmics1.exceptions.OutOfBoundsException;

public class StringListImplTest extends TestCase {

    private StringList testStringList;

    @BeforeEach
    public void setUp() {
        testStringList = createTestStringList();
    }

    private StringList createTestStringList() {
        StringList tSL = new StringListImpl(4);
        tSL.add("John");
        tSL.add("Michael");
        tSL.add("Alex");
        return tSL;
    }


    @Test
    public void testAdd() {
        String expected = "Harry";
        String actual = testStringList.add("Harry");
        Assertions.assertEquals(expected, actual);
    }

    public void testTestAdd() {
        String expected = "Harry";
        String actual = testStringList.add(2,"Harry");
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected,testStringList.toArray()[2]);
        Assertions.assertEquals("Alex",testStringList.toArray()[3]);
        Assertions.assertThrows(OutOfBoundsException.class, () -> testStringList.add(6,"Paul"));

    }

    public void testSet() {
        String expected = "Harry";
        String actual = testStringList.set(1,"Harry");
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expected,testStringList.toArray()[1]);
        Assertions.assertEquals("Alex",testStringList.toArray()[2]);
        Assertions.assertThrows(OutOfBoundsException.class, () -> testStringList.set(5,"Paul"));

    }

    public void testRemove() {
        String expected = "Michael";
        String actual = testStringList.remove("Michael");
        Assertions.assertEquals(expected, actual);
        expected = "Alex";
        Assertions.assertEquals(expected,testStringList.toArray()[1]);
        Assertions.assertThrows(NoElementException.class, () -> testStringList.remove("Paul"));
    }

    public void testTestRemove() {
        String expected = "Michael";
        String actual = testStringList.remove(1);
        Assertions.assertEquals(expected, actual);
        expected = "Alex";
        Assertions.assertEquals(expected,testStringList.toArray()[1]);
        Assertions.assertThrows(OutOfBoundsException.class, () -> testStringList.remove(5));
    }


    public void testContains() {
        boolean expected = true;
        Assertions.assertEquals(expected, testStringList.contains("Michael") );
        expected = false;
        Assertions.assertEquals(expected, testStringList.contains("Paul") );
    }

    public void testIndexOf() {
        testStringList.add("Michael");
        int expected = 1;
        Assertions.assertEquals(expected, testStringList.indexOf("Michael") );
        expected = -1;
        Assertions.assertEquals(expected, testStringList.indexOf("Paul") );
    }

    public void testLastIndexOf() {
        testStringList.add("Michael");
        int expected = 3;
        Assertions.assertEquals(expected, testStringList.lastIndexOf("Michael") );
        expected = -1;
        Assertions.assertEquals(expected, testStringList.lastIndexOf("Paul") );
    }

    public void testGet() {
        Assertions.assertEquals("Michael",testStringList.get(1));
        Assertions.assertThrows(OutOfBoundsException.class, () -> testStringList.get(-3));
        Assertions.assertThrows(OutOfBoundsException.class, () -> testStringList.get(6));
    }

    public void testTestEquals() {
        Assertions.assertEquals(true, testStringList.equals(createTestStringList()));
        Assertions.assertEquals(false, testStringList.equals(new StringListImpl(4)));
    }

    public void testSize() {
        Assertions.assertEquals(3,testStringList.size());
    }

    public void testIsEmpty() {
        Assertions.assertEquals(false,testStringList.isEmpty());
        Assertions.assertEquals(true,new StringListImpl(5).isEmpty());
    }

    public void testClear() {
        testStringList.clear();
        Assertions.assertEquals(true,testStringList.isEmpty());
    }
}