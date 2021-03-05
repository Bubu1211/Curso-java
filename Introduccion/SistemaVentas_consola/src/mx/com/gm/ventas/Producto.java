package mx.com.gm.ventas;

public class Producto {
	private int idProducto;
	private String nombre;
	private double precio;
	public static int contadorProductos ;
	
	private Producto() {
		this.idProducto = Producto.contadorProductos++; //asgina el valor y luego lo aumenta
	}
	
	public Producto(String nombre, double precio) {
		this();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getIdProducto() {
		return this.idProducto;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Producto[idProducto= "+this.idProducto);
		sb.append(", nombre= "+this.nombre);
		sb.append(", precio= "+this.precio+"]");
		return String.valueOf(sb);
	}
}
