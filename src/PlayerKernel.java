import components.standard.Standard;

/**
 * Player kernel component with primary methods.
 *
 */
public interface PlayerKernel extends Standard<Player> {

    /**
     * Returns the player's current score.
     *
     * @requires score >= 0
     * @ensures [getScore() = score] @ return
     * @return the current score number
     */
    int getScore();

    /**
     * Sets the player's current score.
     *
     * @param changed
     *            is the new score value
     * @requires changed >= 0 and changed > score
     * @ensures [score = changed]
     */
    void setScore(int changed);

    /**
     * Returns the player's current score.
     *
     * @requires 0 < roundNumber <= 5
     * @ensures [getRoundNumber() = roundNumber]
     * @return the current round number
     */
    int getRoundNumber();

    /**
     * Sets a new round number.
     *
     * @param changed
     *            is the new round number
     * @requires 0 < changed <= 5 and changed > roundNumber
     * @ensures [roundNumber = changed]
     */
    void setRound(int changed);

    // private final int getTotalWins() {
    //     return this.wins;
    // }
}
