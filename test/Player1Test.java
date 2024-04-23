import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Player} constructor and kernel methods.
 *
 * @author H. Trowbridge
 */
public class Player1Test {

    /** Test constructor and default values with getters. */
    @Test
    public final void testNoArgConstructor() {
        Player test1 = new Player1();

        int[] defaultArr = new int[5];
        assertEquals(false, test1.inProgress());
        assertEquals(0, test1.getScore(1));
        assertEquals(0, test1.getRound());
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
        assertEquals(0, test1.getRound());
        assertEquals(0, test1.getWins());
    }

    /** Test clear with properties. */
    @Test
    public final void testClearProperties() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test1.addPoint(3);

        test1.clear();

        assertEquals(true, test1.equals(test2));
    }

    /** Test newInstance. */
    @Test
    public final void testNewInstance() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        test1 = test2.newInstance();

    }

    /** Test newInstance with properties. */
    @Test
    public final void testNewInstProperties() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test1.addPoint(3);

        test1 = test2.newInstance();
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

    /** Test transferFrom with properties. */
    @Test
    public final void testTransferFrom2() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.startGame();
        test2.startGame();

        test3.transferFrom(test1);

        assertEquals(test2, test3);
    }

    /** Test toString empty properties. */
    @Test
    public final void testToStringRoundNumbers() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.setRound(2);
        test2.setRound(2);
        test3.setRound(2);

        assertEquals(test1.toString(), test2.toString());

        assertEquals(true, test1.equals(test2));
        assertEquals(true, test1.equals(test3));
    }

    /** Test toString properties. */
    @Test
    public final void testToStringStartGame() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.startGame();
        test2.startGame();
        test3.startGame();

        assertEquals(test1.toString(), test2.toString());

        assertEquals(true, test1.equals(test2));
        assertEquals(true, test1.equals(test3));
    }

    /** Test toString empty properties. */
    @Test
    public final void testToStringDefault() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        assertEquals(
                "Wins Thus Far: 0, Current Round Number: 0, Current Score: 0",
                test1.toString());

        assertEquals(true, test1.equals(test2));
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

        assertEquals(false, test2.inProgress());
        assertEquals(true, test1.inProgress());
        test1.endGame();
        assertEquals(true, test1.equals(test2));
    }

    /** Test getScore from round 3 on empty players. */
    @Test
    public final void testGetScoreEmpty3() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        int score = test1.getScore(3);

        assertEquals(0, score);
        assertEquals(true, test1.equals(test2));
    }

    /** Test getScore from round 5 on empty players. */
    @Test
    public final void testGetScoreEmpty5() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        int score = test1.getScore(5);

        assertEquals(0, score);
        assertEquals(true, test1.equals(test2));
    }

    /** Test setScore for round 3 on empty players. */
    @Test
    public final void testSetScoreEmpty3() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setScore(3, 7);

        assertEquals(false, test1.getScore(3) == test2.getScore(3));
    }

    /** Test setScore for round 5 on empty players. */
    @Test
    public final void testSetScoreEmpty5() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setScore(5, 9);

        assertEquals(false, test1.getScore(5) == test2.getScore(5));
    }

    /** Test setScore for round 2 on empty players. */
    @Test
    public final void testSetScoreEmpty2() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setScore(2, 9);

        assertEquals(false, test1.getScore(2) == test2.getScore(2));
    }

    /** Test getWins on empty players. */
    @Test
    public final void testGetWins() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        int test1Wins = test1.getWins();

        assertEquals(true, test1.equals(test2));
        assertEquals(test1Wins, test2.getWins());
    }

    /** Test setWins on empty players. */
    @Test
    public final void testSetWins() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        int test1Wins = test1.getWins();

        assertEquals(true, test1.equals(test2));
        assertEquals(test1Wins, test2.getWins());
    }

    /** Test setWins on empty players. */
    @Test
    public final void testGetWinsAfterSet() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setWins(4);

        assertEquals(false, test1.equals(test2));
        assertEquals(false, test1.getWins() == test2.getWins());
    }

    /** Test getRound on empty. */
    @Test
    public final void testGetRoundEmpty() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        assertEquals(0, test1.getRound());
        assertEquals(test1, test2);
    }

    /** Test getRound started. */
    @Test
    public final void testGetRoundStarted() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();

        assertEquals(0, test1.getRound());
        assertEquals(false, test1.equals(test2));
    }

    /** Test getRound after set. */
    @Test
    public final void testGetRoundAfterSet() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setRound(4);

        assertEquals(4, test1.getRound());
        assertEquals(false, test1.equals(test2));
    }
}
