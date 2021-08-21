package com.dsa;

public class Josephus {

    public static void main(String[] args) {
        String[] a1 = {"a", "b", "c", "d", "e", "f"};
        String[] a2 = {"g", "h", "i", "j", "k", "l"};
        String[] a3 = {"m", "r"};
        System.out.println("First Set Winner " + Josephus(buildQueue(a1), 3));
        System.out.println("Second Set Winner " + Josephus(buildQueue(a2), 10));
        System.out.println("Third Set Winner " + Josephus(buildQueue(a3), 7));
    }

    private static <E> E Josephus(CircularQueue<E> circularQueue, int k) {
        if (circularQueue.isEmpty())
            return null;
        while (circularQueue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                circularQueue.rotateQueue();
            }
            E e = circularQueue.dequeue();
            System.out.println(" " + e + " is out");
        }
        return circularQueue.dequeue();
    }

    private static CircularQueue<String> buildQueue(String[] data) {
        CircularQueue<String> cQ = new CircularQueue<>();
        for (int i = 0; i < data.length; i++) {
            cQ.enqueue(data[i]);
        }
        return cQ;
    }
}
