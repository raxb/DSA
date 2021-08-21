package com.dsa;

public class ArrayQueue<E> implements Queue<E> {
    private static final int capacity = 1000;
    private final E[] data;
    private int indexPointer = 0;
    private int elts = 0;

    public ArrayQueue() {
        this(capacity);
    }

    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        Queue<String> arrayQueue = new ArrayQueue<>(10);
        System.out.println("Size " + arrayQueue.size());
        System.out.println("Empty " + arrayQueue.isEmpty());
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        arrayQueue.enqueue("E");
        System.out.println("Size " + arrayQueue.size());
        System.out.println("Empty " + arrayQueue.isEmpty());
        System.out.println("First " + arrayQueue.first());
        System.out.println("De-queueing " + arrayQueue.dequeue());
        System.out.println("De-queueing " + arrayQueue.dequeue());
        System.out.println("First " + arrayQueue.first());
        System.out.println("Size " + arrayQueue.size());
        System.out.println("Empty " + arrayQueue.isEmpty());
    }

    @Override
    public int size() {
        return elts;
    }

    @Override
    public boolean isEmpty() {
        return elts == 0;
    }

    @Override
    public void enqueue(E e) {
        if (elts == data.length) throw new IllegalStateException("Full");
        int avail = (indexPointer + elts) % data.length;//position after tail
        data[avail] = e;
        elts++;
    }

    @Override
    public E dequeue() {
        if (elts == 0)
            return null;
        E removal = data[indexPointer];
        data[indexPointer] = null;
        indexPointer = (indexPointer + 1) % data.length;//next position after head
        elts--;
        return removal;
    }

    @Override
    public E first() {
        if (elts == 0)
            return null;
        return data[indexPointer];
    }
}
