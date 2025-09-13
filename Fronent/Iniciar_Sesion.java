package Fronent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Iniciar_Sesion extends JFrame {

    private JPanel panelPrincipal;
    private JButton botonRegistrar;
    private JTextField campoContra, campoCorreo;
    private Container contenedor;
    private FlowLayout miflow;

    public Iniciar_Sesion() {
        // Título de la ventana
        setTitle("Iniciar Sesión");

        miflow = new FlowLayout();
        contenedor = getContentPane();
        contenedor.setLayout(miflow);

        // Panel principal con los campos
        panelPrincipal = new JPanel(new GridLayout(0, 1, 6, 5));

        // Campo Correo con borde-título
        campoCorreo = new JTextField(15);
        campoCorreo.setBorder(new TitledBorder("Correo electrónico"));

        // Campo Contraseña con borde-título
        campoContra = new JTextField(15);
        campoContra.setBorder(new TitledBorder("Contraseña"));

        // Botón
        botonRegistrar = new JButton("Iniciar Sesión");

        // Agregar al panel
        panelPrincipal.add(campoCorreo);
        panelPrincipal.add(campoContra);
        panelPrincipal.add(botonRegistrar);

        // Añadir al contenedor
        contenedor.add(panelPrincipal, BorderLayout.CENTER);

        // Validación frontend al presionar el botón
        botonRegistrar.addActionListener(e -> {
            String correo = campoCorreo.getText();
            String contra = campoContra.getText();

            if (!Validaciones.correoValido(correo)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Correo inválido");
                return;
            }

            if (!Validaciones.campoVacio(contra)) {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña");
                return;
            }

            javax.swing.JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso ✅");
        });
    }
}
