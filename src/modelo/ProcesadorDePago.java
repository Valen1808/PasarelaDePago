/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author norqu
 */
public class ProcesadorDePago {
    private ProcesoDePago estrategiaDePago;

    public void setEstrategiaDePago(ProcesoDePago estrategiaDePago) {
        this.estrategiaDePago = estrategiaDePago;
    }

    public void procesarPago(double monto) {
        if (estrategiaDePago != null) {
            estrategiaDePago.pagar(monto);
              System.out.println(estrategiaDePago.toString());
        } else {
            System.out.println(" No se ha definido una estrategia de pago.");
        }
    }
}
