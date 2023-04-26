package com.ch13.s6_closure;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public class ClosureWithList {
	Supplier<List<Integer>> makeFunc() {
		final List<Integer> ai = new ArrayList<>();
		// 操作了 list
		ai.add(1);
		return () -> ai;
	}

	public static void main(String[] args){
		ClosureWithList cwl = new ClosureWithList();
		List<Integer> l1 = cwl.makeFunc().get();
		List<Integer> l2 = cwl.makeFunc().get();
		l1.add(42);
		l2.add(96);
		System.out.println(l1);
		System.out.println(l2);
	}
}