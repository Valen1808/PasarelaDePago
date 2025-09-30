
package modelo;

public class Historial_Compras {
    int cantidad;
    double precio_total;
    int id_usuario;
    int id_producto;
    int id_metodo_pago;

    public Historial_Compras(int cantidad, double precio_total, int id_usuario, int id_producto, int id_metodo_pago) {
        this.cantidad = cantidad;
        this.precio_total = precio_total;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.id_metodo_pago = id_metodo_pago;
    }

    public Historial_Compras() {
    }
    
    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }
    
    
    
}
