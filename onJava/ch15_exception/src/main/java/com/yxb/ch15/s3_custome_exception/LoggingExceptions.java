package com.yxb.ch15.s3_custome_exception;

public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
//            System.err.println("Caught " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
//            System.err.println("Caught " + e);
        }
    }
}
