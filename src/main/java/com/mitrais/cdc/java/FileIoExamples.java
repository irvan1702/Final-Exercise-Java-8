package com.mitrais.cdc.java;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

import java.io.PrintWriter;

public class FileIoExamples {
	private String words;
	public static List<String> testWords = Arrays.asList("foo", "bar", "baz12345678", "boo1234567");

	public static boolean findAFile(String fileName) throws Exception {
		boolean check = false;
		if(Files.exists(Paths.get("./"+fileName))){
			System.out.println("File is found");
			check=true;
		}
		else{
			System.out.println("File is not found");
			check=false;
		}
		return check;
	}
	
	public static boolean removeFile(String inputFile) throws Exception {
		boolean check = false;
		if(Files.deleteIfExists(Paths.get("./"+inputFile))){
			System.out.println("File is deleted");
			check=true;
		}
		else{
			System.out.println("File is not deleted");
			check=false;
		}
		return check;
	}
	
	public static String createEmptyFile(String inputFile) throws Exception {
		Files.createFile(Paths.get("./"+inputFile));
		System.out.println("File Created");
		return "File Created";
	}
	
	public static String writeFilesFromAnotherFilesWithUppercase(String inputFile, String outputFile) throws Exception {
		List<String> result = Files.lines(Paths.get("./"+inputFile)).map(s->s.toUpperCase()).distinct().collect(Collectors.toList());
		createEmptyFile(outputFile);
		Files.write(Paths.get("./"+outputFile), result);
		System.out.println("File " + outputFile+ " has been writed");
		return "success";
	}
	
	private FileIoExamples() {
	} // Uninstantiatable class
}
