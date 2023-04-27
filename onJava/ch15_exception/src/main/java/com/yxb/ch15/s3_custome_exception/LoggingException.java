package com.yxb.ch15.s3_custome_exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger(LoggingException.class.getSimpleName());

    LoggingException() {
        StringWriter trace = new StringWriter();
        // 将错误栈信息按照 PrintWriter 的方式写入了 trace 中
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
