package com.dsa;

import java.util.Arrays;

public class Section1 {
    private static char[] charArray;
    private static CharPosition[] charPositions = new CharPosition[15];
    private static int numEntries = 0;

    public static void main(String[] args) {
        System.out.println("Working...");
        charArray = new char[]{'E', 'A', 'D', 'C', 'B', 'J', 'K', 'H', 'I', 'G', 'F'};
        for (int i = 1; i < charArray.length; i++) {
            char current = charArray[i];
            int j = i;
            while (j > 0 && charArray[j - 1] < current) {
                charArray[j] = charArray[j - 1];
                j--;
            }
            charArray[j] = current;
        }
        createdCharPositions();
        //KJIHGFEDCBA
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(charPositions));

        System.out.println("-----------------------------");
        CharPosition newCharPosition = new CharPosition('V', 11);
        add(newCharPosition);
        System.out.println(Arrays.toString(charPositions));

        System.out.println("-----------------------------");
        System.out.println(remove(10).getaChar());

        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(charPositions));
    }

    private static void createdCharPositions() {
        int rank = charPositions.length;
        for (int i = 0; i < charArray.length; i++) {
            charPositions[i] = new CharPosition(charArray[i], rank--);
            numEntries++;
        }
    }

    private static void add(CharPosition newCharPosition) {
        int position = newCharPosition.getPosition();
        if (numEntries < charPositions.length
                || position > charPositions[numEntries - 1].getPosition()) {
            if (numEntries < charPositions.length)
                numEntries++;
            int j = numEntries - 1;
            while (j > 0 && charPositions[j - 1].getPosition() < position) {
                charPositions[j] = charPositions[j - 1];
                j--;
            }
            charPositions[j] = newCharPosition;
        }
    }

    private static CharPosition remove(int i) {
        CharPosition removal = charPositions[i];
        for (int j = i; j < numEntries - 1; j++) {
            charPositions[j] = charPositions[j + 1];
        }
        charPositions[numEntries - 1] = null;
        numEntries--;
        return removal;
    }
}
