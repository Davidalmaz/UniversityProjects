public abstract class Geometry {
	protected double value1, value2;
	
	Geometry() {
		value1 = value2 = 5;
	}
	
	Geometry(final double x) {
		if (x < 0)
			throw new IllegalArgumentException("Value < 0 not allowed");
		value1 = value2 = x;
	}
	
	Geometry(final double value1, final double value2) {
		if (value1 < 0 || value2 < 0)
			throw new IllegalArgumentException("First value or second value entered is < 0");
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public abstract double getArea();
}