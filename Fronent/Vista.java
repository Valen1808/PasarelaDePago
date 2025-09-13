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
import Fronent.Validaciones;
import javax.swing.text.JTextComponent;

public class Vista extends JFrame {

    private JPanel panelPrincipal, panel2, panelBotones, panelPagos, panelTitulo2;
    private JScrollPane miScroll, miScroll2;
    private TitledBorder titulo, titulo2;
    public JTextField tarjetaDebito, paypal, efectivo, trasnferencia, cripto, banco, numCuenta;
    public JTextField tarjetaCreditonum, cvc, email, numidenti, fechaVenci, contra;
    public JButton botonPago, botonApple, botonGoogle;
    public JComboBox<String> seleccionPago;
    public DefaultTableModel modelo, modelo2;
    public JTable tabla, carrito;
    private Container contenedor;
    private boolean appleConfirmado = false;
    private boolean googleConfirmado = false;

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

        modelo2 = new DefaultTableModel();
        modelo2.addColumn("Id Usuario");
        modelo2.addColumn("Id producto");
        modelo2.addColumn("Nombre del Producto");
        modelo2.addColumn("Precio");
        modelo2.addColumn("Cantidad");
        modelo2.addColumn("SubTotal");

        carrito = new JTable(modelo2);
        titulo = new TitledBorder("Zonas de compras");
        carrito = new JTable(modelo2);
        carrito.getColumnModel().getColumn(0).setMinWidth(0);
        carrito.getColumnModel().getColumn(0).setMaxWidth(0);
        carrito.getColumnModel().getColumn(0).setWidth(0);
        carrito.setEnabled(false);
        carrito.getColumnModel().getColumn(1).setMinWidth(0);
        carrito.getColumnModel().getColumn(1).setMaxWidth(0);
        carrito.getColumnModel().getColumn(1).setWidth(0);
        carrito.setEnabled(false);

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

        modelo.addColumn("id Producto");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");

