package herencia;

public class Herencia {

    public static void main(String[] args) {
        EstudianteDAO dao = new EstudianteDAO();
        dao.imprimir(new EstudianteDTO(9.4, 54, 384541, "César   "));
    }
    
}
