
/**
 * A tavunu is an imaginary Earth-dwelling being.
 *
 * A tavunu looks a bit like a Patagonian Mara and lives in a non-gendered but
 * hierarchical society. Most interactions among tavuni are negotiated with
 * pava -- items of status used for bargaining.
 *
 * @author Mithat Konar
 * @author Your Name
 */
public class Tavunu {
    private String name;
    private int pava;
    private int birthYear;
    
    public Tavunu() {
    	
    }
    
    public Tavunu(String a, int x, int y) {
    	name = a;
    	pava = x;
    	birthYear = y;
    }
    
    public boolean setName(String a) {
    	if(a.charAt(0)==('D')||a.charAt(0)==('T')) {
    		name = a;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public String getName() {
    	return name;
    }
    
    public boolean spendPava(int amount) {
    	if(amount>0) {
    		pava -= amount;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean receivePava(int amount) {
    	if(amount>0) {
    		pava+=amount;
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public int getPava() {
    	return pava;
    }
    
    public int getBirthYear() {
    	return birthYear;
    }
    
    public void setBirthYear(int x) {
    	birthYear = x;
    }
    
    public String toString() {
    	return "Name: "+name+", Amount of Pava: "+pava+", BirthYear: "+birthYear;
    }
}
