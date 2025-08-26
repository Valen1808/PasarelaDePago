package modelo;

import javax.swing.JOptionPane;

public class MetodoDebito implements ProcesoDePago{
    private double saldoDisponible;
    private int numeroTarjeta,cvv;
    private String fecha;
    
    public MetodoDebito(int numeroTarjeta, int cvv, String fecha,double saldoDisponible) {
        
        this.numeroTarjeta = numeroTarjeta;
        this.cvv = cvv;
        this.fecha = fecha;
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String pagar(double monto) {
        if (monto <= saldoDisponible) {
            saldoDisponible-= monto;
            JOptionPane.showMessageDialog(null, "Pago procesado con Débito. Saldo: " + saldoDisponible);
        
        }
        return null;
    }   
}
