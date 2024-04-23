import java.util.Scanner;

/** Generate percentages on skill differential. */
public class DetermineSkillDifferential {

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("New round started for each player :)...");
        Player one = new Player1();
        Player two = new Player1();

        int gameCount = 0;

        while (gameCount < 4) {
            if (one.getWins() < 3 && two.getWins() < 3) {
                one.startGame();
                two.startGame();

                one.simulateGame(two);

                one.endGame();
                two.endGame();
                gameCount++;
                System.out.println("Game (round) " + gameCount + " done!");
            } else {
                break;
            }
        }
        in.close();
        System.out.println("Best of 5 is over!");

        double maxWins = Math.max(one.getWins(), two.getWins());
        double mostLosses = Math.min(one.getWins(), two.getWins());

        System.out.println("Based on those results, our better player won "
                + (int) maxWins + " games , while our worse player won "
                + (int) mostLosses + " games");
        System.out.println(
                "This gives the losing player a winning percentage of only: "
                        + (mostLosses / gameCount) * 100 + "%");
        System.out.println("We can assume our winning player is: "
                + (1 - mostLosses / gameCount) * 100 + "% better!");
    }
}
