
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
