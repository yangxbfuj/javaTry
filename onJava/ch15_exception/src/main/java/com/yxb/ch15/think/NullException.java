package com.yxb.ch15.think;

public class NullException {

    public static void demo() throws Exception{
        throw new Exception();
    }

    public static void main(String[] args) {
        try {
            demo();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
