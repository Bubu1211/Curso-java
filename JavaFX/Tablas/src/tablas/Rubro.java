package tablas;

public class Rubro {
    String nombreRubro; 
    int porcentaje;
    double valor;

    public Rubro(String nombreRubro, int porcentaje, double valor) {
        this.nombreRubro = nombreRubro;
        this.porcentaje = porcentaje;
        this.valor = valor;
    }

    public String getNombreRubro() {
        return nombreRubro;
    }

    public void setNombreRubro(String nombreRubro) {
        this.nombreRubro = nombreRubro;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
