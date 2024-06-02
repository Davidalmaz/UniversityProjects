public final class Square extends Geometry {
	public Square(final double side) {
		super(side);
	}
	
	public Square() {
		super();
	}
	
	public final double getArea() {
		return Math.pow(value1, 2);
	}
	
	public final double getSide() {
		return value1;
	}
	
	public final void setSide(final double s) {
		if (s < 0)
			throw new IllegalArgumentException("Side < 0 not allowed");
		value1 = s;
	} 
}