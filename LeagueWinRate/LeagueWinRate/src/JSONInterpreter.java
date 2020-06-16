// Robert McNiven
// This class is to parse the first set of data I get from the API.
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONInterpreter {

  // Fields

  /*
   * From this data that I am parsing, I will need to obtain the encrypted summoner ID, the players
   * full in game name, and the players in game level
   */
  private String id;
  private String name;
  private long level;

  // Constructor
  // I need a blank constructor so I can create an instance of the class outside of an if statement.
  public JSONInterpreter() {

  }

  // This constructor is where I actually parse the data from the first API.
  public JSONInterpreter(String JSONText) throws ParseException {
    // I am using the String of text I get from the website as the parameter.
    JSONParser parse = new JSONParser();
    // This creates a new JSONParser object. It allows me to later cast this object to s JSONObject.
    JSONObject jobj = (JSONObject) parse.parse(JSONText);
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
  // Method to get the encrypted summoner ID
  public String getID() {
    return id;
  }

  // Method to get the players in game name.
  public String getName() {
    return name;
  }

  // Method to get the players in game level.
  public long getLevel() {
    return level;
  }

}
