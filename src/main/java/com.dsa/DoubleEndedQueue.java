package com.dsa;

public class DoubleEndedQueue<E> implements Deque<E> {

    InnerDoublyLinkedList<E> iDLL = new InnerDoublyLinkedList<>();

    public static void main(String[] args) {
        Deque<String> deque = new DoubleEndedQueue<>();
        System.out.println("Size " + deque.size());
        System.out.println("Empty? " + deque.isEmpty());
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.addLast("3");
        deque.addLast("2");
        deque.addLast("1");
        System.out.println("Size " + deque.size());
        System.out.println("Empty? " + deque.isEmpty());
        System.out.println("First " + deque.first());
        System.out.println("Last " + deque.last());
        System.out.println("Remove First " + deque.removeFirst());
        System.out.println("Remove Last " + deque.removeLast());
        System.out.println("Size " + deque.size());
        System.out.println("Empty? " + deque.isEmpty());
        System.out.println("First " + deque.first());
        System.out.println("Last " + deque.last());
    }

    @Override
    public int size() {
        return iDLL.size();
    }

    @Override
    public boolean isEmpty() {
        return iDLL.isEmpty();
    }

    @Override
    public E first() {
        return iDLL.first();
    }

    @Override
    public E last() {
        return iDLL.last();
    }

    @Override
    public void addFirst(E e) {
        iDLL.addFirst(e);
    }

    @Override
    public void addLast(E e) {
        iDLL.addLast(e);
    }

    @Override
    public E removeFirst() {
        return iDLL.removeFirst();
    }

    @Override
    public E removeLast() {
        return iDLL.removeLast();
    }

    public static class InnerDoublyLinkedList<E> {

        private Node<E> header = null;
        private Node<E> trailer = null;
        private int size = 0;

        public InnerDoublyLinkedList() {
            header = new Node<>(null, null, null);
            trailer = new Node<>(null, header, null);
            header.setNext(trailer);
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
            addBetween(e, header, header.getNext());
        }

        public void addLast(E e) {
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

        private void addBetween(E e, Node<E> previous, Node<E> next) {
            Node<E> newest = new Node<>(e, previous, next);
            previous.setNext(newest);
            next.setPrevious(newest);
            size++;
        }

        private E removeBetween(Node<E> node) {
            Node<E> pred = node.getPrevious();
            Node<E> suc = node.getNext();
            pred.setNext(suc);
            suc.setPrevious(pred);
            size--;
            return node.getElement();
        }

        public static class Node<E> {
            private Node<E> previous;
            private Node<E> next;
            private final E element;

            public Node(E element, Node<E> previous, Node<E> next) {
                this.element = element;
                this.previous = previous;
                this.next = next;
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
}
