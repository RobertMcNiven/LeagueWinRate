// Robert McNiven
// player it will default to this classes methods.

/**
 * This class is to find the win ratio of ones entire team if the user chooses to enter more than 1
 * name.
 * 
 * @author Robert McNiven
 *
 */
public class Player {
  // Fields

  /**
   * Win ratio. Obtained by dividing the total wins over the total amount of games played.
   * 
   */
  private int winRatio;

  /**
   * The players in game name.
   * 
   */
  private String name;

  /**
   * The teams win ratio. Obtained by adding up all the win ratios and dividing that by the amount
   * of players searched.
   * 
   */
  private int teamWinRatio;

  // Constructor

  /**
   * This constructor sets the name and winRatio fields.
   * 
   * @param j1 The data parsed from the first API.
   * @param j2 The data parsed from the second API.
   */
  public Player(JSONInterpreter j1, JSONInterpreterTwo j2) {

    name = j1.getName();
    long wins = j2.getWins();
    long losses = j2.getLosses();
    double win = (double) wins;
    double loss = (double) losses;
    winRatio = (int) (((win) / (win + loss)) * 100);

  }

  // Methods

  /**
   * Set the teams win ratio.
   * 
   * @param twr Set the team win ratio.
   */
  public void setTeamWinRatio(int twr) {
    teamWinRatio = twr;
  }

  /**
   * Get the teams win ratio.
   * 
   * @return The teams win ratio.
   */
  public int getTeamWinRatio() {
    return teamWinRatio;
  }

  /**
   * Get the individual players win ratio.
   * 
   * @return The individual players win ratio.
   */
  public int getWinRatio() {
    return winRatio;
  }

  /**
   * Get the individual players name.
   * 
   * @return The individual players name.
   */
  public String getName() {
    return name;
  }

}
