package modelo;

import java.util.List;

public interface Crud<P> {
    public List<P> mostrar();
    public int setAgregar(P producto);//tr nombre aleatorio
    public int setActualizar(P producto);
    public int setEliminar(int idProducto);
    

}
