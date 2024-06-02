public final class TestDrive {
	public static void main(String[] args) {
		Animal a[] = {new Cat(), new Dog()};
		for (byte i = 0, size = (byte) a.length; i < size; ++i)
			System.out.println(a[i].toString() + " - " + a[i].talk());
	}
}