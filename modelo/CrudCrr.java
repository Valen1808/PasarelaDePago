
package modelo;

import java.util.List;

public interface CrudCrr<C> {
    public List<C> mostrarCarrito();
    public boolean buscar(int idpersona, int idProducto);
    public int agregarProductos(C c);
    public int reiniciarCarrito(int id);
    public int eliminarProducto(int idpersona, int idProducto);
}
