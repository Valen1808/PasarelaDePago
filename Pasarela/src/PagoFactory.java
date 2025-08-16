/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author usuario
 */
public class PagoFactory {
    private final static Map<TipoDePago, Pago> pagos = new HashMap<>() {
        {

            put(TipoDePago.PAYPAL, new PagoPaypal());
            put(TipoDePago.EFECTIVO, new PagoEfectivo());

        }
    };


    public Pago obtenerPago(TipoDePago tipoDePago){
        return pagos.get(tipoDePago);
    }
}
