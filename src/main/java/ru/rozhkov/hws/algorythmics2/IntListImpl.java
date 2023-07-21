package ru.rozhkov.hws.algorythmics2;

import ru.rozhkov.hws.algorythmics2.IntList;
import ru.rozhkov.hws.algorythmics2.exceptions.NoElementException;
import ru.rozhkov.hws.algorythmics2.exceptions.OutOfBoundsException;

import java.util.Arrays;

public class IntListImpl implements IntList {

    private int size;

    private Integer[] array;

    public IntListImpl(int size) {
        this.size = size;
        array = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = item;
                return item;
            }
            if (i == array.length - 1) {
                size += 1;
                Integer[] newArray = new Integer[size];
                for (int j = 0; j < array.length; j++) {
                    newArray[j] = array[j];
                }
                newArray[array.length] = item;
                array = newArray;
                return item;
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= array.length) {
            throw new OutOfBoundsException();
        } else {
            size += 1;
            Integer[] newArray = new Integer[size];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = item;
            for (int i = index + 1; i < array.length; i++) {
                newArray[i] = array[i-1];
            }
            array = newArray;
        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (index >= array.length) {
            throw new OutOfBoundsException();
        } else {
            Integer[] newArray = new Integer[size];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = item;
            for (int i = index + 1; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        Integer[] newArray = new Integer[size];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                index = i;
                break;
            }
            if (i == array.length - 1) {
                throw new NoElementException();
            }
        }
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            newArray[i-1] = array[i];
        }
        array = newArray;
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index >= array.length) {
            throw new OutOfBoundsException();
        }
        Integer removedElem = array[index];
        Integer[] newArray = new Integer[size];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        array = newArray;
        return removedElem;
    }

//    @Override
//    public boolean contains(Integer item) {
//        for (int i = 0; i < array.length; i++) {
//            if (item.equals(array[i])) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean contains(Integer item) {
        this.sortInsertion();
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == array[mid]) {
                return true;
            }

            if (item < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public Integer indexOf(Integer item) {
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        for (Integer i = array.length - 1; i > -1; i--) {
            if (item == array[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= array.length || index < 0) {
            throw new OutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (this.size() != otherList.size()) {
            return false;
        }
        Integer[] otherArray = otherList.toArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && !(array[i] == otherArray[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Integer size() {
        Integer counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                return counter;
            } else {
                counter++;
            }

        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    @Override
    public void sortInsertion() {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}
