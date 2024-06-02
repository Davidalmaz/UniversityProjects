public final class TestDrive {
	public static void main(String[] args) {
		final Geometry[] g = {new Circle(), new Square(), new Rectangle(), new Triangle(), new Circle((byte)8), new Square((byte)4), new Triangle((byte)2, (byte)4)};
		
		for (byte i = 0, arrayLength = (byte)g.length; i < arrayLength; ++i)
			System.out.println(g[i].getArea());
	}
}