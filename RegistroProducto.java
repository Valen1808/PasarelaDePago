package Fronent;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistroProducto extends JFrame {
    private JPanel panelPrincipal;
    private JButton botonRegistrar;
    private JTextField campoNombreProducto, campoIdProducto, campoPrecio, campoCanti;
    private Container contenedor;
    private FlowLayout miflow;

    public RegistroProducto() {
        miflow = new FlowLayout();
        contenedor = getContentPane();
        contenedor.setLayout(miflow);
        panelPrincipal = new JPanel(new GridLayout(0,2,2,2));
        
        
        

        
        JLabel etiquetaNombre = new JLabel("Nombre del Producto:");
        JLabel etiquetaId = new JLabel("ID del Producto:");
        JLabel etiquetaCanti = new JLabel("Cantidad de Productos:");
        JLabel etiquetaPrecio = new JLabel("Precio del Producto:");

        
        campoNombreProducto = new JTextField(10);
        campoIdProducto = new JTextField(10);
        campoCanti = new JTextField(10);
        campoPrecio = new JTextField(10);

        
        botonRegistrar = new JButton("Registrar");

        
        panelPrincipal.add(etiquetaNombre);
        panelPrincipal.add(campoNombreProducto);
        panelPrincipal.add(etiquetaId);
        panelPrincipal.add(campoIdProducto);
        panelPrincipal.add(etiquetaCanti);
        panelPrincipal.add(campoCanti);
        panelPrincipal.add(etiquetaPrecio);
        panelPrincipal.add(campoPrecio);

        
        panelPrincipal.add(new JLabel("")); 
        panelPrincipal.add(botonRegistrar);
        

        // Añadir al contenedor
        contenedor.add(panelPrincipal);
    }

  
}




