
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Crud;
import modelo.Producto;

public class CrudProductos implements Crud<Producto>{

    @Override
    public List<Producto> mostrar() {
        List<Producto> info = new ArrayList<>();
        String sql="SELECT * FROM producos";
         try (
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombreDelProducto(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setCantidad(rs.getInt(4));
                info.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta", JOptionPane.ERROR_MESSAGE);
        }

        return info;
    }
    

    @Override
    public int setAgregar(Producto p) {
        String sql = "INSERT INTO producos VALUES(?,?,?,?)";

        try (
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, p.getIdProducto());
            ps.setString(2, p.getNombreDelProducto());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            return ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Inserción", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    @Override
    public int setActualizar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int setEliminar(int idProducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
