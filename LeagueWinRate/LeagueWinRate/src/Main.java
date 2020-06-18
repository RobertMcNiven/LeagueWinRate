// Robert McNive
// This will be a console based program to look up player data for the game League of Legends
// Integration Project for COP 2006 Summer A

// import java.io.IOException;
import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// These are the classes needed to be able to use the code I wrote.
// Above this comment are the packages that are included within Java already

/**
 * This is the Main file to run in the program.
 * 
 * @author Robert McNiven
 *
 */
public class Main {

  /**
   * The main class for the process of looking up player data from Riot's public API.
   * 
   * @param args array of strings which stores arguments
   * @throws Exception Exception thrown because the program is accessing an HTTPURL that might fail.
   */
  public static void main(String[] args) throws Exception {
    /*
     * I needed to add the "throws Exception" because the connection to the URL might not be
     * established and cause an error that will cause the code to stop. The throws keyword declares
     * that there might be a "risky" method being called in the program and since there is more than
     * one I have to use "throws." I can also get around this by using a try and catch block but
     * this seemed easier and cleaner. It is meant to let the programmer know that a piece of code
     * in the project might not work or is accessing an outside source in this case.
     */
    boolean start = false;
    /*
     * This is the first declared variable of the program. A variable is just a name for a space in
     * memory that holds a value. In this case it a a boolean named start assigned to the value of
     * true.
     */

    /*
     * Scope is basically where a certain variable can be used within a program. Sometimes it is
     * good to make the variable accessible everywhere but most of the time it is good to limit it
     * somewhere
     */
    Scanner scanner = new Scanner(System.in);

    if (start) {

      String greeting = "Hello Summoner! Welcome to this player looker upper thing.";
      String explanation = "After reading this you will be asked to provide how many other "
          + "summoners you would like "
          + "view.\nYou will then be prompeted to provide an in game Summoner ID for each."
          + "\nType " + "your in-game name to continue.";

      System.out.println(greeting);
      System.out.println(explanation);
      final String summonerName = scanner.nextLine();
      // final is a keyword that will not allow a variable to be changed later on in the program
      // I used it here because I want the user to only check their name once.
      System.out.println("How many players would you like to look up?");
      int amountOfPlayers = scanner.nextInt();
      System.out.println(summonerName + amountOfPlayers);
      int wins = 100;
      int totalGames = 200;
      double winRatio = wins / totalGames;
      final String message = winRatio < .5 ? "dodge" : "play";
      System.out.println(message);
      /*
       * If the statement is true it will assign "dodge" to message, if it is false it will assign
       * "play" to message.
       */

      Random dodge = new Random();
      int num;
      for (int counter = 0; counter < 2; counter++) {
        num = 1 + dodge.nextInt(1);
        System.out.println(num);
      }
      /*
       * Precedence is key for setting up a program that contains math. It is basically what will
       * execute first based on operation. The most common way to get around precedence are ().
       */

    }
    /*
     * I am only setting these variables at the moment as an example of what I will do when I get
     * the data I need for each player who plays the game.
     */

    // This is where the goal of the project starts.

    System.out.println(
        "How many summoners would you like to compare?\n(Type 1 to look up an individual players "
            + "stats or type a number more than 1 to find the average win ratio of those players)");
    // This is the initial prompt that will ask what the user wants to do.
    int amountOfSummoners = 0;
    int amountOfSummonersCheck = amountOfSummoners;
    try {
      amountOfSummoners = scanner.nextInt();
      amountOfSummonersCheck = amountOfSummoners;
    } catch (Exception e) {
      System.out.println("Please input a whole number greater than 0.");
      System.exit(1);
    }
    String blankLine = scanner.nextLine();
    // I need this as a blank input to 'eat' the unseen characters that happen when inputing info.
    ArrayList<Player> teamStats = new ArrayList<Player>();
    // I initialized the arraylist that I will store all the Player objects in and find the average
    // winrates.
    // int amountOfSummonersCheck = amountOfSummoners;
    // I use this after the do-while loop to use methods on each individual player object.
    do {
      String apiKey = "APIKeyGoesHere";
      /*
       * This is the API key that allows me to access the data I need. It allows the developers to
       * know that it is my account accessing the information. This key will change by account. This
       * API key is renewed every 3 days in order to stop people from over accessing their servers
       * and reduce traffic
       */
      if (apiKey.equals("APIKeyGoesHere")) {
        System.out.println(
            "Please change the value of apiKey with your own API key, from https://developer."
                + "riotgames.com/ , to use the program");
        System.exit(1);
      }
      String region = "na1";
      /*
       * This is the region that I am using, North America. The game offers multiple regions but
       * since I only play on North America that is the one I will use.
       */
      String getSummonerNamePrompt = "Please enter the summoner name you would like to search";
      // This is the prompt that will be printed so the user knows what to do.
      System.out.println(getSummonerNamePrompt);
      // Will print out the value of getSummonerNamePrompt.
      String summonerName = scanner.nextLine();
      // This will grab the string the user enters and assigns it to the variable summonerName.

      String urlToApiOne = "https://" + region + ".api.riotgames.com/lol/summoner/v4/summoners/by-"
          + "name/" + summonerName + "?api_key=" + apiKey;
      /*
       * The API website has a specific pattern to its URL.In this instance the pattern is always
       * 'https://' then the region in which you are looking up
       * '.api.riotgames.com/lol/summoner/v4/summoners/by-name/' then the players name for which you
       * are searching '?api_key=' then the API key. This code concatenates all these components and
       * assigns them to urlToAPI
       */
      // System.out.println(urlToAPIOne);
      // Just a print statement to make sure there are no troubles with the API URL

      URL summonerv4Api = new URL(urlToApiOne);
      /*
       * This will be the first time I use the URL class. This will tell the program to create a
       * 'new' 'URL' object using the URL, in string format, provided as an argument. I then assign
       * this object to the summonerv4API variable because summonerv4 is the name of the first API I
       * will be accessing
       */

      HttpURLConnection connectToTheUrl = (HttpURLConnection) summonerv4Api.openConnection();
      /*
       * This is me casting the URL to an HttpURLConnection then using the openConnection method to
       * establish a connection to that URL. This allows me to make changes of get information from
       * the API.
       */
      connectToTheUrl.setRequestMethod("GET");
      /*
       * I am using the setRequestMethod from the HttpURLConnection class to tell it that I will be
       * receiving information rather than editing it or deleting it. It accepts 1 argument of one
       * of the following: GET POST HEAD OPTIONS PUT DELETE TRACE
       */
      int responseCode = connectToTheUrl.getResponseCode();
      /*
       * This method "getResponseCode" from the HttpURLConnection class returns the response code of
       * the web page the codes are as follows: 400 Bad request 401 Unauthorized 403 Forbidden 404
       * Data not found 405 Method not allowed 415 Unsupported media type 429 Rate limit exceeded
       * 500 Internal server error 502 Bad gateway 503 Service unavailable 504 Gateway timeout 200
       * if the connection is successful.
       */
      String responseCodeString = Integer.toString(responseCode);
      /*
       * This will convert the int response code to a String so I can use the equals method. I could
       * also use == to be able to determine if the connection to the URL was established but I feel
       * that the equals method is more elegant.
       */
      String encryptedSummonerID = "";
      // Initializing the summoner ID variable before the if statement
      String inGameName = "";
      // Initializing the in game name variable before the if statement
      long level = 0;
      // Initializing the level variable before the if statement
      JSONInterpreter summonerID = new JSONInterpreter();
      // Creating the jsoninterpreter object so I can use it outside of the if statement afterwards.
      if (responseCodeString.equals("200")) {
        // Checks to see if the pages response code is 200, which means everything worked.
        System.out.println("Response code: " + responseCodeString + "\nPermission granted.");
        Scanner scanner2 = new Scanner(summonerv4Api.openStream());
        String output = scanner2.nextLine();
        /*
         * This scanner is for receiving information from the API then assigning it to the variable
         * output as a String. I needed to create a new Scanner object because it is not user input
         * for this, it is information in JSON formatting. The openStream method is from the URL
         * class and "Opens a connection to this URL and returns an InputStream for reading from
         * that connection." In other words, it gets the JSON text from the specified URL and
         * converts it to a String.
         */

        // System.out.println(output);
        // This will print out the information from the API that was received.

        // JSONParser parse = new JSONParser();
        // JSONObject jobj = (JSONObject)parse.parse(output);
        // JSONArray jsonarr1 = (JSONArray) jobj.get("id");
        // System.out.println(jobj.get("id"));

        // Setting all of the fields in JSONInterpreter class.
        summonerID = new JSONInterpreter(output);
        encryptedSummonerID = summonerID.getID();
        inGameName = summonerID.getName();
        level = summonerID.getLevel();
        // System.out.println(encryptedSummonerID);

      } else {
        // Error message if the response code is not 200
        System.out.println("Something went wrong!");
        System.out.println("Response code: " + responseCodeString);
      }
      /*
       * This if-else statement makes it so that it will only access the API if the established
       * connection has a response code of "200" which means that the connection to the URL was
       * successful and I am allowed to view the information with my credentials.
       */
      switch (responseCodeString) {
        case "400":
          System.out.println("Bad request");
          break;
        case "401":
          System.out.println("Unauthorized");
          break;
        case "403":
          System.out.println("Forbidden");
          break;
        case "404":
          System.out.println("Data not found");
          break;
        case "405":
          System.out.println("Method not allowed");
          break;
        case "415":
          System.out.println("Unsupported media type");
          break;
        case "429":
          System.out.println("Rate limit exceeded");
          break;
        case "500":
          System.out.println("Internal server error");
          break;
        case "502":
          System.out.println("Bad gateway");
          break;
        case "503":
          System.out.println("Service unavailable");
          break;
        case "504":
          System.out.println("Gateway timeout");
          break;
        default:
          System.out.println("The error that occurred is not listed.");
          break;
      }
      /*
       * I added this switch statement for all the different possibilities that can occur while
       * looking up the API. All the codes besides 200 are here with a print statement as to what
       * went wrong. These codes come directly from the game developer website. When the code hits
       * the break keyword it immediately exits the code and jumps to the next block. On the other
       * hand, if I used continue, it would jump to a next iteration to check and see if that was
       * true
       */
      // System.out.println(output.substring(7,54));
      /*
       * This was my first attempt at obtaining the encrypted id but after searching multiple
       * accounts I realized that not all are the same length.
       */

      // System.out.println(encryptedSummonerID);
      // System.out.println("Name: " + inGameName);
      // System.out.println("Level: " + level);

      /*
       * This next part does the same as accessing the last API. It sets a url for the API, Casts it
       * to an HTTPURL, opens the stream and gets the data on the page
       */
      String urlToApiTwo = "https://" + region + ".api.riotgames.com/lol/league/v4/entries/by-"
          + "summoner/" + encryptedSummonerID + "?api_key=" + apiKey;

      URL leaguev4Api = new URL(urlToApiTwo);
      HttpURLConnection connectToTheUrlTwo = (HttpURLConnection) leaguev4Api.openConnection();
      connectToTheUrlTwo.setRequestMethod("GET");
      int responseCodeTwo = connectToTheUrlTwo.getResponseCode();
      String responseCodeStringTwo = Integer.toString(responseCodeTwo);

      // These are initializing all of the data so I can later use it outside of the if statement.
      String rank = "";
      String tier = "";
      long wins = 0;
      long losses = 0;
      long leaguePoints = 0;
      JSONInterpreterTwo ranked = new JSONInterpreterTwo();

      if (responseCodeStringTwo.equals("200")) {
        // System.out.println("Response code: " + responseCodeStringTwo + "\nPermission granted.");
        Scanner scanner3 = new Scanner(leaguev4Api.openStream());
        String output2 = scanner3.nextLine();
        /*
         * This scanner is for receiving information from the API then assigning it to the variable
         * output as a String. I needed to create a new Scanner object because it is not user input
         * for this, it is information in JSON formatting. The openStream method is from the URL
         * class and "Opens a connection to this URL and returns an InputStream for reading from
         * that connection." In other words, it gets the JSON text from the specified URL and
         * converts it to a String.
         */

        // System.out.println(output2);
        // This will print out the information from the API that was received.

        // Setting all the information gathered to my fields in JSONInterpreterTwo
        ranked = new JSONInterpreterTwo(output2);
        tier = ranked.getTier();
        rank = ranked.getRank();
        wins = ranked.getWins();
        losses = ranked.getLosses();
        leaguePoints = ranked.getLP();
      } else {
        System.out.println("Something went wrong!");
        System.out.println("Response code: " + responseCodeStringTwo);
      }
      switch (responseCodeStringTwo) {
        case "400":
          System.out.println("Bad request");
          break;
        case "401":
          System.out.println("Unauthorized");
          break;
        case "403":
          System.out.println("Forbidden");
          break;
        case "404":
          System.out.println("Data not found");
          break;
        case "405":
          System.out.println("Method not allowed");
          break;
        case "415":
          System.out.println("Unsupported media type");
          break;
        case "429":
          System.out.println("Rate limit exceeded");
          break;
        case "500":
          System.out.println("Internal server error");
          break;
        case "502":
          System.out.println("Bad gateway");
          break;
        case "503":
          System.out.println("Service unavailable");
          break;
        case "504":
          System.out.println("Gateway timeout");
          break;
        default:
          System.out.println("The error that occurred is not listed.");
          break;
      }

      /*
       * This if statement will check to see if the amount of summoners entered was 1, if it is it
       * will display all that users info, if not, it will display the average winrates of all the
       * players entered and then it will show the player with the lowest winrate.
       */
      if (amountOfSummonersCheck == 1 && responseCodeString.equals("200")) {
        System.out.println("Name: " + inGameName);
        System.out.println("Level: " + level);
        System.out.println(tier + " " + rank + " " + leaguePoints + " lp");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        double win = (double) wins;
        double loss = (double) losses;
        int winRatio = (int) (((win) / (win + loss)) * 100);
        System.out.println("Win Ratio: " + winRatio + "%");
      }

      Player summonerStats = new Player(summonerID, ranked);
      // System.out.println(summonerStats);

      teamStats.add(summonerStats);

      amountOfSummoners--;

    } while (amountOfSummoners != 0);
    // The code will always run once.

    // This next section will traverse the array list and get the teams average winrate and the
    // player with the lowest winrate.

    // Initializing all the variables before the for loop.
    int teamTotal = 0;
    int lowest = teamStats.get(0).getWinRatio();
    String nameLowest = teamStats.get(0).getName();
    // System.out.println(teamStats.get(0).getName());
    for (int i = 0; i < teamStats.size(); i++) {
      teamTotal += teamStats.get(i).getWinRatio();
      if (teamStats.get(i).getWinRatio() < lowest) {
        lowest = teamStats.get(i).getWinRatio();
        nameLowest = teamStats.get(i).getName();
      }
    }
    // Setting teamAverage to the total percent added over the amount of players searched.
    int teamAverage = teamTotal / teamStats.size();

    // Outputting the results.
    System.out.println("Average team win rate: " + teamAverage + "%");
    System.out.println("The player with the lowest win rate at " + lowest + "% is " + nameLowest);

    /*
     * Everything from here onwards will be the other project requirements that were asked of me
     * that I could not find a place for in the overall goal of the program
     */

    boolean startTwo = false;
    while (startTwo) {
      // String testUsername = "notmalcolmtheking";
      // System.out.println(testMethod(testUsername));

      // Data Types
      /*
       * There are 8 primitive data types as follows • byte - 8-bit integer. Range from -128 to 127
       * • short- 16-bit integer. Range from -32768 to 32767 • int - 32--bit integer. Range from
       * -2^31 to 2^31 - 1. • long - 64-bit integer. Range from -2^63 to 2^63 - 1. • float - single
       * precision 32-bit floating point. • double - double precision 64-bit floating point. •
       * boolean - true or false • char - 16-bit Unicode character There is also a String type that
       * is a collection of chars.
       */

      // Inheritance
      /*
       * Inheritance is when a class inherits fields, constructors, and methods from another class.
       * The class that is being inherited from is known as the parent or super class. The
       * inheriting class is known as the child class. All child or sub class. All subclasses can
       * only have one super class but a parent class can have as many child classes as it wants. It
       * is good for a class to inherit from another if it will use the same methods and more of the
       * superclass
       */
      // Polymorphism
      /*
       * Polymorphism is when a child class takes on the different 'attributes' of a parent class.
       * So an example of this is when a parent class method is used on a child class object.
       * However, subclasses can also define their own methods and fields that are specific to that
       * subclass and not the super class.
       */

      // Array Stuff

      // Declaring an Array and listing its values
      int[] listOfNumbers = {100005, 567, 2, (int) Math.PI, 4, 3456, 988, 12, 18, 5389};
      // Initializing lowest num for array.
      int lowestNumInArray = listOfNumbers[0];
      int accumulatorVariable = 0;

      for (int i = 0; i < listOfNumbers.length; i++) {
        if (listOfNumbers[i] < lowestNumInArray) {
          accumulatorVariable += listOfNumbers[i];
          lowestNumInArray = listOfNumbers[i];
        }
      }
      System.out.println(accumulatorVariable);
      int lowestNumberIndex = 0;
      for (int i = 0; i < listOfNumbers.length; i++) {
        if (lowestNumInArray == listOfNumbers[i]) {
          lowestNumberIndex = i;
        }
      }
      System.out.println(lowestNumberIndex);

      int[][] grid = {{1, 2, 3}, {1023, 31, 56}, {12, 34, 21}};
      System.out.println(grid[1][2]);

      scanner.close();
    }
  }
}

