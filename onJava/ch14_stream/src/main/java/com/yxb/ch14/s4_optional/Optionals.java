package com.yxb.ch14.s4_optional;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Optionals {
    static void basics(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optString) {
        System.out.println(optString.orElseGet(() -> "Generated"));
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(() -> new Exception("Supplied")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.format(" === %s ==== %n", testName);
        cos.accept(Optional.of("Epithets"));
        cos.accept(Optional.<String>empty());
    }

    public static void main(String[] args) {
        test("basic", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
