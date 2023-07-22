package ru.rozhkov.hws.algorythmics2.exceptions;

public class NoElementException extends RuntimeException {
    public NoElementException() {
        super();
        System.out.println("Такого элемента нет в массиве");
    }
}
