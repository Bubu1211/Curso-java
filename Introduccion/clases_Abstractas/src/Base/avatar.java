
package Base;

public abstract class avatar {
    public abstract void paint();
    public abstract void borrar();
    
    public void crear(){
        paint();
    }
    public void eliminar(){
        borrar();
    }
}
