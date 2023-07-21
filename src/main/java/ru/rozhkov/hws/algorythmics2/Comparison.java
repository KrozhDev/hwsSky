package ru.rozhkov.hws.algorythmics2;

public class Comparison {
    public static void main(String[] args) {

        long start;

        final int numOfElements = 100_000;

        ArrayGenerator arrayGenerator = new ArrayGenerator(numOfElements);

        SortService sortService = new SortService();

        int[] array1 = arrayGenerator.generateRandomArray();
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();

        start = System.currentTimeMillis();
        sortService.sortSelection(array1);
        System.out.println("Сортировка выбором");
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println("Сортировка пузырьком");
        sortService.sortBubble(array2);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println("Сортировка вставкой");
        sortService.sortInsertion(array3);
        System.out.println(System.currentTimeMillis() - start);
    }
}
