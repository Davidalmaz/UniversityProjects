public final class Circle extends Geometry {
	public Circle(final double radius) {
		super(radius);
	}
	
	public Circle() {
		super();
	}
	
	public final double getArea() {
		return 2 * Math.pow(value1, 2);
	}
	
	public final double getRadius() {
		return value1;
	}
	
	public final void setRadius(final double r) {
		if (r < 0)
			throw new IllegalArgumentException("Radius < 0 not allowed");
		value1 = r;
	}
}