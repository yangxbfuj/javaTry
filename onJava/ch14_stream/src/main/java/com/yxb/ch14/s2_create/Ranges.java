package com.yxb.ch14.s2_create;

import static java.util.stream.IntStream.range;

public class Ranges {
    public static void main(String[] args) {
        // 传统方式：
        int result = 0;
        for (int i = 10; i < 20; i++) result += i;
        System.out.println(result);

        // for-in搭配一个区间范围：
        result = 0;
        for (int i : range(10, 20).toArray()) result += i;
        System.out.println(result);

        // 使用流：
        System.out.println(range(10, 20).sum());
    }
}