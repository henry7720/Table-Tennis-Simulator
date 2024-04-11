import components.standard.Standard;

/**
 * Player kernel component with primary methods.
 *
 * These are getters and setters so the following functionality in the Player
 * class may be satisfied.
 */
public interface PlayerKernel extends Standard<Player> {

    /**
     * Returns if the current game is in progress.
     *
     * @requires score >= 0
     * @ensures [inProgress = true if game is in progress, false if a game is
     *          completed]
     * @return whether game in progress
     */
    boolean inProgress();

    /**
     * Starts a game (one round only).
     *
     * @requires this is not inProgress
     * @ensures [inProgress = true, to represent starting game]
     */
    void startGame();

    /**
     * End game (one round only).
     *
     * @requires this is inProgress
     * @ensures [inProgress = false, to represent ending game]
     */
    void endGame();

    /**
     * Returns the player's current score.
     *
     * @requires score >= 0
     * @ensures [getScore() = score]
     * @return the last current score number
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
     * Returns the player's total wins.
     *
     * @requires 0 < totalWins <= 5
     * @ensures [getWins() = totalWins]
     * @return the current number of wins
     */
    int getWins();

    /**
     * Sets a new round number.
     *
     * @param changed
     *            is the new round number
     * @requires 0 < changed <= 5 and changed > roundNumber
     * @ensures [roundNumber = changed]
     */
    void setRound(int changed);
}
