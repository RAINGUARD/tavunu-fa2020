
public class CrodeExalted extends Crode {
	public CrodeExalted(String name, int birthYear, int pava) {
		super(name, 1, pava);
		if(pava<81)
			throw new IllegalArgumentException("invalid pava amount");
		if(birthYear%2!=0)
			throw new IllegalArgumentException("invalid year");
		super.birthYear = birthYear;
	}
	
	@Override
	public void setBirthYear(int x) {
		if(x%2!=0)
			throw new IllegalArgumentException("invalid year");
		super.birthYear=x;
	}
	
	public String toString() {
		return this.getName()+" born in "+this.getBirthYear()+" is an Exalted Crode with "+this.getPava()+" pava.";
	}
}
