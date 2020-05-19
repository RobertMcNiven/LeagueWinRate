// Robert McNiven
// This will be a console based program to look up player data for the game League of Legends
// Integration Project for COP 2006 Summer A

import java.util.Scanner;


public class Main {

  public static void main(String[] args) {

    boolean start = true;
    /*
     * This is the first declared variable of the program. A variable is just a name for a space in
     * memory that holds a value. In this case it a a boolean named start assigned to the value of
     * true.
     */

    /*
     * Scope is basically where a certain variable can be used within a program. Sometimes it is
     * good to make the variable acceccable everywhere but most of the time it is good to limit it
     * somewhere
     */
    if (start) {

      String greeting = "Hello Summoner! Welcome to this player looker upper thing.";
      String explanation =
          "After reading this you will be asked to provide how many other summoners you would like "
              + "view.\nYou will then be prompeted to provide an in game Summoner ID for each.\nType "
              + "your in-game name to continue.";
      Scanner scanner = new Scanner(System.in);
      System.out.println(greeting);
      System.out.println(explanation);
      final String summonerName = scanner.nextLine();
      // final is a keyword that will not allow a variable to be changed later on in the program
      // I used it here because I want the user to only check their name once.
      System.out.println("How many players would you like to look up?");
      int amountOfPlayers = scanner.nextInt();


      int wins = 100;
      int totalGames = 200;
      double winRatio = wins / totalGames;
      /*
       * I am only setting these variables at the moment as an example of what I will do when I get
       * the data I need for each player who plays the game.
       */
    }

  }

}
