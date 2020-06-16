// Robert McNiven
// This class is to find the win ratio of ones entire team if they choose to enter more than 1
// player it will default to this classes methods.
public class Player {
  // Fields
  private int winRatio;
  private String name;
  private int teamWinRatio;

  // Constructor
  public Player(JSONInterpreter j1, JSONInterpreterTwo j2) {

    name = j1.getName();
    long wins = j2.getWins();
    long losses = j2.getLosses();
    double win = (double) wins;
    double loss = (double) losses;
    winRatio = (int) (((win) / (win + loss)) * 100);

  }

  // Methods
  public void setTeamWinRatio(int twr) {
    teamWinRatio = twr;
  }

  public int getTeamWinRatio() {
    return teamWinRatio;
  }

  public int getWinRatio() {
    return winRatio;
  }

  public String getName() {
    return name;
  }

}
