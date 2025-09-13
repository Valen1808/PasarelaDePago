
package modelo;
import modelo.Factory;
import modelo.ProcesoDePago;
import modelo.TipoDePago;
import vista.Vista;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static modelo.TipoDePago.EFECTIVO;

/**
 *
 * @author norqu
 */
public class usar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        /*
        ProcesoDePago pago = new MetodoEfectivo(10000);
        ProcesadorDePago procesador = new ProcesadorDePago();
        procesador.setEstrategiaDePago(pago);
        procesador.procesarPago(6000);
        */
        
//        int numeroTarjeta = 1281267;
//        String fechaExpiracion = "12/27";
//        int cvv = 123;
//        double monto = 250.00;
//        
//        ProcesoDePago pagoDevito = new MetodoDebito(
//            numeroTarjeta,
//            cvv,
//            fechaExpiracion,
//            monto
//        );
//        
//        
//        ProcesadorDePago procesador2 = new ProcesadorDePago();
//        procesador2.setEstrategiaDePago(pagoDevito);
//        procesador2.procesarPago(70000);
    int numeroTarjeta = 1281267;
    String fechaExpiracion = "12/27";
    int cvv = 123;
    double monto = 250.00;
    double saldo = 500.00;
    
    Connection con = Conexion.getInstance().getConnection();
   /* Factory factory = new Factory();
    ProcesoDePago pagoDevito = new PagoTarjetaDebito(
        numeroTarjeta,
        cvv,
        fechaExpiracion,
        saldo
    );
    */
/*
        // 1. Pides la estrategia al Factory
        ProcesoDePago estrategia = factory.obtenerPago(TipoDePago.PAYPAL);

        // 2. Creas el procesador y le inyectas la estrategia
        ProcesadorDePago procesador = new ProcesadorDePago();
        procesador.setEstrategiaDePago(estrategia);

        // 3. Procesas el pago
        procesador.procesarPago(250.0);
       */ 
       

//       Factory factory = new Factory();
//        factory.setSaldo(200000);
//        factory.setDestinatario("juan@correo.com");
//        factory.setNumeroCuenta("123456");
//
//        ProcesoDePago pago = factory.obtenerPago(TipoDePago.TRASFERENCIA);
//        pago.pagar(monto);
ProcesadorDePago procesador = new ProcesadorDePago(); 
        Factory factory = new Factory();
factory.setSaldo(200000);
factory.setDestinatario("juan@correo.com");
factory.setNumeroCuenta("123456");

// Obtener el objeto de pago
ProcesoDePago pago = factory.obtenerPago(TipoDePago.TRASFERENCIA);

// Realizar el pago
pago.pagar(monto);

// Verificar si el pago fue exitoso
boolean pagoExitoso = procesador.exitoEnPago(); // procesador es el objeto que controla el estado

if(pagoExitoso) {
    JOptionPane.showMessageDialog(null, "Pago realizado con éxito ✅");
} else {
    JOptionPane.showMessageDialog(null, "Pago fallido ❌");
}


    }
}
