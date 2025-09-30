package modelo;
import javax.swing.JOptionPane;

public class PagoTrasferencia implements ProcesoDePago{
    private String nombreRemitente, banco, tipoCuenta, tipoDedocumento, numeroCuenta;
    private int numeroDocumento;
    private double saldo;

    /*
    public PagoTrasferencia(String nombreRemitente, String banco, String tipoCuenta, String tipoDedocumento, int numeroDocumento, int numeroCuenta, double saldo) {
        this.nombreRemitente = nombreRemitente;
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.tipoDedocumento = tipoDedocumento;
        this.numeroDocumento = numeroDocumento;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
*/
    
    public PagoTrasferencia( String numeroCuenta, String banco, double saldo) {
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.saldo=saldo;
    }

    public PagoTrasferencia() {
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }
    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
    public String getBanco() {
        return banco;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    
    public void setTipoDedocumento(String tipoDedocumento) {
        this.tipoDedocumento = tipoDedocumento;
    }
    public String getTipoDedocumento() {
        return tipoDedocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }   
    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setMonto(double saldo) {
        this.saldo = saldo;
    }
    public double getMonto() {
        return saldo;
    }

    @Override
    public int pagar(double monto) {
        if(this.saldo>monto){
            JOptionPane.showMessageDialog(null, "Pago con transferencia exitoso");
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;
        }
    }
    
    @Override
    public String factura() {
        return "METODO DE PAGO: Transferencia";
    }
    
}
