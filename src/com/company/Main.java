package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// program for using external file in java

       try {
           File file = new File("movies.txt");
           Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine())
        {
            System.out.println(scanner.nextLine());
        }}
       catch (FileNotFoundException exception)
       {
           System.out.println("Invalid file imported");
       }

    }
}
