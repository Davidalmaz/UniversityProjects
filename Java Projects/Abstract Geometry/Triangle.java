public final class Triangle extends Geometry {
	public Triangle() {
		super();
	}
	
	public Triangle(final double base, final double heigth) {
		super(base, heigth);
	}
	
	public final double getArea() {
		return (value1 * value2) / 2;
	}
	
	public final void setBase(final double b) {
		if (b < 0)
			throw new IllegalArgumentException("Base < 0 not allowed");
		value1 = b;
	}
	
	public final void setHeigth(final double h) {
		if (h < 0)
			throw new IllegalArgumentException("Heigth < 0 not allowed");
		value2 = h;
	}
	
	public final void setBaseHeigth(final double b, final double h) {
		if (b < 0 || h < 0)
			throw new IllegalArgumentException("Base or Heigth < 0 not allowed");
		value1 = b;
		value2 = h;
	}
	
	public final double getBase() {
		return value1;
	}
	
	public final double getHeigth() {
		return value2;
	}
}