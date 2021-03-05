package mx.com.gm.ventas;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Orden {
	private static final int MAX_PRODUCTOS = 10;
	private int idOrden;
	private Producto productos[];
	private static int contadorOrdenes = 0; //lleva un contador de ordenes para asignarle un id a cada una
	private int contadorProductos;
	
	public Orden(){
		this.idOrden = Orden.contadorOrdenes++;
		productos = new Producto[Orden.MAX_PRODUCTOS];
	}
	
	public int getIdOrden() {
		return this.idOrden;
	}
	
	/*
	 * agrega un nuevo producto a la orden
	 * @Param Producto producto
	 */
	public void agregarProducto(Producto producto) {
		if(this.contadorProductos< Orden.MAX_PRODUCTOS) {
			productos[this.contadorProductos++] = producto;
		}
	}
	
	/*
	 * calcular el total a pagar por los productos en la orden
	 */
	public double calcularTotal() {
		double total = 0;
		for(int i = 0; i < Producto.contadorProductos; i++) {
			if(productos[i] != null) {
				total += productos[i].getPrecio();
			}
	
		}
		return total;
	}
	
	/*
	 * muestra en consola la informacion de la orden
	 */
	public void mostrarOrden() {
		//crea la fecha y hora en que se pide la nota 
		LocalDate date = LocalDate.now();
		LocalDateTime hour = LocalDateTime.now();
		String fecha = String.valueOf(date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear()+" "+hour.getHour()+":"+hour.getMinute());
		
		//creamos un string con StringBuilder para solo mostrar dicho string
		StringBuilder sb = new StringBuilder();
		sb.append("Factura Sistema de venta \n");	//agrega el titulo de la orden
		sb.append("Número de orden:  "+this.idOrden+"\n");
		sb.append("Fecha de la orden: "+fecha+"\n\n");	//agrega la fecha
		sb.append("id   Nombre   Precio \n");		//agrega la cabecera
		//agrega los productos de la orden al string
		for(int i = 0; i < Orden.MAX_PRODUCTOS; i++) {
			if(productos[i] != null) {
				sb.append(productos[i].getIdProducto()+"   "+productos[i].getNombre()+"   "+productos[i].getPrecio()+"\n");
			}
		}
		//añade informacion del pago: IVA y Base imponible
		sb.append("\n IVA 21% \t\t "+(0.21*calcularTotal()) +"\nBase Imponible \t\t"+calcularTotal());
		sb.append("\nTotal: \t\t"+((0.21*calcularTotal())+calcularTotal()));
		
		//imprime el string con toda la informacion en consola
		System.out.println(String.valueOf(sb));
	}
}
