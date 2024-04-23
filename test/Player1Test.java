import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code SortingMachine<String>}'s constructor and
 * kernel methods.
 *
 * @author R. Platt
 * @author H. Trowbridge
 */
public abstract class Player1Test {

    /** Test constructor and default values */
    @Test
    public final void testConstructor() {
        Player test1 = new Player1();

        int[] defaultArr = new int[5];
        assertEquals(false, test1.inProgress());
        assertEquals(0, test1.getScore(1));
        assertEquals(defaultArr, test1.getScoreArr());
        assertEquals(0, test1.getRoundNumber());
        assertEquals(0, test1.getWins());
    }

    /** Test clear. */
    @Test
    public final void testConstructorClear() {
        Player test1 = new Player1();
        test1.clear();

        int[] defaultArr = new int[5];
        assertEquals(false, test1.inProgress());
        assertEquals(0, test1.getScore(1));
        assertEquals(defaultArr, test1.getScoreArr());
        assertEquals(0, test1.getRoundNumber());
        assertEquals(0, test1.getWins());
    }

    /** Test clear. */
    @Test
    public final void testNewInstance() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        test1 = test2.newInstance();

        int[] defaultArr = new int[5];
        assertEquals(false, test1.inProgress());
        assertEquals(0, test1.getScore(1));
        assertEquals(defaultArr, test1.getScoreArr());
        assertEquals(0, test1.getRoundNumber());
        assertEquals(0, test1.getWins());
    }

    /** Test equals and constructor for empty players. */
    @Test
    public final void testEquals() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        assertEquals(true, test1.equals(test2));
    }

    /** Test equals after changing various properties. */
    @Test
    public final void testEqualsInProgress() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test2.startGame();

        assertEquals(true, test1.equals(test2));
    }

    /** Test equals after changing various properties. */
    @Test
    public final void testEqualsWithPoints() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test2.startGame();

        test1.addPoint(1);
        test2.addPoint(1);

        assertEquals(true, test1.equals(test2));
    }

    /** Test equals after changing various properties. */
    @Test
    public final void testEqualsContradiction() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test1.addPoint(1);

        assertEquals(false, test1.equals(test2));
    }

    /** Test transferFrom with properties. */
    @Test
    public final void testTransferFrom() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.startGame();
        test1.addPoint(1);

        test2.startGame();
        test2.addPoint(1);

        test3.transferFrom(test1);

        assertEquals(test2, test3);
    }

    /** Test inProgress on two empty players. */
    @Test
    public final void testInProgress() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        assertEquals(false, test1.inProgress());
        assertEquals(test1, test2);
    }

    /** Test startGame with inProgress. */
    @Test
    public final void testInProgressAfterStart() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();

        assertEquals(false, test2.inProgress());
        assertEquals(true, test1.inProgress());
        assertEquals(false, test1.equals(test2));
    }

    /** Test inProgress after starting and then ending a game. */
    @Test
    public final void testInProgressAfterEnd() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test1.endGame();

        assertEquals(false, test2.inProgress());
        assertEquals(true, test1.inProgress());
        assertEquals(false, test1.equals(test2));
    }

    /** Test getScore from round 1 on empty players. */
    @Test
    public final void testGetScoreEmpty() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.getScore(3);

        assertEquals(0, test1.getScore(3));
        assertEquals(test1, test2);
    }

}
