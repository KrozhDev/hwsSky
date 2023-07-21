package ru.rozhkov.hws.algorythmics2;

public class ArrayGenerator {

    private int numOfElements;
    public ArrayGenerator(int numOfElements) {
        this.numOfElements = numOfElements;
    }

    public int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[numOfElements];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
