/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class UsaFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PagoFactory pagoFactory = new PagoFactory();
       Pago pagos = pagoFactory.obtenerPago(TipoDePago.EFECTIVO);
       pagos.crearPago();
    }
    
}
