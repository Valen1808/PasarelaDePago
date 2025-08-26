
package modelo;

import javax.swing.JOptionPane;

public class PagoTarjetaCredito implements Pagos{
    //numero tarjeta, cvv, fechadevencimiento
    //va a quedar en string la fecha temporalmente
   
    private int numeroTarjeta,cvv;
    private String fecha;
     public PagoTarjetaCredito(){};
    public PagoTarjetaCredito(int numeroTarjeta, int cvv, String fecha) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fecha = fecha;
    }
    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
    public int getCvv() {
        return cvv;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getFecha() {
        return fecha;
    }
    
    public void crearPago() {
        JOptionPane.showMessageDialog(null, "Pago por tarjeta de credito");
    }
   
}
