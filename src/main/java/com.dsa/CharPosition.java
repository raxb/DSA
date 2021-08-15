package com.dsa;

public class CharPosition {
    private final char aChar;
    private final int position;

    public CharPosition(char aChar, int position) {
        this.aChar = aChar;
        this.position = position;
    }

    public char getaChar() {
        return aChar;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "CharPosition{" +
                "aChar=" + aChar +
                ", position=" + position +
                '}';
    }
}
