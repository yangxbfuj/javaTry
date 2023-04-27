package com.yxb.ch14.s5_terminal.reduce;

import java.util.Random;

public class Frobnitz {
    int size;

    Frobnitz(int sz) {
        this.size = sz;
    }

    @Override
    public String toString() {
        return String.format("Frobnitz(%d)", this.size);
    }

    static Random rand = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}
