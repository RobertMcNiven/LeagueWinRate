import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class is to parse the first set of data I get from the API.
 * 
 * @author Robert McNiven
 *
 */
public class JSONInterpreter {

  // Fields

  /**
   * The encrypted player ID, String because it contains numbers and characters.
   * 
   */
  private String id;

  /**
   * The players in game name.
   * 
   */
  private String name;

  /**
   * The players in game level.
   * 
   */
  private long level;

  // Constructor

  /**
   * I need a blank constructor so I can create an instance of the class outside of an if statement.
   */
  public JSONInterpreter() {

  }

  /**
   * This constructor is where the data from the first API is parsed.
   * 
   * @param jsonText A string that will be treated as a JSON file
   * @throws ParseException Throws exception if an error is found while parsing.
   */
  public JSONInterpreter(String jsonText) throws ParseException {
    // I am using the String of text I get from the website as the parameter.
    JSONParser parse = new JSONParser();
    // This creates a new JSONParser object. It allows me to later cast this object to s JSONObject.
    JSONObject jobj = (JSONObject) parse.parse(jsonText);
    // This is where I actually cast the JSONParser to a JSONObject and the parse() method takes the
    // string of text I provided and separates it into keys and their values. Key names are
    // container names that hold the data that they describe.

    // From here on I will be using the get() method to access the data associated with the key
    // name. I then set the data that I get to my fields.
    String summonerID = (String) jobj.get("id");
    id = summonerID;
    String summonerName = (String) jobj.get("name");
    name = summonerName;
    long summonerLevel = (long) jobj.get("summonerLevel");
    level = summonerLevel;

  }

  // Methods

  /**
   * Get the encrypted summoner ID.
   * 
   * @return the players encrypted ID
   */
  public String getID() {
    return id;
  }

  /**
   * Get the players in game name.
   * 
   * @return the players in game name
   */
  public String getName() {
    return name;
  }

  /**
   * Get the players in game level.
   * 
   * @return the players in game level
   */
  public long getLevel() {
    return level;
  }

}
