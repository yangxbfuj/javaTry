package com.yxb.ch14.s5_terminal;

public class Pair {
    public final Character c;
    public final Integer i;

    Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }

    public Character getC() {
        return this.c;
    }

    public Integer getI() {
        return this.i;
    }

    @Override
    public String toString() {
        return String.format("Pair(%c,%d)", c, i);
    }

}
