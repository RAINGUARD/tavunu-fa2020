import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Tavunu class w/ JUnit 4.
 *
 * @author Mithat Konar
 */
public class TavunuTest {

    class TavunuConcrete extends Tavunu {

        TavunuConcrete() {
            super();
        }
        
        TavunuConcrete(String name, int birthYear, int pava) {
            super(name, birthYear, pava);
        }
    };
    
    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorNoArg() {
        var tv = new TavunuConcrete();
        assertEquals(tv.getName(), "");
        assertEquals(tv.getPava(), 0);
        assertEquals(tv.getBirthYear(), Integer.MIN_VALUE);
    }

    /*
     * Also tests accessors.
     */
    @Test
    public void testCtorParams() {
        var tv = new TavunuConcrete("Dease", 1944, 42);
        assertEquals(tv.getName(), "Dease");
        assertEquals(tv.getPava(), 42);
        assertEquals(tv.getBirthYear(), 1944);
    }

    @Test
    public void testToString() {
        var tv = new TavunuConcrete("Dease", 1944, 42);

        assertEquals("" + tv, "Dease born in 1944 has 42 pava.");
    }

    @Test
    public void testSetName() {
        var tv = new TavunuConcrete();

        tv.setName("");
        assertEquals(tv.getName(), "");

        tv.setName("T");
        assertEquals(tv.getName(), "T");

        tv.setName("D");
        assertEquals(tv.getName(), "D");

        tv.setName("Trelling");
        assertEquals(tv.getName(), "Trelling");

        tv.setName("Dint");
        assertEquals(tv.getName(), "Dint");

        tv.setName("tranque");
        assertEquals(tv.getName(), "Dint");

        tv.setName("demary");
        assertEquals(tv.getName(), "Dint");

        tv.setName("Hint");
        assertEquals(tv.getName(), "Dint");
    }

    @Test
    public void testSetYear() {
        var tv = new TavunuConcrete("Dease", 1944, 42);

        tv.setBirthYear(-2001);
        assertEquals(tv.getBirthYear(), -2001);

        tv.setBirthYear(0);
        assertEquals(tv.getBirthYear(), 0);

        tv.setBirthYear(2001);
        assertEquals(tv.getBirthYear(), 2001);
    }

    @Test
    public void testReceivePava() {
        var tv = new TavunuConcrete("Dease", 1944, 42);

        boolean rv = tv.receivePava(-2001);
        assertEquals(tv.getPava(), 42);
        assertEquals(rv, false);

        rv = tv.receivePava(-1);
        assertEquals(tv.getPava(), 42);
        assertEquals(rv, false);

        rv = tv.receivePava(0);
        assertEquals(tv.getPava(), 42);
        assertEquals(rv, true);

        rv = tv.receivePava(1);
        assertEquals(tv.getPava(), 43);
        assertEquals(rv, true);

        rv = tv.receivePava(10);
        assertEquals(tv.getPava(), 53);
        assertEquals(rv, true);
    }

    @Test
    public void testSpendPava() {
        var tv = new TavunuConcrete("Dease", 1944, 42);

        boolean rv = tv.spendPava(-2001);
        assertEquals(tv.getPava(), 42);
        assertEquals(rv, false);

        rv = tv.spendPava(-1);
        assertEquals(tv.getPava(), 42);
        assertEquals(rv, false);

        rv = tv.spendPava(0);
        assertEquals(tv.getPava(), 42);
        assertEquals(rv, true);

        rv = tv.spendPava(1);
        assertEquals(tv.getPava(), 41);
        assertEquals(rv, true);

        rv = tv.spendPava(10);
        assertEquals(tv.getPava(), 31);
        assertEquals(rv, true);
    }

}