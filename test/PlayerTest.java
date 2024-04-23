import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code Player} enhanced methods.
 *
 * @author H. Trowbridge
 */
public class PlayerTest {

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

        assertEquals(1, test1.getScore(3));
        assertEquals(test1.getScore(3), test2.getScore(3));

        assertEquals(true, test1.equals(test2));
    }
}
