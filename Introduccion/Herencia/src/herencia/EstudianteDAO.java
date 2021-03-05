package herencia;

public class EstudianteDAO implements IDAO{

    @Override
    public void imprimir(ObjectDTO objeto) {
        objeto = new EstudianteDTO();
        
        System.out.println(((EstudianteDTO)objeto).getNombre());
        System.out.println(((EstudianteDTO)objeto).getPromedio());
        System.out.println(((EstudianteDTO)objeto).getAsistencias());
        System.out.println(((EstudianteDTO)objeto).getId());
        
        
    }
    
}
