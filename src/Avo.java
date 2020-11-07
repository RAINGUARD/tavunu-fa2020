
public class Avo extends Tavunu {
	
	public Avo(String name, int birthYear, int pava) {
		super(name, birthYear, pava);
		if(pava>20)
			throw new IllegalArgumentException("invalid pava amount");
	}
	
	public String toString() {
		return this.getName()+" born in "+this.getBirthYear()+" is an Avo with "+this.getPava()+" pava.";
	}
}
