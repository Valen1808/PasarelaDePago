package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Producto;
import modelo.CrudPd;

public class CrudProductos implements CrudPd<Producto>{

    @Override
    public List<Producto> mostrar() {
        List<Producto> info = new ArrayList<>();
        String sql="SELECT id_producto, nombre_producto, precio_producto, cantidad_producto FROM productos WHERE cantidad_producto>0";
         try (
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("id_producto"));
                p.setNombreDelProducto(rs.getString("nombre_producto"));
                p.setPrecio(rs.getDouble("precio_producto"));
                p.setCantidad(rs.getInt("cantidad_producto"));

                info.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }
        return info;
    }
    
    @Override
    public int setActualizar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int setDismuirStock(int idProducto, int cantidad) {
        String sql="UPDATE productos SET cantidad_producto=cantidad_producto-? WHERE id_producto=?";
        
        try (
                Connection con=Conexion.getInstance().getConnection();
                PreparedStatement ps= con.prepareStatement(sql);
                ){
            ps.setInt(1, cantidad);
            ps.setInt(2, idProducto);
            
            return ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(Disminuir cantidad)", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        
        
    }

   
    
    
}

    
