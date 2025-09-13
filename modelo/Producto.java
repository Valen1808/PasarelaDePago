package modelo;

public class Producto {
    private int idProducto; 
    private String nombreDelProducto;
    private double precio; 
    private int cantidad;

    public Producto(int idProducto, String nombreDelProducto, double precio, int cantidad) {
        this.idProducto = idProducto;
        this.nombreDelProducto = nombreDelProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
