package com.yxb.ch14.s3_middle_operate;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class FunctionMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, String> func) {
        System.out.printf("---(%s)---%n", descr);
        testStream().map(func).forEach(System.out::println);
    }

    public static void main(String[] args) {
        test("add brackets", s -> String.format("[%s]", s));

        test("Increment", s -> {
            try {
                return String.valueOf(Integer.parseInt(s) + 1);
            } catch (NumberFormatException e) {
                return e.getMessage();
            }
        });

        test("Replace", s -> s.replace("2", "9"));

        test("Take last digit", s -> s.length() > 0 ? String.valueOf(s.charAt(s.length() - 1)) : s);
    }
}
