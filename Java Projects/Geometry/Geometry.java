public abstract class Geometry {
	protected double value1, value2;
	
	public Geometry() {
		value1 = value2 = 5;
	}
	
	public Geometry(final double value1) {
		if (value1 < 0)
			throw new IllegalArgumentException("Please enter numbers equal or greater than 0");
		this.value1 = value1;
	}
	
	public Geometry(final double value1, final double value2) {
		if (value1 < 0 || value2 < 0)
			throw new IllegalArgumentException("Please enter numbers equal or greater than 0");
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public abstract double getArea();
}