package com.yxb.ch14.s3_middle_operate;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.regex.Pattern;

public class FileToWorld {
    public static Stream<String> stream(String filePath) throws Exception {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .flatMap(line -> Pattern.compile("[\\W+]").splitAsStream(line));
    }
}
