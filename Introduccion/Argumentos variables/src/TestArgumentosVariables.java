
public class TestArgumentosVariables {
	
	//métodos que reciben varios argumentos
	
	public static void main(String args[]) {
		mostrarVarArgs(1,2,3,4);
		argumentosYVarArgs("César", 1,7,9,10);
	}
	
	private static void mostrarVarArgs(int...numeros) {
		for(int i = 0; i<numeros.length; i++) {
			System.out.println("numeros: "+numeros[i]);
		}
	}
	
	private static void argumentosYVarArgs(String nombre, int...numeros) {
		System.out.println(nombre);
		mostrarVarArgs(numeros);
	}

}
