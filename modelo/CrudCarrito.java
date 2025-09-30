package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CrudCarrito implements CrudCrr<Carrito>{
    @Override
        public List<Carrito> mostrarCarrito() {
        List<Carrito> info = new ArrayList<>();
        String sql = "SELECT c.id_usuario, c.id_producto, p.nombre_producto, c.precio, c.cantidad, c.fecha_agregado FROM carrito_compras c JOIN productos p ON c.id_producto = p.id_producto";
        //
        try (
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Carrito c = new Carrito();
                c.setId_usuario(rs.getInt("id_usuario"));
                c.setId_producto(rs.getInt("id_producto"));
                c.setNombreproducto(rs.getString("nombre_producto"));
                c.setPrecio(rs.getDouble("precio"));
                c.setCantidad(rs.getInt("cantidad"));   
                info.add(c);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(mostrar)", JOptionPane.ERROR_MESSAGE);
        }
        return info;
    }

    @Override
    public boolean buscar(int idpersona, int idProducto) {
    String sql = "SELECT * FROM carrito_compras WHERE id_producto=? AND id_usuario=?";

    try(Connection con = Conexion.getInstance().getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        //ResultSet rs = ps.executeQuery();
        ) {
        ps.setInt(1, idProducto);
        ps.setInt(2, idpersona);
        
        ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;  
            } else {
                return false; 
            }
        

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(busqueda)", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}

    @Override
    public int agregarProductos(Carrito c) {
        int idProducto=c.getId_producto();
        int idUsuario=c.getId_usuario();
        boolean confirmacion=buscar(idUsuario, idProducto);
        //JOptionPane.showMessageDialog(null, confirmacion);
        if(!confirmacion){
            //JOptionPane.showMessageDialog(null, "insertar");
            String sql = "INSERT INTO carrito_compras (id_usuario, id_producto, precio, cantidad) VALUES (?, ?, ?,?)";
            try (
                Connection con = Conexion.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
            ) {
                ps.setInt(1, c.getId_usuario());
                ps.setInt(2, c.getId_producto());
                ps.setDouble(3, c.getPrecio());
                ps.setInt(4, c.getCantidad());
                int f=ps.executeUpdate();
                if(f>0){
                    
                    JOptionPane.showMessageDialog(null, "Producto agregado: " +nombreProducto(c.getId_producto()) );

                }else{
                    JOptionPane.showMessageDialog(null, "No se agrego un producto del carrito");
                }
            return 1;
            //return ps.executeUpdate();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(agregar carrito)", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        }else{
            //JOptionPane.showMessageDialog(null, "actualizar");
            String sql = "UPDATE carrito_compras SET cantidad = cantidad + 1 WHERE id_producto=?";
            try (
                Connection con = Conexion.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
            ) {
                ps.setInt(1, idProducto);
                int f=ps.executeUpdate();
                if(f>0){
                    JOptionPane.showMessageDialog(null, "Se aumento la cantidad del producto: "+nombreProducto(c.getId_producto()));
                }else{
                    JOptionPane.showMessageDialog(null, "No se aumento la cantidad");
                }
            return 1;
                //return ps.executeUpdate();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(agregar carrito)", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        }
    }

    @Override
    public int reiniciarCarrito(int id) {
        String sql="DELETE FROM carrito_compras WHERE id_usuario=?";
        try (
            Connection con= Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ){
            
            ps.setInt(1, id);
            int afectadas= ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(limpiar carrito)", JOptionPane.ERROR_MESSAGE);
                return 0;
        }
    }
    
    @Override
    public int eliminarProducto(int idpersona, int idProducto) {
        String sql="DELETE FROM carrito_compras WHERE id_usuario=? AND id_producto=?";
        try (
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
        ){
            String nombreProducto=nombreProducto(idProducto);
            ps.setInt(1, idpersona);
            ps.setInt(2, idProducto);
            
            int f=ps.executeUpdate();
                if(f>0){
                    JOptionPane.showMessageDialog(null, "Se elimino: "+nombreProducto+" del carrito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se elimino un producto del carrito");
                }
            return 1;
            //return ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(eliminar producto)", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        
    }
    
    public String nombreProducto(int id){
        String nombreProducto = "";
        String sqlNombre = "SELECT nombre_producto FROM productos WHERE id_producto = ?";
        try ( Connection con = Conexion.getInstance().getConnection();
                PreparedStatement ps = con.prepareStatement(sqlNombre);
                
            ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nombreProducto = rs.getString("nombre_producto");
                }
            }
            return nombreProducto;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(consultar nombre producto)", JOptionPane.ERROR_MESSAGE);
            return "";
        }

    }
    
}