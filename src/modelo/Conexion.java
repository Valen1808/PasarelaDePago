package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Conexion instance;
    private final String url = "jdbc:mysql://localhost:3306/pasarela";
    private final String user = "root";
    private final String pass = "";

    private Conexion() {}

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver"); 
        return DriverManager.getConnection(url, user, pass);
    }
}
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Conexion instance;
    private final String url = "jdbc:mysql://localhost:3306/pasarela";
    private final String user = "root";
    private final String pass = "";

    private Conexion() {}

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver"); 
        return DriverManager.getConnection(url, user, pass);
    }
}
// si es arriba de 5 se le aumenta el cj
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static Conexion instance;
    private final String url = "jdbc:mysql://localhost:3306/pasarela";
    private final String user = "root";
    private final String pass = "";

    private Conexion() {}

    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver"); 
        return DriverManager.getConnection(url, user, pass);
    }
}
// si es arriba de 5 se le aumenta el cj
