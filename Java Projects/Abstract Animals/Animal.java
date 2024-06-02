public abstract class Animal {
	Animal() {}
	
	public abstract String talk();
	
	public String toString() {
		return "This is a " + getClass().getSimpleName();
	}
}