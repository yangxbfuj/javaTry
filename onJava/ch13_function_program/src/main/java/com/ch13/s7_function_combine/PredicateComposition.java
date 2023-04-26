package com.ch13.s7_function_combine;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PredicateComposition {
	static Predicate<String>
		p1 = s -> s.contains("bar"),
		p2 = s -> s.length() < 5,
		pt = p1.negate().and(p2),
		p3 = s -> s.contains("foo"),
		p4 = pt.or(p3);
	public static void main(String[] args){
		Stream.of("bar", "foobar", "foobaz", "fongopuckey")
			.filter(p4)
			.forEach(System.out::println);
	}
}