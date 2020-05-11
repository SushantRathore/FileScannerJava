package com.company;

import java.util.Scanner;

public class Game {
    private  String movieToGuess;
    private  int pointsLost;
    private String wrongLetter;
    private  String rightletter;
    private  boolean gameWon;

    //Constructor initilizing MovieList
    public Game (String pathname)
    {
        MovieList movieList = new MovieList(pathname);
        movieToGuess = movieList.getRandomMovie().trim();
        pointsLost = 10;
        rightletter = "";
        wrongLetter = "";
        gameWon =false;
    }

    //method return title of movie
    public  String getMovieTitle()
    {
        return  movieToGuess;
    }

    /*
    method that replace all letter of movie title with underscore(_)
    if none letter have been correctly guessed
    and all the letter except the one which are guessed correctly
     */
    public  String getHiddenMovieTitle(){
        if (rightletter.equals("")) {
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + rightletter + "]]" , "_");
        }
    }
        //Method that return letter guessed taht are not in movie

    public String getWrongLetters() {
        return wrongLetter;
    }

    //Method that return that if the user is won or lose
    public boolean WonGame()
    {return  gameWon;}

    /*
    Method that return that the user has ran out of chances
    i.e. used more than 10 guesses  and declare lose
    otherwise there are not underscore left and user has won the game
    */
    public  boolean gameEnded()
    {
        if(pointsLost==0)
        {
            return  true;
        }
        if (!getHiddenMovieTitle().contains("_"))
        {
            gameWon = true;
            return true;
        }
        return  false;
}

private  String inputLetter() {
    System.out.println("Guess the letter");
    Scanner scanner = new Scanner(System.in);
    String letter = scanner.nextLine().toLowerCase();

    if (!letter.matches("[a-z]")) {
        System.out.println("This is not a letter.");
        return inputLetter();
    } else if (wrongLetter.contains(letter) || rightletter.contains(letter)) {
        System.out.println("You already guessed that letter.");
        return inputLetter();
    } else return letter;
}
    public void guessLetter()
    {
        String guessedLetter = inputLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter))
        {
            rightletter += guessedLetter + guessedLetter.toLowerCase();
        }
        else
        {
            pointsLost--;
            wrongLetter += " "+guessedLetter;
        }

    }
}

