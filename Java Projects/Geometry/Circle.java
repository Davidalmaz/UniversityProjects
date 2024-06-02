public class Circle extends Geometry {
	
	public Circle() {
		super();
	}
	
	public Circle(final double radius) {
		super(radius);
	}
	
	public double getArea() {
		return Math.PI * Math.pow(value1, 2);
	}
}