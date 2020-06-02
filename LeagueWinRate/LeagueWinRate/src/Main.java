// Robert McNive
// This will be a console based program to look up player data for the game League of Legends
// Integration Project for COP 2006 Summer A

// import java.io.IOException;
import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Random;
// These are the classes needed to be able to use the code I wrote.
// Above this comment are the packages that are included within Java already
// Below this comment will be the packages I had to download.


public class Main {

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

      int wins = 100;
      int totalGames = 200;
      double winRatio = wins / totalGames;
      final String message = winRatio < .5 ? "dodge" : "play";
      /*
       * If the statement is true it will assign "dodge" to message, if it is false it will assign
       * "play" to message.
       */

      Random dodge = new Random();
      int num;
      for (int counter = 0; counter < 2; counter += 1) {
        num = 1 + dodge.nextInt(1);
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

    String apiKey = "RGAPI-a96bd243-d636-4918-a6df-1903cff1999d";
    /*
     * This is the API key that allows me to access the data I need. It allows the developers to
     * know that it is my account accessing the information. This key will change by account. This
     * API key is renewed every 3 days in order to stop people from over accessing their servers and
     * reduce traffic
     */
    String region = "na1";
    /*
     * This is the region that I am using, North America. The game offers multiple regions but since
     * I only play on North America that is the one I will use.
     */
    String getSummonerNamePrompt = "Please enter the summoner name you would like to search";
    // This is the prompt that will be printed so the user knows what to do.
    System.out.println(getSummonerNamePrompt);
    // Will print out the value of getSummonerNamePrompt.
    String summonerName = scanner.nextLine();
    // This will grab the string the user enters and assigns it to the variable summonerName.

    String urlToAPI = "https://" + region + ".api.riotgames.com/lol/summoner/v4/summoners/by-"
        + "name/" + summonerName + "?api_key=" + apiKey;
    /*
     * The API website has a specific pattern to its URL.In this instance the pattern is always
     * 'https://' then the region in which you are looking up
     * '.api.riotgames.com/lol/summoner/v4/summoners/by-name/' then the players name for which you
     * are searching '?api_key=' then the API key. This code concatenates all these components and
     * assigns them to urlToAPI
     */
    System.out.println(urlToAPI);
    // Just a print statement to make sure there are no troubles with the API URL

    URL summonerv4API = new URL(urlToAPI);
    /*
     * This will be the first time I use the URL class. This will tell the program to create a 'new'
     * 'URL' object using the URL, in string format, provided as an argument. I then assign this
     * object to the summonerv4API variable because summonerv4 is the name of the first API I will
     * be accessing
     */

    HttpURLConnection connectToTheURL = (HttpURLConnection) summonerv4API.openConnection();
    /*
     * This is me casting the URL to an HttpURLConnection then using the openConnection method to
     * establish a connection to that URL. This allows me to make changes of get information from
     * the API.
     */
    connectToTheURL.setRequestMethod("GET");
    /*
     * I am using the setRequestMethod from the HttpURLConnection class to tell it that I will be
     * receiving information rather than editing it or deleting it. It accepts 1 argument of one of
     * the following: GET POST HEAD OPTIONS PUT DELETE TRACE
     */
    int responseCode = connectToTheURL.getResponseCode();
    /*
     * This method "getResponseCode" from the HttpURLConnection class returns the response code of
     * the web page the codes are as follows: 400 Bad request 401 Unauthorized 403 Forbidden 404
     * Data not found 405 Method not allowed 415 Unsupported media type 429 Rate limit exceeded 500
     * Internal server error 502 Bad gateway 503 Service unavailable 504 Gateway timeout 200 if the
     * connection is successful.
     */
    String responseCodeString = Integer.toString(responseCode);
    /*
     * This will convert the int response code to a String so I can use the equals method. I could
     * also use == to be able to determine if the connection to the URL was established but I feel
     * that the equals method is more elegant.
     */
    if (responseCodeString.equals("200")) {
      System.out.println("Response code: " + responseCodeString + "\nPermission granted.");
      Scanner scanner2 = new Scanner(summonerv4API.openStream());
      String output = scanner2.nextLine();
      /*
       * This scanner is for receiving information from the API then assigning it to the variable
       * output as a String. I needed to create a new Scanner object because it is not user input
       * for this, it is information in JSON formatting. The openStream method is from the URL class
       * and
       * "Opens a connection to this URL and returns an InputStream for reading from that connection."
       * In other words, it gets the JSON text from the specified URL and converts it to a String.
       */

      System.out.println(output);
      // This will print out the information from the API that was received.
    } else {
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
    }
    /*
     * I added this switch statement for all the different possibilities that can occur while
     * looking up the API. All the codes besides 200 are here with a print statement as to what went
     * wrong. These codes come directly from the game developer website. When the code hits the
     * break keyword it immediately exits the code and jumps to the next block. On the other hand,
     * if I used continue, it would jump to a next iteration to check and see if that was true
     */
    // System.out.println(output.substring(7,54));
    /*
     * This was my first attempt at obtaining the encrypted id but after searching multiple accounts
     * I realized that not all are the same length.
     */
    // String testUsername = "notmalcolmtheking";
    // System.out.println(testMethod(testUsername));
    System.out.println(testMethod(summonerName));
    System.out.println(testMethodTwo(summonerName));
    boolean checkIfCreator = testMethodTwo(summonerName);
    while (checkIfCreator) {
      System.out.println("Hello Robert!");
      checkIfCreator = false;
    }
    do {
      System.out.println("Hello!");
      checkIfCreator = false;
    } while (checkIfCreator);
    /* This loop will always happen at least 1 time. */

  }


  public static boolean testMethod(String username) {
    /*
     * This is a method header with 1 parameter. A header contains usually public for a method,
     * static, the type it is returning, it's name, and parameters in ().
     */
    String myUsername = "malcolmtheking";
    if (username == myUsername) {
      return true;
    } else {
      return false;
    }
    /*
     * This will always return false since I am using the == way to check if the entered name is
     * malcolmtheking. The reason is because it is a different place in memory than the entered
     * name. If I use the compareTo() method or the equals() method it would return true.
     */

  }

  public static boolean testMethodTwo(String username) {
    String myUsername = "malcolmtheking";
    if (username.equalsIgnoreCase(myUsername)) {
      return true;
    } else {
      return false;
    }
  }
}
