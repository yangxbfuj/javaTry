package com.yxb.ch14.s2_create;

import java.util.stream.*;

public class Duplicator {
  public static void main(String[] args) {
    // 这里起始编译器将lambda表达式转换成了suppiler
    Stream.generate(() -> "duplicate") .limit(3).forEach(System.out::println);
  }
}