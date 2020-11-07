
public class Crode extends Tavunu {
	public Crode(String name, int birthYear, int pava) {
		super(name, birthYear, pava);
		if(pava<81)
			throw new IllegalArgumentException("invalid pava amount");
		if(birthYear%2==0)
			throw new IllegalArgumentException("invalid year");
	}
	
	@Override
	public void setBirthYear(int x) {
		if(x%2==0)
			throw new IllegalArgumentException("invalid year");
		super.birthYear = x;
	}
	
	public String toString() {
		return this.getName()+" born in "+this.getBirthYear()+" is a Crode with "+this.getPava()+" pava.";
	}
}
