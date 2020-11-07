import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the CrodeExalted class w/ JUnit 4.
 *
 * Yes, it's a total pain writing unit tests for a class hierarchy. There are
 * better ways than what I'm doing here, but those are beyond the scope of this
 * course.
 *
 * @author Mithat Konar
 */
public class CrodeExaltedTest {

    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorValidParams() {
        CrodeExalted tv;

        tv = new CrodeExalted("Dease", 1944, 81);
        assertEquals("Dease", tv.getName());
        assertEquals(81, tv.getPava());
        assertEquals(1944, tv.getBirthYear());

        tv = new CrodeExalted("Dease", 1946, 100);
        assertEquals("Dease", tv.getName());
        assertEquals(100, tv.getPava());
        assertEquals(1946, tv.getBirthYear());

        tv = new CrodeExalted("Dease", 1962, 1010101);
        assertEquals("Dease", tv.getName());
        assertEquals(1010101, tv.getPava());
        assertEquals(1962, tv.getBirthYear());
    }

    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorInValidParams() {
        CrodeExalted tv;
        String msg = "?";

        try {
            tv = new CrodeExalted("Dease", 1944, 80);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        assertEquals("invalid pava amount", msg);

        try {
            tv = new CrodeExalted("Dease", 1943, 81);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        assertEquals("invalid year", msg);
    }

    @Test
    public void testInheritance() {
        var tv = new CrodeExalted("Dease", 1982, 81);
        boolean b = tv instanceof Crode;
        assertEquals(true, b);
    }

    @Test
    public void testToString() {
        var tv = new CrodeExalted("Dease", 1982, 81);

        assertEquals("Dease born in 1982 is an Exalted Crode with 81 pava.", tv.toString());
    }

    @Test
    public void testSetName() {
        var tv = new CrodeExalted("Dease", 1982, 81);

        tv.setName("");
        assertEquals("Dease", tv.getName());

        tv.setName("T");
        assertEquals("T", tv.getName());

        tv.setName("D");
        assertEquals("D", tv.getName());

        tv.setName("Trelling");
        assertEquals("Trelling", tv.getName());

        tv.setName("Dint");
        assertEquals("Dint", tv.getName());

        tv.setName("tranque");
        assertEquals("Dint", tv.getName());

        tv.setName("demary");
        assertEquals("Dint", tv.getName());

        tv.setName("Hint");
        assertEquals("Dint", tv.getName());
    }

    @Test
    public void testSetYear() {
        var tv = new CrodeExalted("Dease", 1982, 81);

        tv.setBirthYear(-2000);
        assertEquals(-2000, tv.getBirthYear());

        tv.setBirthYear(0);
        assertEquals(0, tv.getBirthYear());

        tv.setBirthYear(2000);
        assertEquals(2000, tv.getBirthYear());

        String msg = "?";
        try {
            tv.setBirthYear(2001);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        assertEquals("invalid year", msg);
    }

    @Test
    public void testReceivePava() {
        var tv = new CrodeExalted("Dease", 1998, 100);

        boolean rv = tv.receivePava(-2001);
        assertEquals(100, tv.getPava());
        assertEquals(rv, false);

        rv = tv.receivePava(-1);
        assertEquals(100, tv.getPava());
        assertEquals(rv, false);

        rv = tv.receivePava(0);
        assertEquals(100, tv.getPava());
        assertEquals(rv, true);

        rv = tv.receivePava(1);
        assertEquals(101, tv.getPava());
        assertEquals(rv, true);

        rv = tv.receivePava(10);
        assertEquals(111, tv.getPava());
        assertEquals(rv, true);
    }

    @Test
    public void testSpendPava() {
        var tv = new CrodeExalted("Dease", 1998, 100);

        boolean rv = tv.spendPava(-2001);
        assertEquals(100, tv.getPava());
        assertEquals(rv, false);

        rv = tv.spendPava(-1);
        assertEquals(100, tv.getPava());
        assertEquals(rv, false);

        rv = tv.spendPava(0);
        assertEquals(100, tv.getPava());
        assertEquals(rv, true);

        rv = tv.spendPava(1);
        assertEquals(99, tv.getPava());
        assertEquals(rv, true);

        rv = tv.spendPava(10);
        assertEquals(89, tv.getPava());
        assertEquals(rv, true);
    }
}