        tabla = new JTable(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.setEnabled(false);

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

        botonPago.addActionListener(e -> {
            String opcion = (String) seleccionPago.getSelectedItem();

            if (opcion == null || opcion.equals("Seleccione método de pago")) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un método de pago");
                return;
            }

            switch (opcion) {
                case "Tarjeta de Crédito":
                case "Tarjeta de Débito":
                    if (!Validaciones.tarjeta(tarjetaCreditonum.getText())) {
                        JOptionPane.showMessageDialog(this, "Número de tarjeta inválido (13 dígitos requeridos)");
                        return;
                    }
                    if (!Validaciones.campoNumerico(cvc.getText())) {
                        JOptionPane.showMessageDialog(this, "El CVV debe ser numérico");
                        return;
                    }

                    //JOptionPane.showMessageDialog(this, "Pago con tarjeta exitoso ✅");
                    if (!Validaciones.cvv(cvc.getText())) {
                        JOptionPane.showMessageDialog(this, "El CVV solo debe contener tres digitos");
                        return;
                    }

                    if (!Validaciones.campoNumerico(cvc.getText())) {
                        JOptionPane.showMessageDialog(this, "El CVV solo debe contener numeros");
                        return;
                    }
                    break;

                case "Paypal":
                    if (!Validaciones.correoValido(email.getText())) {
                        JOptionPane.showMessageDialog(this, "Correo inválido");
                        return;
                    }
                    if (!Validaciones.campoNumerico(numidenti.getText())) {
                        JOptionPane.showMessageDialog(this, "Número de identidad inválido");
                        return;
                    }
                    if (Validaciones.campoVacio(contra.getText())) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar la contraseña");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Pago con Paypal exitoso ✅");
                    break;

                case "Transferencia":
                    if (Validaciones.campoVacio(numCuenta.getText()) || Validaciones.campoVacio(banco.getText())) {
                        JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
                        return;
                    }
                    if (!Validaciones.campoAlfabetico(banco.getText().trim())) {
                        JOptionPane.showMessageDialog(this, "El campo banco no acepta números");
                        return;
                    }

                    if (!Validaciones.campoNumerico(numCuenta.getText())) {
                        JOptionPane.showMessageDialog(this, "El número de cuenta solo puede contener dígitos");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Transferencia realizada ✅");
                    break;

                case "Efectivo":
                    if (!Validaciones.campoNumerico(efectivo.getText())) {
                        JOptionPane.showMessageDialog(this, "El campo solo es numerico");
                        return;
                    }

                    if (Validaciones.campoVacio(efectivo.getText())) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar el monto");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Pago en efectivo registrado ✅");
                    break;

                case "Apple Pay":

                    if (!appleConfirmado) {
                        JOptionPane.showMessageDialog(this, "Debe confirmar en Apple Pay antes de pagar");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Pago con Apple Pay exitoso ✅");
                    }

                    break;

                case "Google Pay":
                    if (!googleConfirmado) {
                        JOptionPane.showMessageDialog(this, "Debe confirmar en Google Pay antes de pagar");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(this, "Pago con Google Pay exitoso ✅");

                    }

                    break;

                case "Criptomonedas":
                    if (!Validaciones.validarWalletBTC(cripto.getText())) {
                        JOptionPane.showMessageDialog(this, "Ingrese una direccion valida");
                    }
                    if (!Validaciones.campoVacio(cripto.getText())) {
                        JOptionPane.showMessageDialog(this, "Debe ingresar una direccion");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Pago con criptomonedas exitoso ✅");
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "Opción no válida");
            }
        });

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
                        break;
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
        panelTarjeta = new JPanel(new GridLayout(0, 2, 2, 0));
        //panelTarjeta.add(new JLabel("Número de Tarjeta:"));
        JLabel etiquetaTarjeta = new JLabel("Numero de tarjeta");

        tarjetaCreditonum = new JTextField(10);
        JLabel etiquetacvc = new JLabel("CVV");
        cvc = new JTextField(3);
        //panelTarjeta.add(new JLabel("CVV:"));

        JLabel etiquetaFecha = new JLabel("Fecha de Vencimiento");
        fechaVenci = new JTextField();

        panelTarjeta.add(etiquetaTarjeta);
        panelTarjeta.add(tarjetaCreditonum);
        panelTarjeta.add(etiquetacvc);
        panelTarjeta.add(cvc);
        panelTarjeta.add(etiquetaFecha);
        panelTarjeta.add(fechaVenci);

        // Panel para Efectivo
        //panelEfectivo = new JPanel(new GridLayout(3, 1));
        //panelEfectivo = new JPanel();
        // JLabel etiquetaEfectivo = new JLabel("El monto es");
        //efectivo = new JTextField();
        // panelEfectivo.add(etiquetaEfectivo);
        // panelEfectivo.add(efectivo);
        panelEfectivo = new JPanel(new GridLayout(2, 1));

        JLabel etiquetaEfectivo = new JLabel("Monto a pagar");
        efectivo = new JTextField();

        panelEfectivo.add(etiquetaEfectivo);
        panelEfectivo.add(efectivo);

        panelPaypal = new JPanel(new GridLayout(3, 1));

        JLabel etiquetaEmail = new JLabel("Ingrese la direccion de email");
        email = new JTextField();
        JLabel etiquetaIdenti = new JLabel("Ingrese el numero de identidad");
        numidenti = new JTextField();
        JLabel etiquetaContra = new JLabel("Ingrese la contraseña");
        contra = new JTextField();

        panelPaypal.add(etiquetaEmail);
        panelPaypal.add(email);
        panelPaypal.add(etiquetaIdenti);
        panelPaypal.add(numidenti);
        panelPaypal.add(etiquetaContra);
        panelPaypal.add(contra);

        // Panel para Transferencia
        panelTransferencia = new JPanel(new GridLayout(2, 1));

        JLabel etiquetaTran = new JLabel("Ingrese el numero de la cuenta");
        numCuenta = new JTextField();
        JLabel etiquetaBnaco = new JLabel("Ingrese el banco");
        banco = new JTextField();

        panelTransferencia.add(etiquetaTran);
        panelTransferencia.add(numCuenta);
        panelTransferencia.add(etiquetaBnaco);
        panelTransferencia.add(banco);

        // Panel para Apple Pay
        panelApple = new JPanel();
        panelApple.add(new JLabel("Conectando con Apple Pay..."));
        JButton botonApple = new JButton("Confirmar Pago");
        panelApple.add(botonApple);
        botonApple.addActionListener(e -> {
            appleConfirmado = true;
            JOptionPane.showMessageDialog(this, "Apple Pay confirmado, ahora puede presionar 'Pagar'");

        });

        // Panel para Google Pay
        panelGoogle = new JPanel();
        panelGoogle.add(new JLabel("Conectando con Google Pay..."));

        JButton botonGoogle = new JButton("Confirmar Pago");
        panelGoogle.add(botonGoogle);

        botonGoogle.addActionListener(e -> {
            googleConfirmado = true;
            JOptionPane.showMessageDialog(this, "Google Pay confirmado, ahora puede presionar 'Pagar'");

            googleConfirmado = false;
        });

        // Panel para Criptomonedas
        panelCripto = new JPanel(new GridLayout(2, 1));

        JLabel etiquetaCriptp = new JLabel("Dirección de Wallet:");
        cripto = new JTextField();

        panelCripto.add(etiquetaCriptp);
        panelCripto.add(cripto);

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
