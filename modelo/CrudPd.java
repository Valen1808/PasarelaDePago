package modelo;

import java.util.List;

public interface CrudPd<P> {
    public List<P> mostrar();
    public int setActualizar(P producto);
    public int setDismuirStock(int idProducto, int cantidad);
}
