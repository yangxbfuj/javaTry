package com.ch13;

public class FunctionInterfaceTest {
    @FunctionalInterface
    interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = FunctionInterfaceTest::f;
        tf = (i, l, d) -> 12;
    }
}
