package com.dsa;

import java.io.File;
import java.util.Arrays;

public class Recursions {

    public static double factorial(double value) {
        if (value == 0)
            return 1;
        return value * factorial(value - 1);
    }

    public static void drawRuler(int nInches, int majorLength) {
        drawLine(majorLength, 0);
        for (int j = 1; j <= nInches; j++) {
            drawInterval(majorLength - 1);
            drawLine(majorLength, j);
        }
    }

    private static void drawInterval(int centralLength) {
        if (centralLength >= 1) {
            drawInterval(centralLength - 1);
            drawLine(centralLength);
            drawInterval(centralLength - 1);
        }
    }

    private static void drawLine(int tickLength, int tickLabel) {
        for (int i = 0; i < tickLength; i++)
            System.out.print("-");
        if (tickLabel >= 0)//for numeric after the single line
            System.out.print(" " + tickLabel);
        System.out.print("\n");
    }

    private static void drawLine(int tickLength) {
        //line with no label
        drawLine(tickLength, -1);
    }

    public static boolean binarySearch(int target) {
        int[] data = new int[]{2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37};
        return binarySearch(data, target, 0, data.length);
    }

    private static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return false;
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return true;
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1);
            else
                return binarySearch(data, target, mid + 1, high);
        }
    }

    public static long diskUsage(File root) {
        long total = root.length();
        if (root.isDirectory()) {
            for (String childFiles : root.list()) {
                File child = new File(root, childFiles);
                total += diskUsage(child);
            }
        }
        System.out.println(total + "\t" + root);
        return total;
    }

    public static int linearSum(int sumUnto) {
        int[] data = new int[]{4, 3, 6, 2, 8, 9, 3, 2, 8, 5, 1, 7, 2, 8, 3, 7};
        if (sumUnto == 0)
            return 0;
        return linearSum(sumUnto - 1) + data[sumUnto - 1];
    }

    public static int[] reverseArray(int[] data, int low, int high) {
        if (low < high) {
            int temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            reverseArray(data, low + 1, high - 1);
        }
        return data;
    }

    public static double power(double base, int raised) {
        if (raised == 0)
            return 1;
        return base * power(base, raised - 1);
    }

    public static double power2(double base, int raised) {
        if (raised == 0)
            return 1;
        else {
            double partial = power2(base, raised / 2);
            double result = partial * partial;
            if (raised % 2 == 1)
                result *= base;
            return result;
        }
    }

    public static double binarySum(int[] data, int low, int high) {
        if (low > high)
            return 0;
        else if (low == high)
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public static long[] fibonacci(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacci(n - 1);//(n-1) & (n-2)
            long[] answer = {temp[0] + temp[1], temp[0]};//n & n-1
            System.out.print(answer[1] + "\n");
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorial-->" + factorial(5));
        drawRuler(3, 2);
        System.out.println("Search in array and is present? " + binarySearch(1));
        System.out.println("Search in array and is present? " + binarySearch(33));
        diskUsage(new File("C:\\Program Files\\Java"));
        System.out.println("Linear summing " + linearSum(3));

        int[] data = new int[]{4, 5, 6, 2, 7, 8, 9, 5};
        System.out.println(Arrays.toString(reverseArray(data, 0, data.length - 1)));

        System.out.println("Power of 2 to 3 is " + power(2, 3));

        System.out.println("Power2 of 2 to 3 is " + power2(2, 3));

        int[] data2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySum(data2, 0, data2.length - 1));

        System.out.println(Arrays.toString(fibonacci(11)));
    }
}
