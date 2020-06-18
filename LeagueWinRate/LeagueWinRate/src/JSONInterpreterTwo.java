// Robert McNiven

// This class is to parse the data from the second APi
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Robert McNiven
 *
 */
public class JSONInterpreterTwo {

  // Fields
  // There are more fields in this JSON file that I need to set.

  /**
   * The amount of wins the player has, long.
   * 
   */
  private long wins;

  /**
   * The amount of losses the player has, long.
   * 
   */
  private long losses;

  /**
   * The amount of league points the player has, long.
   * 
   */
  private long leaguePoints;

  /**
   * The tier the player is currently at.
   * 
   */
  private String tier;

  /**
   * The rank the player is currently at.
   * 
   */
  private String rank;

  // Constructors
  // Again, I needed a blank constructor to be able to create a JSONInterpreterTwo object outside of
  // a do-while loop.
  public JSONInterpreterTwo() {

  }

  // This is the main constructor that sets all the fields for the objects.

  /**
   * Method that parses the second set of data from the API.
   * 
   * @param jsonText The output from the API.
   * @throws ParseException Throws exception if an error is found while parsing.
   */
  public JSONInterpreterTwo(String jsonText) throws ParseException {
    // I am creating a new JSONParser object that I use to turn the data I need to parse into.
    JSONParser parse = new JSONParser();
    // I have to turn the parse object into a JSONArray because the data has 2 sets of values for
    // each key and I only need the set that has its key type "queueType" set to "RANKED_SOLO_5x5".
    // In the step below I am using the parameter as an argument for the parse() method that will
    // tell the program to treat this String of text as a JSON file with keys and values for those
    // keys.
    JSONArray jsonarr = (JSONArray) parse.parse(jsonText);
    /*
     * This is where I got confused because not all accounts have RANKED_SOLO_5x5 as their 0th
     * element, so I had to get the first element of the JSON array and check to see if it was the
     * correct one I needed, If it was then I continued to parse the data. If it was not I told the
     * program to grab the 1st element of the JSON array instead.
     */
    JSONObject jobj = (JSONObject) jsonarr.get(0);
    String queue = (String) jobj.get("queueType");

    // This is where I make sure the queue type is RANKED_SOLO_5x5, then set all of my fields.
    if (queue.equals("RANKED_SOLO_5x5")) {
      String tiers = (String) jobj.get("tier");
      tier = tiers;
      String ranks = (String) jobj.get("rank");
      rank = ranks;
      long wonGames = (long) jobj.get("wins");
      wins = wonGames;
      long lostGames = (long) jobj.get("losses");
      losses = lostGames;
      long totalLP = (long) jobj.get("leaguePoints");
      leaguePoints = totalLP;
    } else if (queue.equals("RANKED_FLEX_SR")) {
      jobj = (JSONObject) jsonarr.get(1);
      String tiers = (String) jobj.get("tier");
      tier = tiers;
      String ranks = (String) jobj.get("rank");
      rank = ranks;
      long wonGames = (long) jobj.get("wins");
      wins = wonGames;
      long lostGames = (long) jobj.get("losses");
      losses = lostGames;
      long totalLP = (long) jobj.get("leaguePoints");
      leaguePoints = totalLP;
    }
  }

  // Methods

  /**
   * Get the players tier.
   * 
   * @return The players in game tier
   */
  public String getTier() {
    return tier;
  }

  /**
   * Get the players rank.
   * 
   * @return The players in game rank.
   */
  public String getRank() {
    return rank;
  }

  /**
   * Get the players wins.
   * 
   * @return The amount of wins the player has.
   */
  public long getWins() {
    return wins;
  }

  /**
   * Get the players losses.
   * 
   * @return The amount of losses the player has.
   */
  public long getLosses() {
    return losses;
  }

  /**
   * Get the players league points.
   * 
   * @return The amount of league points the player has
   */
  public long getLP() {
    return leaguePoints;
  }

}
