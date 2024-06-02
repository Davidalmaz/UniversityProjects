import java.util.ArrayList;
public final class Test {
	
	public static void main(String[] args) {
		ArrayList<String> numbers = new ArrayList<String>();
		
		numbers.add("one");
		numbers.add("two");
		
		System.out.println("Tamaño: " + numbers.size());
		
		numbers.remove("two");
		System.out.println("Se ha removido el segundo elemento");
		
		System.out.println("Tamaño: " + numbers.size());
		
		System.out.println("¿Está vacío? " + numbers.isEmpty());
		
	}
}