package com.dsa;

public class CircularLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;

    public static void main(String[] args) {
        CircularLinkedList<String> cll = new CircularLinkedList<>();
        cll.addFirst("A");
        cll.addFirst("B");
        cll.addFirst("C");

        System.out.println(cll.size());
        System.out.println(cll.isEmpty());
        System.out.println(cll.first());
        System.out.println(cll.last());
        cll.rotate();
        System.out.println("After rotate");
        System.out.println(cll.first());
        System.out.println(cll.last());

        cll.addLast("Z");
        cll.rotate();
        System.out.println("After rotate 2");
        System.out.println(cll.first());
        System.out.println(cll.last());

        String removed = cll.removeFirst();
        System.out.println("Removed element " + removed + ", now the first element is " + cll.first());
        System.out.println("Last element is " + cll.last());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (size == 0) return null;
        return tail.getNext().getElement();
    }

    public E last() {
        if (size == 0) return null;
        return tail.getElement();
    }

    public void rotate() {
        /*
        in circular linked list tail's next is always the head,
        so in rotate moves the tail's pointer to the head,
        thereby head becomes tail and head's next becomes head
         */
        if (tail != null) tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<E>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    public E removeFirst() {
        if (size == 0) return null;
        //the next element after tail is the head which is first
        Node<E> removal = tail.getNext();
        if (removal == tail) tail = null;
            //get head's next and tail should point to that
        else tail.setNext(removal.getNext());
        //remove head
        //decrement size
        size--;
        return removal.getElement();
    }

    private static class Node<E> {
        private final E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> node) {
            next = node;
        }
    }
}
