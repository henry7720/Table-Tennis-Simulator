import components.simplewriter.SimpleWriter;

/**
 * {@code NaturalNumberKernel} enhanced with secondary methods.
 */
public interface Player extends PlayerKernel {

    /**
     * Adds a point to the score of a player.
     *
     * @requires score <= 10, except when the two players already tied
     * @ensures [current score += 1]
     */
    void addPoint();

    /**
     * Sets up a new game round.
     *
     * @requires round umber <= 4
     */
    void nextRound();

    /**
     * Determines the winner of the match of two players, then returns that
     * Player.
     *
     * @param one
     *            the first player
     * @param two
     *            the second player
     * @return boolean value, true for player one winning, false for player two
     * @requires both players are initialized and neither player has the same
     *           score as the other
     * @requires that this.inProgress = false
     * @ensures [determineWinner(Player one, Player two) = true for player one
     *          winning, false for player two winning]
     */
    boolean determineWinner(Player one, Player two);

    /**
     * Updates the primary index file being live-hosted.
     *
     * @param file
     *            the file to write to
     * @param one
     *            the player one whose attributes are to be displayed
     * @param two
     *            the player one whose attributes are to be displayed
     */
    void updateClientView(SimpleWriter file, Player one, Player two);
}