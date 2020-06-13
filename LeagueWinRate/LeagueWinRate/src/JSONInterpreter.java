import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONInterpreter {

  // Fields
  private String id;
  private String name;
  private long level;


  // Constructor
  public JSONInterpreter(String JSONText) throws ParseException {
    JSONParser parse = new JSONParser();
    JSONObject jobj = (JSONObject) parse.parse(JSONText);
    String summonerID = (String) jobj.get("id");
    id = summonerID;
    String summonerName = (String) jobj.get("name");
    name = summonerName;
    long summonerLevel = (long) jobj.get("summonerLevel");
    level = summonerLevel;

  }

  // Methods
  public String getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public long getLevel() {
    return level;
  }

}
