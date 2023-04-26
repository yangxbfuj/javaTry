package com.ch13.s6_closure;

import java.util.function.IntSupplier;

public class Closure2 {
	
	IntSupplier makeFun(int x){
		int i = 0;
		// i++;	编译错误，本质上 x 与 i 是默认隐含了 final 关键字的，而且其赋值的依据是后面的lambada表达式对其的引用
		// x++; 编译错误，本质上 x 与 i 是默认隐含了 final 关键字的，而且其赋值的依据是后面的lambada表达式对其的引用
		// return () -> x + i++; 编译失败，因为函数操作了结束函数域中定义的变量
		// return () -> x++ + i++; 编译失败，因为函数操作了结束函数域中定义的变量
		// return () -> x++ + i++; 编译失败，因为函数操作了结束函数域中定义的变量
		return () -> x + i;
	}

	IntSupplier makeFun2(int x){
		int i = 0;
		i++;
		x++;
		int finalX = x;
		// final int finalX = x; 其实等同与这个形式，只是相当于编译器可以推断出值是final的
		int finalI = i;
		return () -> finalI + finalX;
	}

	IntSupplier makeFun3(int x){
		Integer i = 0;
		// i++; 无法编译
		return () -> x + i;
	}


	public static void main(String[] args){
		Closure2 c2 = new Closure2();
		IntSupplier f1 = c2.makeFun2(0);
		IntSupplier f2 = c2.makeFun2(0);
		IntSupplier f3 = c2.makeFun2(0);
		System.out.println(f1.getAsInt());
		System.out.println(f2.getAsInt());
		System.out.println(f3.getAsInt());
	}
}