package com.ch13.s5_advanced_function;

import java.util.function.Function;

public class ConsumeFunction {

	public static class One{
		@Override public String toString(){
			return "This is One";
		}
	}

	public static class Two{
		@Override public String toString(){
			return "This is Two";
		}	
	}

	static Two consume(Function<One,Two> one2Two){
		return one2Two.apply(new One());
	}

	public static void main(String[] args){
		Two two = consume(one -> new Two());
		System.out.println(two);
	}
}