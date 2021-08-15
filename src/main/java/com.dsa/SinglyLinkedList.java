package com.dsa;

import java.util.Objects;

public class SinglyLinkedList<E> implements Cloneable {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        SinglyLinkedList<String> testList = new SinglyLinkedList<>();
        testList.addFirst("number1");
        testList.addFirst("number0");

        System.out.println(testList.size());
        System.out.println(testList.isEmpty());
        System.out.println(testList.first());
        System.out.println(testList.last());

        testList.addLast("number98");
        testList.addLast("number99");
        String removed = testList.removeFirst();
        System.out.println("Removed element " + removed + ", now the first element is " + testList.first());
        System.out.println("Last element is " + testList.last());

        System.out.println("--EQUALS && CLONE--");
        SinglyLinkedList<String> listA = new SinglyLinkedList<>();
        listA.addFirst("1");
        listA.addFirst("Two");
        listA.addLast("Three");

        SinglyLinkedList<String> listB = listA.clone();
        System.out.println("Cloned A and B are equal? " + listA.equals(listB));

        SinglyLinkedList<String> listB2 = new SinglyLinkedList<>();
        listB2.addFirst("1");
        listB2.addFirst("Two");
        listB2.addLast("Three");
        System.out.println("Cloned A and B2 are equal? " + listA.equals(listB2));

        SinglyLinkedList<String> listB3 = new SinglyLinkedList<>();
        listB3.addFirst("1");
        listB3.addFirst("Two");
        listB3.addLast("3");
        System.out.println("Cloned A and B3 are equal? " + listA.equals(listB3));
    }

    @Override
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> copy = new Node<>(walk.getElement(), null);
                otherTail.setNext(copy);
                otherTail = copy;
                walk = walk.getNext();
            }
        }
        return other;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        if (!(o instanceof SinglyLinkedList)) return false;
        SinglyLinkedList<?> that = (SinglyLinkedList<?>) o;
        if (size != that.size) return false;

        //compare the elements of the list
        Node walkA = head;
        Node walkB = that.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) return false;
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        //create node with e element and head as next element
        Node<E> newest = new Node<>(e, head);
        if (isEmpty()) tail = newest;
        //new nodes next should point to the head
        newest.setNext(head);
        //newest becomes the head
        head = newest;
        //increase the size
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        //get head
        E removal = head.getElement();
        //head.next becomes head
        head = head.getNext();
        //decrement size
        size--;
        if (isEmpty()) tail = null;
        //return removed element
        return removal;
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E e, Node<E> node) {
            element = e;
            next = node;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
}
