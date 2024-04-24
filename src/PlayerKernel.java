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
     * @requires this.inProgress = false
     * @ensures [inProgress = true, to represent starting game]
     */
    void startGame();

    /**
     * End game (one round only).
     *
     * @requires this.inProgress = true
     * @ensures [inProgress = false, to represent ending game; this.score = 0]
     */
    void endGame();

    /**
     * Returns the player's current score.
     *
     * @param round
     *            return the score from the round's number
     * @requires this.roundNumber >= round
     * @ensures [getScore() = this current round's score]
     * @return the last current score number
     */
    int getScore(int round);

    /**
     * Returns the entire score array.
     *
     * @ensures [getScoreArr() = list of scores]
     * @return the last current score number
     */
    int[] getScoreArr();

    /**
     * Sets the player's current score.
     *
     * @param round
     *            which round number's scores are updated
     * @param content
     *            new score to place
     * @requires content >= 0 and round >= 1
     * @ensures [score for round = content]
     */
    void setScore(int round, int content);

    /**
     * Returns the player's current score.
     *
     * @requires 1 < roundNumber <= 5
     * @ensures [getRound() = roundNumber]
     * @return the current round number
     */
    int getRound();

    /**
     * Returns the player's total wins.
     *
     * @requires 0 < totalWins
     * @ensures [getWins() = totalWins]
     * @return the current number of wins
     */
    int getWins();

    /**
     * Updates the player's current wins.
     *
     * @param changed
     *            the new wins value
     * @requires 0 < totalWins <= 5
     * @ensures [this.wins = changed]
     */
    void setWins(int changed);

    /**
     * Sets a new round number.
     *
     * @param changed
     *            is the new round number
     * @requires 1 < changed <= 5 and changed > roundNumber
     * @ensures [roundNumber = changed]
     */
    void setRound(int changed);
}
