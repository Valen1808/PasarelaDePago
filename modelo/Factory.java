
package modelo;

import java.util.HashMap;
import java.util.Map;
import vista.Vista;

public class Factory {
    private  double saldo, totalrecibido;
    private boolean confirmacionApple, confirmacionGoogle; 
    private String destinatario, banco, contrasena, fechavencimiento;
    private String numeroCuenta,numerocuentadevito, numerocuentacredito;
    private int documento,cvc;
    
    String email;

    public Factory() {
    }

    public ProcesoDePago obtenerPago(TipoDePago tipopago) {
        Map<TipoDePago, ProcesoDePago> pagos = new HashMap<>();

        pagos.put(TipoDePago.APPLE_PLAY, new PagoApplePay(confirmacionApple,saldo));
        pagos.put(TipoDePago.BIT_CION, new PagoBitCoin(destinatario, saldo));
        pagos.put(TipoDePago.TRASFERENCIA, new PagoTrasferencia(numeroCuenta, banco,  saldo));
        pagos.put(TipoDePago.EFECTIVO, new PagoEfectivo(totalrecibido));
        pagos.put(TipoDePago.GOOGLE_PAY, new PagoGooglePlay(confirmacionGoogle, saldo));
        pagos.put(TipoDePago.PAYPAL, new PagoPayPal(email,documento,contrasena,saldo));
        pagos.put(TipoDePago.TARJETA_CREDITO, new PagoTarjetaCredito(numerocuentacredito,cvc,fechavencimiento,saldo));
        pagos.put(TipoDePago.TARJETA_DEBITO, new PagoTarjetaDebito(numerocuentadevito,cvc,fechavencimiento,saldo));

        return pagos.get(tipopago);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTotalrecibido() {
        return totalrecibido;
    }

    public void setTotalrecibido(double totalrecibido) {
        this.totalrecibido = totalrecibido;
    }

    public boolean isConfirmacionApple() {
        return confirmacionApple;
    }

    public void setConfirmacionApple(boolean confirmacionApple) {
        this.confirmacionApple = confirmacionApple;
    }

    public boolean isConfirmacionGoogle() {
        return confirmacionGoogle;
    }

    public void setConfirmacionGoogle(boolean confirmacionGoogle) {
        this.confirmacionGoogle = confirmacionGoogle;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumerocuentadevito() {
        return numerocuentadevito;
    }

    public void setNumerocuentadevito(String numerocuentadevito) {
        this.numerocuentadevito = numerocuentadevito;
    }

    public String getNumerocuentacredito() {
        return numerocuentacredito;
    }

    public void setNumerocuentacredito(String numerocuentacredito) {
        this.numerocuentacredito = numerocuentacredito;
    }


    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
 


/*
package modelo;
import java.util.HashMap;
import java.util.Map;
import vista.Vista;

public class Factory {
    private  Vista vista;
    
    public Factory(Vista vista) {
        this.vista = vista;
    }
    private final Map<TipoDePago, ProcesoDePago> pagos = new HashMap<>(){{
        put(TipoDePago.APPLE_PLAY, new PagoApplePay(true,1500.0));
        put(TipoDePago.BIT_CION, new PagoBitCoin("0xABC123...", 300.0));
        put(TipoDePago.TRASFERENCIA, new PagoTrasferencia(1234567890, "Banco Ejemplo",8000.0));
        put(TipoDePago.EFECTIVO, new PagoEfectivo(30000.9));
        put(TipoDePago.GOOGLE_PAY, new PagoGooglePlay(true,1500.0));
        put(TipoDePago.PAYPAL, new PagoPayPal(vista.email.getText(),
                                                Integer.parseInt(vista.numidenti.getText()),
                                                vista.contra.getText(),
                                                1000.0 ));
        put(TipoDePago.TARJETA_CREDITO, new PagoTarjetaCredito(
                                                            Integer.parseInt(vista.tarjetaCreditonum.getText()),
                                                            Integer.parseInt(vista.cvc.getText()),
                                                            vista.fechaVenci.getText(),
                                                            5000.0));
        put(TipoDePago.TARJETA_DEBITO, new PagoTarjetaDebito(
                                                            Integer.parseInt(vista.tarjetaCreditonum.getText()),
                                                            Integer.parseInt(vista.cvc.getText()),
                                                            vista.fechaVenci.getText(),
                                                            2500.0));
    }};
    
    public ProcesoDePago obtenerPago(TipoDePago tipopago){
        return pagos.get(tipopago);
    }
}
*/
/*
public class Factory {
    public static ProcesoDePago crearPago(String metodo, Vista vista) {
        switch (metodo) {
            case "Tarjeta de Crédito":
                return new PagoTarjetaCredito(
                    Integer.parseInt(vista.tarjetaCreditonum.getText()),
                    Integer.parseInt(vista.cvc.getText()),
                    vista.fechaVenci.getText(),
                    5000.0 // saldo simulado, lo puedes cargar de DB
                );

            case "Tarjeta de Débito":
                return new PagoTarjetaDebito(
                    Integer.parseInt(vista.tarjetaCreditonum.getText()),
                    Integer.parseInt(vista.cvc.getText()),
                    vista.fechaVenci.getText(),
                    2500.0
                );

            case "Paypal":
                return new PagoPayPal(
                    vista.email.getText(),
                    Integer.parseInt(vista.numidenti.getText()),
                    vista.contra.getText(),
                    1000.0 
                );
                

            case "Transferencia":
                return new PagoTrasferencia(
                    1234567890, 
                    "Banco Ejemplo",
                    8000.0
                );

            case "Efectivo":
                return new PagoEfectivo(30000.0);

            case "Apple Pay":
                return new PagoApplePay(true,1500.0);

            case "Google Pay":
                return new PagoGooglePlay(true,2000.0);

            case "Bit Coin":
                return new PagoBitCoin("0xABC123...", 300.0);

            default:
                throw new IllegalArgumentException("Método de pago no soportado: " + metodo);
        }
    }
}
*/