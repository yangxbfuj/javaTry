package com.yxb.ch14.s5_terminal;

import java.util.*;
import java.util.stream.*;

import static com.yxb.ch14.s5_terminal.RandInts.*;

public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        rands().limit(SZ).forEach(n -> System.out.format("%d ", n));
        System.out.println();
        rands().limit(SZ).parallel().forEach(n -> System.out.format("%d ", n));
        System.out.println();
        rands().limit(SZ).parallel().forEachOrdered(n -> System.out.format("%d ", n));
    }
}
