package com.ch13;

class X {
    String f() {
        return "X:f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnbindFunctionTest {
    public static void main(String[] args) {
        // MakeString ms = X::f
        MakeString ms = new X()::f;
        TransformX sp = X::f;
//        TransformX sp = X::f;

    }
}
