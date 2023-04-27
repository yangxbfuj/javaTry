package com.yxb.ch14.s4_optional;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Signal {
    private final String msg;

    public Signal(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return String.format("Signal(%s)", msg);
    }

    static Random rand = new Random(47);

    public static Signal morse() {
        return switch (rand.nextInt(4)) {
            case 1 -> new Signal("dot");
            case 2 -> new Signal("dash");
            default -> null;
        };
    }

    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse).map(Optional::ofNullable);
    }

    public static void main(String[] args) {
        Signal.stream().limit(10).forEach(System.out::println);
        System.out.println("------");
        // optional 只是给 filter 便利
        Signal.stream().limit(10).filter(Optional::isPresent).map(Optional::get).forEach(System.out::println);
        Signal.stream().limit(10).filter(Optional::isPresent).map(Optional::get).forEach(System.out::println);
    }
}
