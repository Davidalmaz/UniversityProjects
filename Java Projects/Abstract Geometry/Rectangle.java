public final class Rectangle extends Geometry {
	public Rectangle(final double width, final double length) {
		super(width, length);
	}
	
	public Rectangle() {
		super();
	}
	
	public final double getArea() {
		return value1 * value2;
	}
	
	public final void setWidth(final double w) {
		if (w < 0)
			throw new IllegalArgumentException("Wide < 0 not allowed");
		value1 = w;
	}
	
	public final void setLength(final double l) {
		if (l < 0)
			throw new IllegalArgumentException("Length < 0 not allowed");
		value2 = l;
	}
	
	public final void setWidthLength(final double w, final double l) {
		if (w < 0 || l < 0)
			throw new IllegalArgumentException("Wide or Length < 0 not allowed");
		value1 = w;
		value2 = l;
	}
	
	public final double getLength() {
		return value2;
	}
	
	public final double getWidth() {
		return value1;
	}
}