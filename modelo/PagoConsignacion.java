package modelo;
import javax.swing.JOptionPane;

public class PagoConsignacion implements ProcesoDePago{
    private String nombreRemitente, banco, tipoCuenta, tipoDedocumento;
    private int numeroDocumento, numeroCuenta;
    private double saldo;

    public PagoConsignacion(String nombreRemitente, String banco, String tipoCuenta, String tipoDedocumento, int numeroDocumento, double saldo) {
        this.nombreRemitente = nombreRemitente;
        this.banco = banco;
        this.tipoCuenta = tipoCuenta;
        this.tipoDedocumento = tipoDedocumento;
        this.numeroDocumento = numeroDocumento;
        this.saldo=saldo;
    }

    public PagoConsignacion() {}
    
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

    @Override
    public int pagar(double monto) {
        if(this.saldo>monto){
            JOptionPane.showMessageDialog(null, "Pago con Bit Coin exitoso");
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;
        }
        
    }
}