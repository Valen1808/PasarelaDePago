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
public class PagoEfectivo implements Pagos{
    public double billeteRecibido;
    public double valorDeLaCompra;
    public double devuelta;

    public PagoEfectivo() {
        
    }

    public PagoEfectivo(double billeteRecibido) {
        this.billeteRecibido = billeteRecibido;
        crearPago();
    }

    public void setBilleteRecibido(double billeteRecibido) {
        this.billeteRecibido = billeteRecibido;
    }
    public double getBilleteRecibido() {
        return billeteRecibido;
    }
    @Override
    public void crearPago() {
        System.out.println("valor recibido: "+getBilleteRecibido());
    }
}
