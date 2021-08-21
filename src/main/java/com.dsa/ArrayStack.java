package com.dsa;

public class ArrayStack<E> implements Stack<E> {
    private static final int capacity = 1000;
    private int t = -1;
    private final E[] data;

    public ArrayStack() {
        this(capacity);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new ArrayStack<>(10);
        //size
        System.out.println("Size " + stringStack.size());
        //empty
        System.out.println("Empty? " + stringStack.isEmpty());
        //push
        stringStack.push("Elt 1");
        stringStack.push("Elt 2");
        stringStack.push("Elt 3");
        stringStack.push("Elt 4");
        stringStack.push("Elt 5");
        //size
        System.out.println("Size " + stringStack.size());
        //empty
        System.out.println("Empty? " + stringStack.isEmpty());
        //top
        System.out.println("Top of stack " + stringStack.top());
        //pop
        System.out.println("Popped from stack " + stringStack.pop());
        System.out.println("Popped from stack " + stringStack.pop());
        //size
        System.out.println("Size " + stringStack.size());
        //empty
        System.out.println("Empty? " + stringStack.isEmpty());
        //top
        System.out.println("Top of stack " + stringStack.top());
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public E top() {
        if (t == -1)
            return null;
        return data[t];
    }

    @Override
    public void push(E e) {
        if (size() == data.length) throw new IllegalStateException("Full");
        data[++t] = e;
    }

    @Override
    public E pop() {
        if (t == -1)
            return null;
        E e = data[t];
        t--;
        return e;
    }
}
