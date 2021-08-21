package com.dsa;

public class CircularQueue<E> implements Queue<E> {

    InnerCircularLinkedList<E> cLL = new InnerCircularLinkedList<>();

    public static void main(String[] args) {
        CircularQueue<String> cQ = new CircularQueue<>();
        System.out.println("Size " + cQ.size());
        System.out.println("Empty? " + cQ.isEmpty());
        cQ.enqueue("A");
        cQ.enqueue("B");
        cQ.enqueue("C");
        cQ.enqueue("D");
        cQ.enqueue("E");
        System.out.println("Size " + cQ.size());
        System.out.println("Empty? " + cQ.isEmpty());
        System.out.println("First " + cQ.first());
        System.out.println("Last " + cQ.last());
        System.out.println("Dequeue " + cQ.dequeue());
        System.out.println("Dequeue " + cQ.dequeue());
        System.out.println("Size " + cQ.size());
        System.out.println("Empty? " + cQ.isEmpty());
        System.out.println("First " + cQ.first());
        System.out.println("Last " + cQ.last());
        System.out.println("Default rotated---");
        cQ.rotate();
        System.out.println("First " + cQ.first());
        System.out.println("Last " + cQ.last());
        System.out.println("Twice rotated---");
        cQ.rotate(2);
        System.out.println("First " + cQ.first());
        System.out.println("Last " + cQ.last());
        System.out.println("Enqueueing the Dequeued for rotate ");
        cQ.rotateQueue();
        System.out.println("First " + cQ.first());
        System.out.println("Last " + cQ.last());
    }

    @Override
    public int size() {
        return cLL.size();
    }

    @Override
    public boolean isEmpty() {
        return cLL.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        cLL.addLast(e);
    }

    @Override
    public E dequeue() {
        return cLL.removeFirst();
    }

    @Override
    public E first() {
        return cLL.first();
    }

    public void rotate() {
        rotate(1);
    }

    public void rotate(int times) {
        cLL.rotate(times);
    }

    public void rotateQueue() {
        enqueue(dequeue());
    }

    public E last() {
        return cLL.last();
    }

    public static class InnerCircularLinkedList<E> {
        private Node<E> tail = null;
        private int size = 0;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public E first() {
            if (size == 0)
                return null;
            return tail.getNext().getElement();
        }

        public E last() {
            if (size == 0)
                return null;
            return tail.getElement();
        }

        public void addLast(E e) {
            if (size == 0) {
                tail = new Node<>(e, null);
                tail.setNext(tail);
            } else {
                Node<E> newest = new Node<>(e, tail.getNext());
                tail.setNext(newest);
            }
            size++;
            tail = tail.getNext();
        }

        public void addFirst(E e) {
            if (size == 0) {
                tail = new Node<>(e, null);
                tail.setNext(tail);
            } else {
                Node<E> newest = new Node<>(e, tail.getNext());
                tail.setNext(newest);
            }
            size++;
        }

        public E removeFirst() {
            Node<E> removal = tail.getNext();
            if (removal == tail)
                tail = null;
            else {
                tail.setNext(removal.getNext());
            }
            size--;
            return removal.getElement();
        }

        public void rotate(int times) {
            for (int i = 0; i < times; i++)
                tail = tail.getNext();
        }

        public static class Node<E> {
            private Node<E> next;
            private final E element;

            public Node(E element, Node<E> next) {
                this.element = element;
                this.next = next;
            }

            public E getElement() {
                return element;
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
