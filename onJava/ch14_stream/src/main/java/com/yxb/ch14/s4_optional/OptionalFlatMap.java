package com.yxb.ch14.s4_optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Optional.flatMap 是为程序员自己生成 Optional 结果设计的
 */
public class OptionalFlatMap {

    static String[] elements = {"12", "", "23", "25"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, Optional<String>> func) {
        System.out.format(" === %s ==== %n", descr);
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream().skip(i).findFirst().flatMap(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> Optional.of(String.format("[%s]", s)));
        test("Increment", s -> {
            try {
                return Optional.of(String.format("%d", Integer.parseInt(s) + 1));
            } catch (NumberFormatException e) {
                return Optional.of(s);
            }
        });
        test("Replace", s -> Optional.of(s.replace("2", "9")));
        test("Take last digit", s -> Optional.of(s.length() > 0 ? String.format("%c", s.charAt(s.length() - 1)) : s));
    }

}
