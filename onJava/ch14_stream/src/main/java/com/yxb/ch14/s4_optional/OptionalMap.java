package com.yxb.ch14.s4_optional;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalMap {

    static String[] elements = {"12", "", "23", "25"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, String> func) {
        System.out.format(" === %s ==== %n", descr);
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream().skip(i).findFirst().map(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> String.format("[%s]", s));
        test("Increment", s -> {
            try {
                return String.format("%d", Integer.parseInt(s) + 1);
            } catch (NumberFormatException e) {
                return s;
            }
        });
        test("Replace", s -> s.replace("2", "9"));
        test("Take last digit", s -> s.length() > 0 ? String.format("%c", s.charAt(s.length() - 1)) : s);
    }

}
