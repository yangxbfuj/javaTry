package com.yxb.ch14.s3_middle_operate;

import java.util.Random;
import java.util.stream.*;

/**
 * flatMap 的参数是一个返回 Stream 的函数
 */
public class StreamOfStream {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .flatMap(s -> s)
                .peek(e -> System.out.println(e.getClass().getName()))
                .forEach(System.out::println);

        // 等同于
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .peek(e -> System.out.println(e.getClass().getName()))
                .forEach(System.out::println);

        Random rand = new Random(47);
        Stream.of(1, 2, 3, 4, 5).flatMapToInt(i -> IntStream.concat(
                rand.ints(0, 10).limit(i), IntStream.of(-1)
        )).forEach(n -> System.out.format("%d ", n));
    }
}
