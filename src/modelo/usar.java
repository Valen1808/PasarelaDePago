
package modelo;

import static modelo.TipoDePago.EFECTIVO;

/**
 *
 * @author norqu
 */
public class usar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ProcesoDePago pago = new MetodoEfectivo(10000);
        ProcesadorDePago procesador = new ProcesadorDePago();
        procesador.setEstrategiaDePago(pago);
        procesador.procesarPago(6000);
        */
        
        int numeroTarjeta = 1281267;
        String fechaExpiracion = "12/27";
        int cvv = 123;
        double monto = 250.00;
        
        ProcesoDePago pagoDevito = new MetodoDebito(
            numeroTarjeta,
            cvv,
            fechaExpiracion,
            monto
        );
        
        ProcesadorDePago procesador2 = new ProcesadorDePago();
        procesador2.setEstrategiaDePago(pagoDevito);
        procesador2.procesarPago(70000);

        
    }
}
