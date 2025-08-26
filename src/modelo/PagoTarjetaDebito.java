/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author norqu
 */
public class PagoTarjetaDebito implements Pagos{
    //numero tarjeta, cvv, fechadevencimiento
    //va a quedar en string la fecha temporalmente
   
    private int numeroTarjeta,cvv;
    private String fecha;
     public PagoTarjetaDebito(){};
    public PagoTarjetaDebito(int numeroTarjeta, int cvv, String fecha) {
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
    @Override
    public void crearPago() {
        JOptionPane.showMessageDialog(null, "Pago por tarjeta de debito");
    }
    
}
