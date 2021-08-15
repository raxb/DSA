package com.dsa;

public class DoublyLinkedList<E> {
    private Node<E> header = null;
    private Node<E> trailer = null;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    public static void main(String[] args) {
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();
        dll.addFirst("Apple");
        dll.addFirst("Blackberry");
        dll.addFirst("Cucumber");
        dll.addFirst("Duck");
        dll.addLast("Zzzzz");

        System.out.println(dll.size());
        System.out.println(dll.isEmpty());
        System.out.println(dll.first());
        System.out.println(dll.last());

        String removed = dll.removeFirst();
        System.out.println("Removing first element " + removed);
        System.out.println("Now the first element is " + dll.first());

        String lastRemoved = dll.removeLast();
        System.out.println("Removing last element " + lastRemoved);
        System.out.println("Now the last element is " + dll.last());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (size == 0) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if (size == 0) return null;
        return trailer.getPrevious().getElement();
    }

    public void addFirst(E e) {
        //create a new node with element, previous and next nodes with reference to header
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        //create a new node with element, previous and next nodes with reference to trailer
        addBetween(e, trailer.getPrevious(), trailer);
    }

    public E removeFirst() {
        if (size == 0) return null;
        return removeBetween(header.getNext());
    }

    public E removeLast() {
        if (size == 0) return null;
        return removeBetween(trailer.getPrevious());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        size++;
    }

    private E removeBetween(Node<E> node) {
        //update previous and next
        Node<E> predecessor = node.getPrevious();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrevious(predecessor);
        size--;
        return node.getElement();
    }

    private static class Node<E> {
        private final E element;
        private Node<E> previous;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            previous = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
