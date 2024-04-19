import java.io.PrintWriter;

/**
 * {@code PlayerKernel} enhanced with secondary methods.
 */
public interface Player extends PlayerKernel {

    /**
     * Adds a point to the round's score of a player.
     *
     * @param round
     *            the round's score which to add the point
     * @requires score <= 10, except when the two players already tied
     * @ensures [score in the round += 1]
     */
    void addPoint(int round);

    /**
     * Sets up a new game round.
     *
     * @requires round number <= 4
     * @ensures [round number ++]
     */
    void nextRound();

    /**
     * Determines the winner of the match of two players for the given round.
     *
     * @param two
     *            the second player to compare to
     * @param round
     *            the round whose values need be compared
     * @return the integer value which represents the winning state
     * @requires round >= 1, Player this and two are initialized
     * @ensures [determineWinner(Player two) = int value: 0 for player one
     *          winning, 1 for player two, -1 for neither]
     */
    int determineWinner(Player two, int round);

    /**
     * Simulates a game (round) between two players.
     *
     * @param two
     *            the player two who will be fought!
     * @requires two is initialized
     * @ensures [a game is simulated and appropriate fields of data are updated
     *          in the representations; scores, rounds, etc]
     */
    void simulateGame(Player two);

    /**
     * Updates the primary index file being live-hosted.
     *
     * @param file
     *            the opened file to write to
     * @param two
     *            the player one whose attributes are to be displayed
     *            accompanying this
     * @requires file exists, Player two exists
     * @ensures [table output dumped to page, minimally three rows for best of
     *          5]
     */
    void updateClientView(PrintWriter file, Player two);
}
