package com.ch13.s5;

import java.util.function.Function;

/**
 * {@code @ClassName} AdvancedFunction
 * {@code @Description} TODO
 * {@code @Author} 杨学彬
 * {@code @Date} 2023/4/25 08:52
 */
public class ProduceFunction {
    interface FuncSS extends Function<String, String> {
    }

    /**
     * 已知返回类型，编译器能够获取 lambada 表达式对应的中变量对应的类型
     *
     * 这个函数就是高阶函数
     * 1、这个高阶函数，是把函数当作了返回值
     *
     * @return
     */
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
