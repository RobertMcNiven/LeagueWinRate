
public class ProjectRequirements {
  public ProjectRequirements() {
    // String testUsername = "notmalcolmtheking";
    // System.out.println(testMethod(testUsername));

    // System.out.println(testMethodForEquals(summonerName));
    // System.out.println(whoAreYou(summonerName));
    String summonerName = "";
    boolean checkIfCreator = whoAreYou(summonerName);
    while (checkIfCreator) {
      // System.out.println("Hello Robert!");
      checkIfCreator = false;
    }
    do {
      // System.out.println("Hello!");
      checkIfCreator = false;
    } while (checkIfCreator);
    /* This loop will always happen at least 1 time. */

  }

  public static boolean testMethodForEquals(String username) {
    /*
     * This is a method header with 1 parameter. A header contains usually public for a method,
     * static if it is a driver method, the type it is returning, it's name, and parameters in ().
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

  public static boolean whoAreYou(String username) {
    String myUsername = "malcolmtheking";
    if (username.equalsIgnoreCase(myUsername)) {
      return true;
    } else {
      return false;
    }
  }
}


