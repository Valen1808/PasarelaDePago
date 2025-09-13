package modelo;
import javax.swing.JOptionPane;

public class PagoTarjetaDebito implements ProcesoDePago{
    private int cvv;
    private String numeroTarjeta;
    private String fecha;
    private double saldo;
    
    public PagoTarjetaDebito(){};
    
    public PagoTarjetaDebito(String numeroTarjeta, int cvv, String fecha,double saldo ) {
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fecha = fecha;
        this.saldo = saldo;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    public String getNumeroTarjeta() {
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

    @Override
    public int pagar(double monto) {
        if(this.saldo>monto){
            JOptionPane.showMessageDialog(null, "Pago con Tarjeta de Debito esitoso");
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;
        }
    }
}
