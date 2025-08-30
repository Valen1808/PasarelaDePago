package Fronent;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame {

    private JPanel panelPrincipal, panel2, panelBotones, panelPagos, panelTitulo2;
    private JScrollPane miScroll, miScroll2;
    private TitledBorder titulo, titulo2;
    public JButton botonPago;
    public JComboBox<String> seleccionPago;
    public DefaultTableModel modelo, modelo2;
    public JTable tabla, carrito;
    private Container contenedor;

    // Paneles para cada forma de pago
    private JPanel panelTarjeta, panelEfectivo, panelPaypal, panelTransferencia, panelApple, panelGoogle, panelCripto;

    public Vista() {
        super("Zona de pago");
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        // Panel principal para la tabla
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(2, 1));

        JPanel panelTitulo2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo2 = new JLabel("CARRITO DE COMPRAS");
        titulo2.setFont(new Font("Arial", Font.BOLD, 24));
        panelTitulo2.add(titulo2);
        
        

        modelo2 = new DefaultTableModel();
        modelo2.addColumn("Nombre del Producto");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("Total");

        carrito = new JTable(modelo2);
        titulo = new TitledBorder("Zonas de compras");

        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("PRODUCTOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 24)); // Tamaño grande
        panelTitulo.add(titulo);
        contenedor.add(panelTitulo, BorderLayout.NORTH);

        miScroll2 = new JScrollPane(carrito);
        miScroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        miScroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        miScroll2.setPreferredSize(new java.awt.Dimension(250, 150));

        modelo = new DefaultTableModel();
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Acciones");

        tabla = new JTable(modelo);
        miScroll = new JScrollPane(tabla);
        miScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        miScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        miScroll.setPreferredSize(new java.awt.Dimension(450, 250));

        panelPrincipal.add(miScroll);
        panelPrincipal.add(miScroll2);

        // Panel para botones
        panelBotones = new JPanel(new FlowLayout());

        seleccionPago = new JComboBox<>(new String[]{
            "Seleccione método de pago",
            "Tarjeta de Crédito",
            "Tarjeta de Débito",
            "Efectivo",
            "Paypal",
            "Transferencia",
            "Apple Pay",
            "Google Pay",
            "Criptomonedas"
        });

        botonPago = new JButton("Pagar");

        panelBotones.add(seleccionPago);
        panelBotones.add(botonPago);

        // Panel dinámico con CardLayout para las interfaces de pago
        panelPagos = new JPanel(new CardLayout());

        crearInterfacesPago();

        // Evento del ComboBox → cambiar interfaz según selección
        seleccionPago.addActionListener(e -> {
            String opcion = (String) seleccionPago.getSelectedItem();
            CardLayout cl = (CardLayout) panelPagos.getLayout();
            if (opcion != null) {
                switch (opcion) {
                    case "Tarjeta de Crédito":
                    case "Tarjeta de Débito":
                        cl.show(panelPagos, "Tarjeta");
                        break;
                    case "Efectivo":
                        cl.show(panelPagos, "Efectivo");
                        break;
                    case "Paypal":
                        cl.show(panelPagos, "Paypal");
                    case "Transferencia":
                        cl.show(panelPagos, "Transferencia");
                        break;
                    case "Apple Pay":
                        cl.show(panelPagos, "Apple");
                        break;
                    case "Google Pay":
                        cl.show(panelPagos, "Google");
                        break;
                    case "Criptomonedas":
                        cl.show(panelPagos, "Cripto");
                        break;
                    default:
                        cl.show(panelPagos, "Vacio");
                }
            }

        });

        // Agregamos todo al contenedor
        contenedor.add(panelPrincipal);
        contenedor.add(panelBotones);
        contenedor.add(panelPagos);

    }

    private void crearInterfacesPago() {
        // Panel vacío inicial
        JPanel panelVacio = new JPanel();
        panelVacio.add(new JLabel(""));

        // Panel para Tarjeta (Crédito/Débito)
        panelTarjeta = new JPanel(new GridLayout(3, 2));
        panelTarjeta.add(new JLabel("Número de Tarjeta:"));
        panelTarjeta.add(new JTextField(16));
        panelTarjeta.add(new JLabel("CVV:"));
        panelTarjeta.add(new JTextField(4));
        panelTarjeta.add(new JLabel("Fecha de Vencimiento:"));
        panelTarjeta.add(new JTextField(5));

        // Panel para Efectivo
        panelEfectivo = new JPanel();
        panelEfectivo.add(new JLabel("El pago se realizará en efectivo al momento de la entrega."));

        panelPaypal = new JPanel(new GridLayout(3, 1));
        panelPaypal.add(new JLabel("Ingrese la direccion de email"));
        panelPaypal.add(new JLabel("Ingrese numero de identidad"));
        panelPaypal.add(new JLabel("Ingrese la contraseña"));

        // Panel para Transferencia
        panelTransferencia = new JPanel(new GridLayout(2, 1));
        panelTransferencia.add(new JLabel("Ingrese el numero de la cuenta"));
        panelTransferencia.add(new JTextField());
        panelTransferencia.add(new JLabel("Ingrese el banco"));
        panelTransferencia.add(new JTextField());
        // Panel para Apple Pay
        panelApple = new JPanel();
        panelApple.add(new JLabel("Conectando con Apple Pay..."));

        // Panel para Google Pay
        panelGoogle = new JPanel();
        panelGoogle.add(new JLabel("Conectando con Google Pay..."));

        // Panel para Criptomonedas
        panelCripto = new JPanel(new GridLayout(2, 1));
        panelCripto.add(new JLabel("Dirección de Wallet:"));
        panelCripto.add(new JTextField(25));

        // Añadir todos los paneles al CardLayout
        panelPagos.add(panelVacio, "Vacio");
        panelPagos.add(panelTarjeta, "Tarjeta");
        panelPagos.add(panelEfectivo, "Efectivo");
        panelPagos.add(panelPaypal, "Paypal");
        panelPagos.add(panelTransferencia, "Transferencia");
        panelPagos.add(panelApple, "Apple");
        panelPagos.add(panelGoogle, "Google");
        panelPagos.add(panelCripto, "Cripto");
    }

    public void crearInterfazPagoTotal() {

    }

}
