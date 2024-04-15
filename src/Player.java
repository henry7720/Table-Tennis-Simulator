import components.simplewriter.SimpleWriter;

/**
 * {@code NaturalNumberKernel} enhanced with secondary methods.
 */
public interface Player extends PlayerKernel {

    /**
     * Adds a point for the round of the score of a player.
     *
     * @param round
     *            the round to add the score to
     * @requires score <= 10, except when the two players already tied
     * @ensures [score in the round += 1]
     */
    void addPoint(int round);

    /**
     * Sets up a new game round.
     *
     * @requires round number <= 4
     * @ensures round number ++
     */
    void nextRound();

    /**
     * Determines the winner of the match of two players, then returns that
     * Player.
     *
     * @param two
     *            the second player to compare to
     * @param round
     *            the round whose values need be compared
     * @return int value, 0 for player one winning, 1 for player two, -1 for
     *         neither
     * @requires both players are initialized and neither player has the same
     *           score as the other
     * @ensures [determineWinner(Player one, Player two) = true for player one
     *          winning, false for player two winning; sets inProgress to be
     *          false]
     */
    int determineWinner(Player two, int round);

    /**
     * Simulates a game (round) between two players.
     *
     * @param two
     *            the player two who will be fought!
     * @requires two exists
     * @ensures a game is simulated and appropriate fields of data are updates;
     *          scores, rounds, etc
     */
    void simulateGame(Player two);

    /**
     * Updates the primary index file being live-hosted.
     *
     * @param file
     *            the file to write to
     * @param two
     *            the player one whose attributes are to be displayed
     *            accompanying this
     * @requires file exists, Player two exists
     * @ensures data will be dumped to web page appropriately
     */
    void updateClientView(SimpleWriter file, Player two);
}
