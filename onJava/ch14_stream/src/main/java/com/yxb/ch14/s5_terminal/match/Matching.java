package com.yxb.ch14.s5_terminal.match;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matching {

    static void show(BiPredicate<Stream<Integer>, Predicate<Integer>> matcher, int val) {
        System.out.println(
                matcher.test(IntStream.rangeClosed(1, 9).boxed(), n -> n < val)
        );
    }

    public static void main(String[] args) {
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 0);
    }
}
