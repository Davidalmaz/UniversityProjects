public class Triangle extends Geometry {
	
	public Triangle() {
		super();
	}
	
	public Triangle(final double base, final double height) {
		super(base, height);
	}
	
	public double getArea() {
		return (value1 * value2) / 2;
	}
	
}