package com.yxb.ch14.s2_create;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public class FileToWordsBuilder {
	Stream.Builder<String> builder = Stream.builder();
	public FileToWordsBuilder(String filePath) throws Exception{
		Files.lines(Paths.get(filePath))
			.skip(1)
			.forEach(line -> {
				for(String w : line.split("[ .?,]+"))
					builder.add(w);
			})
	}

	Stream<String> stream(){
		return builder.build();
	}

	public static void main(String[] args) throws Exception{
		new FileToWordsBuilder("Cheese.bat")
			.stream()
			.limit(7)
			.map(w -> " ")
			.forEach(System.out::println);
	}
}