package ventas;

import mx.com.gm.ventas.Producto;
import mx.com.gm.ventas.Orden; 

public class VentasTest {
	public static void main(String ags[]) {
		
		Producto p3 = new Producto("Carlos V", 5.50);
		Producto p1 = new Producto("cheetos queso", 13.50);
		Producto p2 = new Producto("Nito", 11.20);
		Orden orden = new Orden();
		orden.agregarProducto(p1);
		orden.agregarProducto(p2);
		orden.agregarProducto(p3);
		
		orden.mostrarOrden();
	}
}
