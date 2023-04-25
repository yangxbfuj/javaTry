package com.yxb.ch14.s2_create
import static java.util.stream.IntStream.*;

public class Repeat {
  public static void hi(){
    System.out.println("Hi!");
  }

  public static void repeat(int n, Runnable action) {
    range(0, n).forEach(i -> action.run());
  }

  public static void main(String[] args){
    repeat(3,() -> System.out.println("Looping!"));
    repeat(2,() -> Repeat::hi);
  }
}