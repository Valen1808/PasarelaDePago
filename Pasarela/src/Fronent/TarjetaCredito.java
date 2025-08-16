/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fronent;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class TarjetaCredito extends JFrame {

    private JPanel panelPrincipal;
    public JTextField campoTarjeta;
    public JTextField campoCvv;
    public JTextField campoFecha;
    public JButton botonPago;
    public FlowLayout flowLayout;
    private GridLayout gridLayout;
    public JCalendar calendarioVence;
    private Container contenedor;

    public TarjetaCredito() {
        super("Tarjeta de Credito");
        contenedor = getContentPane();
        contenedor.setLayout(gridLayout);
        
        //Panel
        panelPrincipal = new JPanel();
        
        

        //Flow
        flowLayout = new FlowLayout();
        gridLayout = new GridLayout();
        
        
        
        //Calendario 
        calendarioVence = new JCalendar();
         

        //Campos de texto
        campoTarjeta = new JTextField(20);
        campoCvv = new JTextField(3);
        campoFecha = new JTextField(6);
        
        //Boton
        botonPago = new JButton("Realizar Pago");
        

    }

}
