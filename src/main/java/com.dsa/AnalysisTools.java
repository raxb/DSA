package com.dsa;

import java.util.Arrays;

public class AnalysisTools {

    public static double arrayMax(double[] data) {
        double max = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public static boolean unique1(int[] data) {
        //get the first elt and compare against each
        for (int i = 0; i < data.length - 1; i++) {//iterate upto n-1 elt only
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] == data[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sortedUnique() {
        int[] data = new int[]{3, 4, 1, 2, 5, 3, 12};
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                int temp = data[i];
                data[i] = data[i + 1];
                data[i + 1] = temp;
                for (int j = i; j > 0; j--) {
                    if (data[j - 1] > data[j]) {
                        int tempI = data[j];
                        data[j] = data[j - 1];
                        data[j - 1] = tempI;
                    }
                }
            }
        }
        System.out.println("Sorted Array " + Arrays.toString(data));
        for (int k = 0; k < data.length - 1; k++) {
            if (data[k] == data[k + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] prefixAverage() {
        int[] data = new int[]{1, 2, 3, 4, 5};
        int[] result = new int[data.length];
        int total = 0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
            result[i] = total / (i + 1);//ie.,i=3 then total = 10/(4)
        }
        return result;
    }

    public static int findIndex(int findValue) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        int j = 0;
        while (j < data.length) {
            if (data[j] == findValue)
                return j;
            j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        double[] testArrayMax = new double[]{1, 2, 8, 4, 5, 16};
        long before = System.currentTimeMillis();
        System.out.println(arrayMax(testArrayMax));
        System.out.println(System.currentTimeMillis() - before);

        int[] testArrayUnique = new int[]{1, 2, 8, 4, 5, 16, 4, 7};
        long before1 = System.currentTimeMillis();
        System.out.println(unique1(testArrayUnique));
        System.out.println(System.currentTimeMillis() - before1);

        System.out.println("The array is unique? " + sortedUnique());
        System.out.println("Prefix Average " + Arrays.toString(prefixAverage()));
        System.out.println("Find Elt index " + findIndex(4));
    }
}
