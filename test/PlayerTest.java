import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Player} enhanced methods.
 *
 * @author H. Trowbridge
 */
public class PlayerTest {
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

    /** Test addPoint. */
    @Test
    public final void testAddPoint1() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.addPoint(1);

        test2.setScore(1, 1);
        assertEquals(1, test1.getScore(1));
        assertEquals(test1.getScore(1), test2.getScore(1));

        assertEquals(true, test1.equals(test2));
    }

    /** Test addPoint twice. */
    @Test
    public final void testAddPoint2() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.addPoint(1);
        test1.addPoint(1);

        test2.setScore(1, 2);
        assertEquals(2, test1.getScore(1));
        assertEquals(test1.getScore(1), test2.getScore(1));

        assertEquals(true, test1.equals(test2));
    }

    /** Test addPoint to round 3. */
    @Test
    public final void testAddPoint3() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.addPoint(3);

        test2.setScore(3, 1);
        assertEquals(1, test1.getScore(3));
        assertEquals(test1.getScore(3), test2.getScore(3));

        assertEquals(true, test1.equals(test2));
    }

    /** Test nextRound for empty players. */
    @Test
    public final void testNextRound() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.nextRound();
        test2.nextRound();

        assertEquals(1, test1.getRound());
        assertEquals(true, test1.equals(test2));
    }

    /** Test nextRound twice for empty players. */
    @Test
    public final void testNextRoundTwice() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.nextRound();
        test1.nextRound();
        test2.setRound(2);

        assertEquals(2, test1.getRound());
        assertEquals(test2.getRound(), test1.getRound());
        assertEquals(true, test1.equals(test2));
    }

    /** Test determineWinner twice for neither winning yet round 1. */
    @Test
    public final void testDetermineWinner1() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        int winner = test1.determineWinner(test2, 1);

        assertEquals(-1, winner);
        assertEquals(true, test1.equals(test2));
        assertEquals(true, test1.equals(test3));
        assertEquals(true, test2.equals(test3));
    }

    /** Test determineWinner twice for neither winning yet round 3. */
    @Test
    public final void testDetermineWinner3() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        int winner = test1.determineWinner(test2, 3);

        assertEquals(-1, winner);
        assertEquals(true, test1.equals(test2));
        assertEquals(true, test1.equals(test3));
        assertEquals(true, test2.equals(test3));
    }

    /** Test determineWinner for tied players round 5. */
    @Test
    public final void testDetermineWinnerTied5() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.setScore(5, 11);
        test2.setScore(5, 11);
        int winner = test1.determineWinner(test2, 5);

        assertEquals(-1, winner);
        assertEquals(true, test1.equals(test2));
        assertEquals(false, test1.equals(test3));
        assertEquals(false, test2.equals(test3));
    }

    /** Test determineWinner for one-up player round 5. */
    @Test
    public final void testDetermineWinnerUntied5() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.setScore(5, 12);
        test2.setScore(5, 11);
        int winner = test1.determineWinner(test2, 5);

        assertEquals(-1, winner);
        assertEquals(false, test1.equals(test2));
        assertEquals(false, test1.equals(test3));
        assertEquals(false, test2.equals(test3));
    }

    /** Test determineWinner for guaranteed winner round 5. */
    @Test
    public final void testDetermineWinnerGuaranteed5() {
        Player test1 = new Player1();
        Player test2 = new Player1();
        Player test3 = new Player1();

        test1.setScore(5, 13);
        test2.setScore(5, 11);
        int winner = test1.determineWinner(test2, 5);

        assertEquals(0, winner);
        assertEquals(false, test1.equals(test2));
        assertEquals(false, test1.equals(test3));
        assertEquals(false, test2.equals(test3));
    }

    /** Test hashCode. */
    @Test
    public final void testHashCode() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setRound(5);
        test1.setScore(5, 11);

        assertEquals(11, test1.hashCode());
    }

    /** Test hashCode. */
    @Test
    public final void testHashCode2() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setRound(3);
        test1.setScore(3, 9);

        assertEquals(9, test1.hashCode());
    }

    /** Test hashCode with unlikely int. */
    @Test
    public final void testHashCode3() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.setRound(4);
        test1.setScore(4, 77);

        assertEquals(77, test1.hashCode());
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

    /** Test simulate game. */
    @Test
    public final void testSimulateGame() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        test1.startGame();
        test2.startGame();

        test1.simulateGame(test2);

        test1.endGame();
        test2.endGame();

        int isWinner = test1.determineWinner(test2, 1);

        assertEquals(true, isWinner >= 0);
    }

    /** Test simulate games. */
    @Test
    public final void testSimulateGames() {
        Player test1 = new Player1();
        Player test2 = new Player1();

        int rounds = 5;
        for (int i = 0; i < rounds; i++) {
            test1.startGame();
            test2.startGame();

            test1.simulateGame(test2);

            test1.endGame();
            test2.endGame();
            int isWinner = test1.determineWinner(test2, i + 1);

            assertEquals(true, isWinner >= 0);
        }

    }
}
