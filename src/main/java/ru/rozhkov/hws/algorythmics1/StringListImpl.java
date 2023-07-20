package ru.rozhkov.hws.algorythmics1;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private int size;

    private String[] array;

    public StringListImpl(int size) {
        this.size = size;
        array = new String[size];
    }

    @Override
    public String add(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = item;
            }
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index >= array.length) {
            throw new RuntimeException();
        } else {
            size += 1;
            String[] newArray = new String[size];
            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            newArray[index] = item;
            for (int i = index + 1; i < array.length; i++) {
                newArray[i + 1] = array[i];
            }
            array = newArray;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= array.length) {
            throw new RuntimeException();
        } else {
            String[] newArray = new String[size];
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
    public String remove(String item) {
        String[] newArray = new String[size];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                index = i;
            }
            if (i == array.length - 1) {
                throw new RuntimeException();
            }
        }
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index >= array.length) {
            throw new RuntimeException();
        }
        String removedElem = array[index];
        String[] newArray = new String[size];
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }
        for (int i = index + 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        return removedElem;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < array.length; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = array.length - 1; i > -1; i--) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= array.length || index < 0) {
            throw new RuntimeException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        int counter = 0;
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
    public String[] toArray() {
        String[] newArray = new String[size];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
