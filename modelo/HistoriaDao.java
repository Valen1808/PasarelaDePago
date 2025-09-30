package modelo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import modelo.Conexion;

public class HistoriaDao implements Crud_Historia<Historial_Compras>{

    @Override
    public int registrarH(Historial_Compras h) {
    String sql="INSERT INTO historial_compra (Cantidad, precio_total,id_usuario, id_producto,id_metodo_pago) VALUES (?, ?, ?, ?, ?)";
        try (
            Connection con = Conexion.getInstance().getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
                ){
            ps.setInt(1, h.getCantidad());
            ps.setDouble(2, h.getPrecio_total());
            ps.setInt(3, h.getId_usuario());
            ps.setInt(4, h.getId_producto());
            ps.setInt(5, h.getId_metodo_pago());
            
            ps.executeUpdate();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(Registrar Historia)", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    
    }
    public int buscarMetodo(String metodo){
        String sql="SELECT id_metodo FROM metodo_pago WHERE nombre_metodo = ?";
        int idMetodo=-1;
        try (
                Connection con= Conexion.getInstance().getConnection();
                PreparedStatement ps=con.prepareStatement(sql);
                //ResultSet rs = ps.executeQuery()
                ){
            ps.setString(1, metodo); 

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    idMetodo = rs.getInt("id_metodo"); 
                }
            }
            return idMetodo;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Error de Consulta(Buscar meetodo)", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        
    }
}
