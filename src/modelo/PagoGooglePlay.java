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
public class PagoGooglePlay implements Pagos{
    public boolean confirmación;
    @Override
    public void crearPago(){
        JOptionPane.showMessageDialog(null, "Pago por Google Play");
    }
}
