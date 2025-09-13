package Fronent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrarse extends JFrame {

    private JPanel panelPrincipal;
    private JButton botonRegistrar;
    private JTextField campoNombre, campoId, campoApellido, campoCorreo, campoTipoDoc;
    private Container contenedor;
    private JComboBox tipodoc;
    private FlowLayout miflow;

    public Registrarse() {
        miflow = new FlowLayout();
        contenedor = getContentPane();
        contenedor.setLayout(miflow);
        panelPrincipal = new JPanel(new GridLayout(0, 2, 2, 2));

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("REGISTRARSE");
        titulo.setFont(new Font("Arial", Font.BOLD, 24)); // Tamaño grande
        panelTitulo.add(titulo);
        contenedor.add(panelTitulo, BorderLayout.NORTH);

        JLabel etiquetaId = new JLabel("Numero de identidad");
        JLabel etiquetaCorreo = new JLabel("Direccion de correo elecronico");
        JLabel etiquetaTipoDoc = new JLabel("Tipo de documento");
        JLabel etiquetaNombre = new JLabel("Nombre");
        JLabel etiquetaApellido = new JLabel("Apellido");

        campoNombre = new JTextField(10);
        campoId = new JTextField(10);
        campoApellido = new JTextField(10);
        tipodoc = new JComboBox<>(new String[]{"Selecciones el tipo de documento", "C.C", "Cedula de extranjeria"});
        campoCorreo = new JTextField(10);

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

        panelPrincipal.add(etiquetaId);
        panelPrincipal.add(campoId);
        panelPrincipal.add(etiquetaCorreo);
        panelPrincipal.add(campoCorreo);
        panelPrincipal.add(etiquetaTipoDoc);
        panelPrincipal.add(tipodoc);
        panelPrincipal.add(etiquetaNombre);
        panelPrincipal.add(campoNombre);
        panelPrincipal.add(etiquetaApellido);
        panelPrincipal.add(campoApellido);

        panelPrincipal.add(new JLabel(""));
        panelPrincipal.add(botonRegistrar);

        // Añadir al contenedor
        contenedor.add(panelPrincipal);
    }

}
