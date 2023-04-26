package com.yxb.ch14.s2_create;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import java.nio.file.*;

/**
 * 可以用这个玩意做啥呢？
 */

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);

    RandomWords(String fname) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 外层循环提取行
        for (String line : lines.subList(1, lines.size())) {
            // 内层循环提取word
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        // Stream.generate 可以接受任意的值
        System.out.println(
                Stream.generate(new RandomWords("Cheese.dat")).limit(10).collect(Collectors.joining(" "))
        );
    }

}