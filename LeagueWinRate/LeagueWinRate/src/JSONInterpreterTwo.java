import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONInterpreterTwo {

  private long wins;
  private long losses;
  private long leaguePoints;
  private String tier;
  private String rank;

  public JSONInterpreterTwo(String JSONText) throws ParseException {
    JSONParser parse = new JSONParser();
    JSONArray jsonarr = (JSONArray) parse.parse(JSONText);
    JSONObject jobj = (JSONObject) jsonarr.get(0);
    String queue = (String) jobj.get("queueType");

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

  public String getTier() {
    return tier;
  }

  public String getRank() {
    return rank;
  }

  public long getWins() {
    return wins;
  }

  public long getLosses() {
    return losses;
  }

  public long getLP() {
    return leaguePoints;
  }

}
