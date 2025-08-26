/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author norqu
 */
public class Factory {
    Map<TipoDePago, Pagos> pagos = new HashMap<>(){{
        put(TipoDePago.APPLE_PLAY, new PagoApplePay());
        put(TipoDePago.BIT_CION, new PagoBitCoin());
        put(TipoDePago.CONSIGNACION, new PagoConsignacion());
        put(TipoDePago.EFECTIVO, new PagoEfectivo());
        put(TipoDePago.GOOGLE_PAY, new PagoGooglePlay());
        put(TipoDePago.PAYPAL, new PagoPayPal());
        put(TipoDePago.TARJETA_CREDITO, new PagoTarjetaCredito());
        put(TipoDePago.TARJETA_DEBITO, new PagoTarjetaDebito());
        put(TipoDePago.TRASFERENCIA, new PagoTrasferencia());
    }};
    
    public Pagos obtenerPago(TipoDePago tipopago){
        return pagos.get(tipopago);
    }
}
