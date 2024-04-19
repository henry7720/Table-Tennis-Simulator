import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * {@code Player} represented as a set of integer values and a boolean
 * describing score, roundNumber, wins, and game inProgress.
 *
 * @convention Any given round's score (0 <= score <= 11) may never exceed 11
 *             except when players are tied, in which case the winner must win
 *             by 2.
 * @convention Round number starts at 0, but must be 1 <= round <= 5 (best of
 *             5). Wins cannot be negative. inProgress is true for a game that's
 *             started and false for a game ended.
 * @correspondence [this.score is directly interpreted as the scores for each
 *                 round, where the indices correspond to the round number minus
 *                 one]
 * @correspondence [this.wins is directly interpreted as the current count of
 *                 wins this Player has achieved]
 * @correspondence [this.roundNumber is directly interpreted as the current
 *                 count of how many rounds in a set of 5]
 * @author H. Trowbridge
 */
public class Player1 extends PlayerSecondary {
    /*
     * Private members --------------------------------------------------------
     */

    /** The list of up to 5 rounds of game scores. */
    private int[] score;
    /** The current round number. */
    private int roundNumber;
    /** The total number of wins. */
    private int wins;
    /** Game in progress or not. */
    private boolean inProgress;

    /*
     * Standard methods -------------------------------------------------------
     */

    /** Create initial representation of the data in our four variables. */
    private void createNewRep() {
        this.score = new int[5];
        this.roundNumber = 0;
        this.wins = 0;
        this.inProgress = false;
    }

    /**
     * No-argument constructor.
     */
    public Player1() {
        this.createNewRep();
    }

    @Override
    public final Player newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Player source) {
        Player1 localSource = (Player1) source;

        this.score = localSource.score;
        this.roundNumber = localSource.roundNumber;
        this.wins = localSource.wins;
        this.inProgress = localSource.inProgress;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public boolean inProgress() {
        return this.inProgress;
    }

    @Override
    public void startGame() {
        this.inProgress = true;
    }

    @Override
    public void endGame() {
        this.inProgress = false;
    }

    @Override
    public int getScore(int round) {
        return this.score[round - 1];
    }

    @Override
    public int[] getScoreArr() {
        return this.score;
    }

    @Override
    public void setScore(int round, int content) {
        this.score[round - 1] = content;
    }

    @Override
    public int getRoundNumber() {
        return this.roundNumber;
    }

    @Override
    public int getWins() {
        return this.wins;
    }

    @Override
    public void setWins(int changed) {
        this.wins = changed;
    }

    @Override
    public void setRound(int changed) {
        this.roundNumber = changed;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter fileOut = null;

        System.out.println(
                "Before we start, please provide the path of where we will report on "
                        + "the status of our 'Players' :D");
        String fileName = in.nextLine();

        try {
            fileOut = new PrintWriter(
                    new BufferedWriter(new FileWriter(fileName)));
        } catch (IOException e) {
            System.err.println(
                    "File could not be opened. Please check the path.");
        }

        System.out.println("New round started for each player :)...");
        Player one = new Player1();
        Player two = new Player1();

        System.out.println("Let's simulate game 1 between the two. Started!");
        one.startGame();
        two.startGame();

        one.simulateGame(two);

        one.endGame();
        two.endGame();

        int gameCount = 1;
        String input;

        while (gameCount < 5) {
            System.out.println(
                    "Would you like to simulate another? Type 'y or n'");
            input = in.nextLine();
            if (input.toLowerCase().trim().equals("y") && one.getWins() < 3
                    && two.getWins() < 3) {
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

        one.updateClientView(fileOut, two);
        fileOut.close();
        System.out.println("Best of 5 is over!");
    }
}
