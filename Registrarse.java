package Fronent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrarse extends JFrame {

    private JPanel panelPrincipal;
    private JButton botonRegistrar;
    private JTextField campoNombre, campoId, campoApellido, campoCorreo, campoTipoDoc;
    private Container contenedor;
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
        campoTipoDoc = new JTextField(10);
        campoCorreo = new JTextField(10);

        botonRegistrar = new JButton("Registrar");

        panelPrincipal.add(etiquetaId);
        panelPrincipal.add(campoId);
        panelPrincipal.add(etiquetaCorreo);
        panelPrincipal.add(campoCorreo);
        panelPrincipal.add(etiquetaTipoDoc);
        panelPrincipal.add(campoTipoDoc);
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
