package com.yxb.ch14.s2_create;

import java.util.function.*;

public class Bubble {
	
	public final int i;
	public Bubble(int n) { i = n; }

	@Override
	public String toString(){
		return String.format("Bubble(%d)",i);
	}

	private static int count = 0;
	public static Bubble bubbler(){
		return new Bubble(count++);
	}
}