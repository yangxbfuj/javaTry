package com.yxb.ch14.s4_optional;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalsFromEmptyStream {

    public static void main(String[] args) {
        System.out.println(Stream.<String>empty().findFirst());
        System.out.println(Stream.<String>empty().findAny());
        System.out.println(Stream.<String>empty().max(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty().min(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty().reduce((s1, s2) -> s1 + s2));
        System.out.println(IntStream.empty().average());
    }

    public static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }
}
