
package modelo;

import javax.swing.JOptionPane;

public class PagoTrasferencia implements Pagos{
    private String nombreRemitente, banco, tipoCuenta, tipoDedocumento;
    private int numeroDocumento, numeroCuenta;
    private double monto;
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

    public void setMonto(double monto) {
        this.monto = monto;
    }
    public double getMonto() {
        return monto;
    }

    @Override
    public void crearPago() {
        JOptionPane.showMessageDialog(null, "Pago por Transferencia ");
    }
    
}
