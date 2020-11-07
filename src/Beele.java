
public class Beele extends Tavunu {
	public Beele(String name, int birthYear, int pava) {
		super(name, birthYear, pava);
		if(pava<21 || pava>80)
			throw new IllegalArgumentException("invalid pava amount");
	}
	
	public String toString() {
		return this.getName()+" born in "+this.getBirthYear()+" is a Beele with "+this.getPava()+" pava.";
	}
}
