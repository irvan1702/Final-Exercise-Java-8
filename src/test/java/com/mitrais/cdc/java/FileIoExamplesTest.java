package com.mitrais.cdc.java;

import static org.junit.Assert.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

import com.mitrais.cdc.java.FileIoExamples;

public class FileIoExamplesTest {
	Scanner sc = new Scanner(System.in);
	// String inputFile = "enable1-word-list.txt";

	@Test
	public void nLetterWord() throws Exception {

		System.out.println("1. Find a file | 2. Remove file | 3. Create new file | 4. Copy content from another file");
		int counter = 0;
		while (counter < 4) {
			int input = sc.nextInt();
			if (input == 1) {
				System.out.println("Please insert file name with extention");
				assertEquals(FileIoExamples.findAFile(sc.next()), true);
				counter = input;
			} else if (input == 2) {
				System.out.println("Please insert file name with extention that you want to delete");
				assertEquals(FileIoExamples.removeFile(sc.next()), true);
				counter = input;
			} else if (input == 3) {
				System.out.println("Please insert file name to create");
				assertEquals(FileIoExamples.createEmptyFile(sc.next()), "File Created");
				counter = input;
			} else if (input == 4) {
				System.out.println("Please insert file name to getContentTo");
				String inputFile = sc.next();
				System.out.println("Please insert file name to for writed");
				String outputFile = sc.next();
				assertEquals(FileIoExamples.writeFilesFromAnotherFilesWithUppercase(inputFile, outputFile), "success");
				counter = input;
			} else {
				System.out.println("Exit The Application");
				counter = input;
			}
		}

	}
}
