package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // code for importing external file in java program
        File file = new File("movies.txt");
        Scanner scanner =new Scanner(file);

        //check whether file has more data in it
        while (scanner.hasNextLine())
        {
            String movie = scanner.nextLine();
            System.out.println(movie);
        }

    }
}
