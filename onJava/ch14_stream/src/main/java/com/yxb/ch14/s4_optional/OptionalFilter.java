package com.yxb.ch14.s4_optional;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OptionalFilter {
    static String[] elements = {"Foo", "", "Bar", "Baz", "Bingo"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Predicate<String> pred) {
        System.out.format(" === %s ==== %n", descr);
        for (int i = 0; i < elements.length; i++) {
            // find 返回的就是 Optional
            // filter 将不合条件的 Optional 都转换为 Optional.empty
            System.out.println(testStream().skip(i).findFirst().filter(pred));
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("str != \"\"", str -> !Objects.equals(str, ""));
        test("str.length() == 3", str -> str.length() == 3);
        test("startWith(\"B\")", str -> str.startsWith("B"));
    }
}
