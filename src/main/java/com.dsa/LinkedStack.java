package com.dsa;

public class LinkedStack<E> implements Stack<E> {

    InnerSinglyLinkedList<E> iSLL = new InnerSinglyLinkedList<>();

    public static void main(String[] args) {
        Stack<String> linkedStack = new LinkedStack<>();
        System.out.println("Size " + linkedStack.size());
        System.out.println("Empty? " + linkedStack.isEmpty());
        linkedStack.push("Elt 1");
        linkedStack.push("Elt 2");
        linkedStack.push("Elt 3");
        linkedStack.push("Elt 4");
        linkedStack.push("Elt 5");
        System.out.println("Size " + linkedStack.size());
        System.out.println("Empty? " + linkedStack.isEmpty());
        System.out.println("Top of LinkedStack " + linkedStack.top());
        System.out.println("Pop from LinkedStack " + linkedStack.pop());
        System.out.println("Pop from LinkedStack " + linkedStack.pop());
        System.out.println("Top of LinkedStack " + linkedStack.top());
        System.out.println("Size " + linkedStack.size());
        System.out.println("Empty? " + linkedStack.isEmpty());
    }

    @Override
    public int size() {
        return iSLL.size();
    }

    @Override
    public boolean isEmpty() {
        return iSLL.isEmpty();
    }

    @Override
    public E top() {
        return iSLL.first();
    }

    @Override
    public void push(E e) {
        iSLL.addFirst(e);
    }

    @Override
    public E pop() {
        return iSLL.removeFirst();
    }

    public static class InnerSinglyLinkedList<E> {

        private Node<E> head = null;
        private final Node<E> tail = null;
        private int size = 0;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() {
            return head.getNode();
        }

        public void addFirst(E e) {
            Node<E> newest = new Node<>(e, head);
            newest.setNext(head);
            head = newest;
            size++;
        }

        public E removeFirst() {
            Node<E> removal = head;
            head = head.getNext();
            size--;
            return removal.getNode();
        }

        public static class Node<E> {
            private final E node;
            private Node<E> next;

            public Node(E node, Node<E> next) {
                this.node = node;
                this.next = next;
            }

            public Node<E> getNext() {
                return next;
            }

            public void setNext(Node<E> n) {
                next = n;
            }

            public E getNode() {
                return node;
            }
        }
    }
}
