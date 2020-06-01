// Robert McNive
// This will be a console based program to look up player data for the game League of Legends
// Integration Project for COP 2006 Summer A

// import java.io.IOException;
import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
// These are the classes needed to be able to use the code I wrote.
// Above this comment are the packages that are included within Java already
// Below this comment will be the packages I had to download.


public class Main {

  public static void main(String[] args) throws Exception {

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
      /*
       * I am only setting these variables at the moment as an example of what I will do when I get
       * the data I need for each player who plays the game.
       */
    }

    String apiKey = "RGAPI-13c71d44-1709-48d8-b3d6-46b23b178947";
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
    connectToTheURL.setRequestMethod("GET");
    connectToTheURL.connect();

    Scanner scanner2 = new Scanner(summonerv4API.openStream());
    String output = scanner2.nextLine();

    // JSONObject encryptedSmmonerID = output.get
    System.out.println(output);
    // System.out.println(output.substring(7,54));

  }

}
