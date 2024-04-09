import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * {@code Player} represented as a set of integer values.
 *
 * @convention Score may never exceed 11 except when players are tied.
 * @convention Round number must be 1 <= round <= 5 (best of 5).
 * @correspondence [private members contain relevant data in appropriate date
 *                 types]
 * @author H. Trowbridge
 */
public class Player1 extends PlayerSecondary {
    /*
     * Private members --------------------------------------------------------
     */

    /** The last applicable game score. */
    private int score;
    /** The last applicable round number. */
    private int roundNumber;
    /** The total number of wins. */
    private int wins;
    /** Game in progress or not. */
    private boolean inProgress;

    /*
     * Standard methods -------------------------------------------------------
     */

    /** Create initial representation of the date in our four variables. */
    private void createNewRep() {
        this.score = 0;
        this.roundNumber = 1;
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
    public int getScore() {
        return this.score;
    }

    @Override
    public void setScore(int changed) {
        this.score = changed;
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
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        SimpleWriter fileOut;

        String fileName;
        out.println(
                "Before we start, please provide the path of where we will report on "
                        + "the status of our 'Players' :D");
        fileName = in.nextLine();
        fileOut = new SimpleWriter1L(fileName);

        out.println("Hey y'all. Let's play a game! Alright, starting now.");
        out.println("Starting new round for each player :)...");
        Player one = new Player1();
        Player two = new Player1();

        out.println("Let's simulate a game between the two.");

        String contents = in.nextLine();

        out.close();
        in.close();
        fileOut.close();
    }
}
