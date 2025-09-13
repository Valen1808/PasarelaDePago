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
        botonRegistrar.addActionListener(e -> {
    String id = campoId.getText();
    String correo = campoCorreo.getText();
    String nombre = campoNombre.getText();
    String apellido = campoApellido.getText();

    if (!Validaciones.campoNumerico(id)) {
        javax.swing.JOptionPane.showMessageDialog(this, "El ID debe ser numérico y mínimo de 10 dígitos");
        return;
    }

    if (!Validaciones.correoValido(correo)) {
        javax.swing.JOptionPane.showMessageDialog(this, "Correo no válido");
        return;
    }

    if (!Validaciones.campoAlfabetico(nombre)) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras");
        return;
    }

    if (!Validaciones.campoAlfabetico(apellido)) {
        javax.swing.JOptionPane.showMessageDialog(this, "El apellido solo debe contener letras");
        return;
    }

    if (tipodoc.getSelectedIndex() == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento");
        return;
    }

    javax.swing.JOptionPane.showMessageDialog(this, "Registro exitoso ✅");
});

        
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




