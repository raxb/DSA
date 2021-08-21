package com.dsa;

public class LinkedQueue<E> implements Queue<E> {

    SinglyLinkedList<E> sLL = new SinglyLinkedList<>();

    public static void main(String[] args) {
        Queue<String> linkedQueue = new LinkedQueue<>();
        System.out.println("Size " + linkedQueue.size());
        System.out.println("Empty? " + linkedQueue.isEmpty());
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        linkedQueue.enqueue("E");
        System.out.println("Size " + linkedQueue.size());
        System.out.println("Empty? " + linkedQueue.isEmpty());
        System.out.println("First of Queue " + linkedQueue.first());
        System.out.println("Dequeue " + linkedQueue.dequeue());
        System.out.println("Dequeue " + linkedQueue.dequeue());
        System.out.println("First of Queue " + linkedQueue.first());
        System.out.println("Size " + linkedQueue.size());
        System.out.println("Empty? " + linkedQueue.isEmpty());
    }

    @Override
    public int size() {
        return sLL.size();
    }

    @Override
    public boolean isEmpty() {
        return sLL.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        sLL.addLast(e);
    }

    @Override
    public E dequeue() {
        return sLL.removeFirst();
    }

    @Override
    public E first() {
        return sLL.first();
    }
}
