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
public class PagoPayPal implements Pagos{
    public String n;
    @Override
    public void crearPago() {
        JOptionPane.showMessageDialog(null, "Pafo por PayPal");
    }
    
}
