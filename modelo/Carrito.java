package modelo;

public class Carrito {
    private int id_carrito;
    private int id_usuario;
    private int id_producto;
    private double precio;
    private int cantidad;
    private String nombreproducto;

    public Carrito() {}
    
    public Carrito(int id_usuario, int id_producto,double precio, int cantidad) {
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.precio=precio;
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }
    
    
}
