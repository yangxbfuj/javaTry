package com.yxb.ch14.s2_create;

import java.util.stream.*;

public class Bubbles {
	public static void main(String[] args) {
		Stream.generate(Bubble::bubbler).limit(5).forEach(System.out::println);
	}
}