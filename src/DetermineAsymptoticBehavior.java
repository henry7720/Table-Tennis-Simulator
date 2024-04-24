import java.util.Scanner;

/** Model the algorithm for generating wins. */
public class DetermineAsymptoticBehavior {

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int gameCount = 0;
        int countYes = 0;
        int countNo = 0;

        Random generator = new Random();
        while (gameCount < 100000) {
            boolean yesOrNo = generator.nextBoolean();
            if (yesOrNo) {
                countYes++;
            } else {
                countNo++;
            }
            gameCount++;
        }
        in.close();
        System.out.println("Best of 100001 is over!");

        double maxWins = Math.max(countYes, countNo);
        double mostLs = Math.min(countYes, countNo);
        System.out.println(
                "Asymptotically, we should hope to see a very small differential, since "
                        + "these players have equivalent skill and good days and bad days :).");
        System.out.println(
                "This gives the losing player a winning percentage of only: "
                        + (mostLs / gameCount) * 100 + "%");
        System.out.println("We can assume our winning player is: "
                + (1 - mostLs / gameCount) * 100 + "% better!");
    }
}
