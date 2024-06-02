public final class TestDrive {
	public static void main(String[] args) {
		Triangle t = new Triangle(5, 2);
		System.out.println(t.getArea());
		Circle c = new Circle(5);
		System.out.println(c.getArea());
	}
}