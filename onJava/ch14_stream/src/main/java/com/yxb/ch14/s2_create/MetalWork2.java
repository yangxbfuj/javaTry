package com.yxb.ch14.s2_create;


import java.util.*;

public class MetalWork2 {
	public static void main(String[] args){
		int start = 3;
		int end = 6;
		Arrays.stream(new Integer[]{1,2,3,4,5}, start, end);
	}
}