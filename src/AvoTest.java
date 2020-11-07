import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Avo class w/ JUnit 4.
 *
 * Yes, it's a total pain writing unit tests for a class hierarchy. There are
 * better ways than what I'm doing here, but those are beyond the scope of this
 * course.
 * 
 * @author Mithat Konar
 */
public class AvoTest {
    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorValidParams() {
        Avo tv;

        tv = new Avo("Dease", 1944, 0);
        assertEquals("Dease", tv.getName());
        assertEquals(10, tv.getPava());
        assertEquals(1944, tv.getBirthYear());

        tv = new Avo("Dease", 1944, 9);
        assertEquals("Dease", tv.getName());
        assertEquals(10, tv.getPava());
        assertEquals(1944, tv.getBirthYear());     
        
        tv = new Avo("Dease", 1944, 10);
        assertEquals("Dease", tv.getName());
        assertEquals(10, tv.getPava());
        assertEquals(1944, tv.getBirthYear());
        
        tv = new Avo("Dease", 1944, 11);
        assertEquals("Dease", tv.getName());
        assertEquals(11, tv.getPava());
        assertEquals(1944, tv.getBirthYear());
        
        tv = new Avo("Dease", 1944, 20);
        assertEquals("Dease", tv.getName());
        assertEquals(20, tv.getPava());
        assertEquals(1944, tv.getBirthYear());
    }

    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorInValidParams() {
        Avo tv;
        String msg = "";

        try {
            tv = new Avo("Dease", 1944, 21);
        } catch(Exception e) {
            msg = e.getMessage();
        }
        assertEquals("invalid pava amount", msg);
    }
    
    @Test
    public void testInheritance() {
        var tv = new Avo("Dease", 1944, 20);
        boolean b = tv instanceof Tavunu;
        assertEquals(true, b);
    }
    
    @Test
    public void testToString() {
        var tv = new Avo("Dease", 1944, 12);
        
        assertEquals("Dease born in 1944 is an Avo with 12 pava.", tv.toString());
    }

    @Test
    public void testSetName() {
        var tv = new Avo("Dease", 1944, 20);

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
        var tv = new Avo("Dease", 1944, 16);

        tv.setBirthYear(-2001);
        assertEquals(-2001, tv.getBirthYear());

        tv.setBirthYear(0);
        assertEquals(0, tv.getBirthYear());

        tv.setBirthYear(2001);
        assertEquals(2001, tv.getBirthYear());
    }

    @Test
    public void testReceivePava() {
        var tv = new Avo("Dease", 1944, 0);

        boolean rv = tv.receivePava(-2001);
        assertEquals(10, tv.getPava());
        assertEquals(rv, false);

        rv = tv.receivePava(-1);
        assertEquals(10, tv.getPava());
        assertEquals(rv, false);

        rv = tv.receivePava(0);
        assertEquals(10, tv.getPava());
        assertEquals(rv, true);

        rv = tv.receivePava(1);
        assertEquals(11, tv.getPava());
        assertEquals(rv, true);

        rv = tv.receivePava(10);
        assertEquals(21, tv.getPava());
        assertEquals(rv, true);
    }

    @Test
    public void testSpendPava() {
        var tv = new Avo("Dease", 1944, 20);

        boolean rv = tv.spendPava(-2001);
        assertEquals(20, tv.getPava());
        assertEquals(rv, false);

        rv = tv.spendPava(-1);
        assertEquals(20, tv.getPava());
        assertEquals(rv, false);

        rv = tv.spendPava(0);
        assertEquals(20, tv.getPava());
        assertEquals(rv, true);

        rv = tv.spendPava(1);
        assertEquals(19, tv.getPava());
        assertEquals(rv, true);

        rv = tv.spendPava(10);
        assertEquals(9, tv.getPava());
        assertEquals(rv, true);
    }

}