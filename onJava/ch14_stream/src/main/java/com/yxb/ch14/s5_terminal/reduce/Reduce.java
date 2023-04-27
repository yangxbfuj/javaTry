package com.yxb.ch14.s5_terminal.reduce;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .reduce(new Min())
                .ifPresent(System.out::println);
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .reduce(new Max())
                .ifPresent(System.out::println);

        Stream.generate(Frobnitz::supply)
                .limit(10)
                .reduce(new Sum())
                .ifPresent(System.out::println);
    }

    public static class Min implements BinaryOperator<Frobnitz> {

        @Override
        public Frobnitz apply(Frobnitz frobnitz, Frobnitz frobnitz2) {
            return frobnitz.size < frobnitz2.size ? frobnitz : frobnitz2;
        }
    }

    public static class Max implements BinaryOperator<Frobnitz> {

        @Override
        public Frobnitz apply(Frobnitz frobnitz, Frobnitz frobnitz2) {
            return frobnitz.size > frobnitz2.size ? frobnitz : frobnitz2;
        }
    }

    public static class Sum implements BinaryOperator<Frobnitz> {

        @Override
        public Frobnitz apply(Frobnitz frobnitz, Frobnitz frobnitz2) {
            return new Frobnitz(frobnitz.size + frobnitz2.size);
        }
    }

    public static class Last implements BinaryOperator<Frobnitz> {

        @Override
        public Frobnitz apply(Frobnitz frobnitz, Frobnitz frobnitz2) {
            return frobnitz2;
        }
    }

    public static class First implements BinaryOperator<Frobnitz> {

        @Override
        public Frobnitz apply(Frobnitz frobnitz, Frobnitz frobnitz2) {
            return frobnitz;
        }
    }
}
