import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Beele class w/ JUnit 4.
 *
 * Yes, it's a total pain writing unit tests for a class hierarchy. There are
 * better ways than what I'm doing here, but those are beyond the scope of this
 * course.
 * 
 * @author Mithat Konar
 */
public class BeeleTest {
    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorValidParams() {
        Beele tv;

        tv = new Beele("Dease", 1944, 21);
        assertEquals("Dease", tv.getName());
        assertEquals(21, tv.getPava());
        assertEquals(1944, tv.getBirthYear());

        tv = new Beele("Dease", 1944, 60);
        assertEquals("Dease", tv.getName());
        assertEquals(60, tv.getPava());
        assertEquals(1944, tv.getBirthYear());     
        
        tv = new Beele("Dease", 1944, 80);
        assertEquals("Dease", tv.getName());
        assertEquals(80, tv.getPava());
        assertEquals(1944, tv.getBirthYear());
    }

    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorInValidParams() {
        Beele tv;
        String msg = "";

        try {
            tv = new Beele("Dease", 1944, 20);
        } catch(Exception e) {
            msg = e.getMessage();
        }
        assertEquals("invalid pava amount", msg);

        try {
            tv = new Beele("Dease", 1944, 81);
        } catch(Exception e) {
            msg = e.getMessage();
        }
        assertEquals("invalid pava amount", msg);

    }

    @Test
    public void testInheritance() {
        var tv = new Beele("Dease", 1945, 60);
        boolean b = tv instanceof Tavunu;
        assertEquals(true, b);
    }
    
    @Test
    public void testToString() {
        var tv = new Beele("Dease", 1944, 62);
        
        assertEquals("Dease born in 1944 is a Beele with 62 pava.", tv.toString());
    }

    @Test
    public void testSetName() {
        var tv = new Beele("Dease", 1944, 62);

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
        var tv = new Beele("Dease", 1944, 62);

        tv.setBirthYear(-2001);
        assertEquals(-2001, tv.getBirthYear());

        tv.setBirthYear(0);
        assertEquals(0, tv.getBirthYear());

        tv.setBirthYear(2001);
        assertEquals(2001, tv.getBirthYear());
    }

    @Test
    public void testReceivePava() {
        var tv = new Beele("Dease", 1944, 60);

        boolean rv = tv.receivePava(-2001);
        assertEquals(60, tv.getPava());
        assertEquals(rv, false);

        rv = tv.receivePava(-1);
        assertEquals(60, tv.getPava());
        assertEquals(rv, false);

        rv = tv.receivePava(0);
        assertEquals(60, tv.getPava());
        assertEquals(rv, true);

        rv = tv.receivePava(1);
        assertEquals(61, tv.getPava());
        assertEquals(rv, true);

        rv = tv.receivePava(10);
        assertEquals(71, tv.getPava());
        assertEquals(rv, true);
    }

    @Test
    public void testSpendPava() {
        var tv = new Beele("Dease", 1944, 60);

        boolean rv = tv.spendPava(-2001);
        assertEquals(60, tv.getPava());
        assertEquals(rv, false);

        rv = tv.spendPava(-1);
        assertEquals(60, tv.getPava());
        assertEquals(rv, false);

        rv = tv.spendPava(0);
        assertEquals(60, tv.getPava());
        assertEquals(rv, true);

        rv = tv.spendPava(1);
        assertEquals(59, tv.getPava());
        assertEquals(rv, true);

        rv = tv.spendPava(10);
        assertEquals(49, tv.getPava());
        assertEquals(rv, true);
    }
}