package ru.rozhkov.hws.algorythmics2.exceptions;

public class OutOfBoundsException extends RuntimeException {

    public OutOfBoundsException() {
        super();
        System.out.println("Индекс выходит за пределы диапазона массива");
    }
}
