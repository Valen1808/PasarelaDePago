
package modelo;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
public class Conexion {
    Connection conecxion;
    String url="jdbc:mysql://localhost:3306/";
    String passwor="";
    String user="root";
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conecxion=DriverManager.getConnection(url,user,passwor);
            System.out.println("Conexion exitosa");
        }catch(Exception ec){
            System.out.println("Base de datos Apagada");
        }
        return conecxion;
    }
}
