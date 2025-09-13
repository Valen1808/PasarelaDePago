package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Carrito;
import modelo.Producto;
import vista.Vista;
import modelo.CrudProductos;
import modelo.CrudCarrito;
import modelo.ProcesadorDePago;
import modelo.Factory;
import modelo.ProcesoDePago;
import modelo.TipoDePago;

public class Controlador implements ActionListener{
    public Vista vista=new Vista();
    CrudProductos p= new CrudProductos();
    Carrito c= new Carrito();
    CrudCarrito cc= new CrudCarrito();
    private Factory factory;
    private ProcesadorDePago procesador;
    
    DefaultTableModel modelo=new DefaultTableModel();
    DefaultTableModel modelo2=new DefaultTableModel();

    public Controlador(Vista v) {
        this.vista=v;
        vista.botonPago.addActionListener(this);
        this.factory = new Factory(); 
        this.procesador = new ProcesadorDePago();
        
        getListarProductos(vista.tabla);
        getListarCarrito(vista.carrito);
        agregarCarrito();
        eliminarProductoCarrito();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.botonPago && !vista.validarCampos()){
           //JOptionPane.showMessageDialog(null, "Vlidacion: "+vista.validarCampos());    
            
           boolean pagoExitoso= metodoDePago();
           //JOptionPane.showMessageDialog(null, "Pago exi "+pagoExitoso);
           if(carritoVacio()){
               JOptionPane.showMessageDialog(null, "Carrito vacio");
           }else{
            if(pagoExitoso){
                 double totalCompra = calcularTotal();
                 JOptionPane.showMessageDialog(null, Factura(totalCompra));
                 disminurCantidad();
                 cc.reiniciarCarrito(1);
                 limpiarCarrito();
                 getListarCarrito(vista.carrito);
                 limpiarProductos();
                 getListarProductos(vista.tabla);
             }
           }
            
            
        }
    }
    
    public void getListarProductos(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        List<Producto> lista = p.mostrar();
        Object[] object = new Object[4];

        for (int indice = 0; indice < lista.size(); indice++) {
            object[0] = lista.get(indice).getIdProducto();
            object[1] = lista.get(indice).getNombreDelProducto();
            object[2] = lista.get(indice).getPrecio();
            object[3] = lista.get(indice).getCantidad();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);
    }
    public void getListarCarrito(JTable tabla) {
        modelo2 = (DefaultTableModel) tabla.getModel();

        List<Carrito> lista = cc.mostrarCarrito();
        Object[] object = new Object[6];

        for (int indice = 0; indice < lista.size(); indice++) {
            object[0]=lista.get(indice).getId_usuario();
            object[1]=lista.get(indice).getId_producto();
            object[2] = lista.get(indice).getNombreproducto();
            object[3] = lista.get(indice).getPrecio();
            object[4] = lista.get(indice).getCantidad();
            object[5] = lista.get(indice).getPrecio()*lista.get(indice).getCantidad();
            modelo2.addRow(object);
        }
        vista.carrito.setModel(modelo2);
    }
    
    public void agregarCarrito() {
        vista.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2 ) {
                    int fila = vista.tabla.rowAtPoint(e.getPoint());
                    if (fila != -1) {
                        int id = Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString());
                        String nombreProducto = vista.tabla.getValueAt(fila, 1).toString();
                        double precio = Double.parseDouble(vista.tabla.getValueAt(fila, 2).toString());
                        //JOptionPane.showMessageDialog(null,"id p: " + id +"\nProducto: " + nombreProducto +"\nPrecio: " + precio +"\nCantidad: " + 1);
                            c.setId_usuario(1); 
                            c.setId_producto(id);
                            c.setCantidad(1);
                            c.setPrecio(precio);
                            cc.agregarProductos(c);
                        limpiarCarrito();
                        getListarCarrito(vista.carrito);
                    } else {
                        JOptionPane.showMessageDialog(null, "No seleccionaste ninguna fila");
                    }
                }
            }
        });
    }
    
    public void eliminarProductoCarrito(){
        vista.carrito.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                if(e.getClickCount()==2){
                    int fila = vista.carrito.rowAtPoint(e.getPoint());
                    if(fila!=-1){
                        int idpersona = Integer.parseInt(vista.carrito.getValueAt(fila, 0).toString());
                        int idproducto = Integer.parseInt(vista.carrito.getValueAt(fila, 1).toString());
                        cc.eliminarProducto(idpersona, idproducto);
                        limpiarCarrito();
                        getListarCarrito(vista.carrito);
                    }
                }
            }
        });
    }
    
    public void limpiarCarrito(){
        for(int i=0;i<vista.carrito.getRowCount();i++){
            modelo2.removeRow(i);
            i=i-1;
        }
    }
    public void limpiarProductos(){
        for(int i=0;i<vista.tabla.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    public int validarcantidad(int idProductoCarrito, int cantidad){
        int idProductoStock,cantidadStock;
        List<Producto> lista = p.mostrar();
        for (int indice = 0; indice < lista.size(); indice++) {
            idProductoStock=lista.get(indice).getIdProducto();
            cantidadStock=lista.get(indice).getCantidad();
            if(idProductoStock==idProductoCarrito){
                if(cantidad<=cantidadStock){
                    return cantidad;
                }else{
                    return cantidadStock;
                }
            }
        }
        return -1;
    }
    
    public String Factura(double precioTotal){
        String factura="FACTURA \n";
         List<Carrito> lista = cc.mostrarCarrito();
        Object[] object = new Object[6];

        for (int indice = 0; indice < lista.size(); indice++) {
            factura+="\nProducto: "+lista.get(indice).getNombreproducto();
            factura+="\nPrecio: "+lista.get(indice).getPrecio();
            factura+="\nCantidad: "+lista.get(indice).getCantidad();
            factura+="\nSub-total: " + lista.get(indice).getPrecio()*lista.get(indice).getCantidad();
            factura+="\n";
        }
        
        factura+="\n";
        factura+="\nPrecio Total: "+precioTotal;
        return factura;
    }
    
    public void disminurCantidad(){
        double totalCompra=0;
        int idProducto, cantidad, validacion;
        List<Carrito> carr = cc.mostrarCarrito();
        for (int indice = 0; indice < carr.size(); indice++) {
            idProducto=carr.get(indice).getId_producto();
            cantidad= carr.get(indice).getCantidad();
            validacion=validarcantidad(idProducto, cantidad);
            if(validacion==cantidad){
                p.setDismuirStock(idProducto, cantidad);
            }else{
                p.setDismuirStock(idProducto, validacion);
            }
        }
    }
    
    public double calcularTotal(){
        double totalCompra=0;
        int idProducto, cantidad, validacion;
        List<Carrito> carr = cc.mostrarCarrito();
        for (int indice = 0; indice < carr.size(); indice++) {
            idProducto=carr.get(indice).getId_producto();
            cantidad= carr.get(indice).getCantidad();
            validacion=validarcantidad(idProducto, cantidad);
            if(validacion==cantidad){
                totalCompra += carr.get(indice).getPrecio()*carr.get(indice).getCantidad();
            }else{
                totalCompra += carr.get(indice).getPrecio()*validacion;
                JOptionPane.showMessageDialog(null,"Cantidad insufiente, cantidad disponible"+ validacion );
            }
        }
        return totalCompra;
    }
    
    public boolean carritoVacio(){
        List<Carrito> lista = cc.mostrarCarrito();
        if(lista.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean metodoDePago() {
            String opcion = (String) vista.seleccionPago.getSelectedItem();
            double totalCompra = calcularTotal();
            //JOptionPane.showMessageDialog(null, "Seleccionaste: " + opcion);

            double saldo = saldo(); // saldo de la compra
            boolean pagoExitoso = false;

            switch (opcion) {
            case "Tarjeta de Crédito":
                String numeroTarjetaCredito = vista.tarjetaCreditonum.getText(); // numero de tarjeta
                int cvcC = Integer.parseInt(vista.cvc.getText()); // codigo CVV
                String fechaVencimientoC = vista.fechaVenci.getText(); // fecha de vencimiento

                factory.setNumerocuentacredito(numeroTarjetaCredito);
                factory.setCvc(cvcC);
                factory.setFechavencimiento(fechaVencimientoC);
                factory.setSaldo(saldo);

                ProcesoDePago pagoCredito = factory.obtenerPago(TipoDePago.TARJETA_CREDITO);

                if (pagoCredito.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }

                break;

            case "Tarjeta de Débito":
                String numeroTarjetaDebito = vista.tarjetaCreditonum.getText(); // numero de tarjeta
                int cvcD = Integer.parseInt(vista.cvc.getText()); // codigo CVV
                String fechaVencimientoD = vista.fechaVenci.getText(); // fecha de vencimiento

                factory.setNumerocuentadevito(numeroTarjetaDebito);
                factory.setCvc(cvcD);
                factory.setFechavencimiento(fechaVencimientoD);
                factory.setSaldo(saldo);

                ProcesoDePago pagoDebito = factory.obtenerPago(TipoDePago.TARJETA_DEBITO);
                
                if (pagoDebito.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            case "Efectivo":
                double totalRecibido = Double.parseDouble(vista.efectivo.getText()); // dinero recibido

                factory.setTotalrecibido(totalRecibido);

                ProcesoDePago pagoEfectivo = factory.obtenerPago(TipoDePago.EFECTIVO);
                if (pagoEfectivo.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            case "Paypal":
                String email = vista.email.getText(); // email
                int documento = Integer.parseInt(vista.numidenti.getText()); // documento
                String contrasena = vista.contra.getText(); // contraseña

                factory.setEmail(email);
                factory.setDocumento(documento);
                factory.setContrasena(contrasena);
                factory.setSaldo(saldo);

                ProcesoDePago pagoPaypal = factory.obtenerPago(TipoDePago.PAYPAL);
                if (pagoPaypal.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            case "Transferencia":
                String numeroCuenta = vista.numCuenta.getText(); // numero de cuenta
                String banco = vista.banco.getText(); // banco

                factory.setNumeroCuenta(numeroCuenta);
                factory.setBanco(banco);
                factory.setSaldo(saldo);

                ProcesoDePago pagoTransferencia = factory.obtenerPago(TipoDePago.TRASFERENCIA);
                if (pagoTransferencia.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            case "Apple Pay":
                boolean confirmacionApple = vista.appleConfirmado; // confirmacion Apple Pay

                factory.setConfirmacionApple(confirmacionApple);
                factory.setSaldo(saldo);

                ProcesoDePago pagoApple = factory.obtenerPago(TipoDePago.APPLE_PLAY);

                if (pagoApple.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            case "Google Pay":
                boolean confirmacionGoogle = vista.googleConfirmado; // confirmacion Google Pay

                factory.setConfirmacionGoogle(confirmacionGoogle);
                factory.setSaldo(saldo);

                ProcesoDePago pagoGoogle = factory.obtenerPago(TipoDePago.GOOGLE_PAY);
                if (pagoGoogle.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            case "Criptomonedas":
                String destinatario = vista.cripto.getText(); // direccion wallet

                factory.setDestinatario(destinatario);
                factory.setSaldo(saldo);

                ProcesoDePago pagoCripto = factory.obtenerPago(TipoDePago.BIT_CION);
                if (pagoCripto.pagar(totalCompra) == 1) {
                    pagoExitoso = true;
                }
                break;

            default:
                System.out.println("Opcion no valida");
        }
        return pagoExitoso;
    }

    
    public double saldo(){ 
        return 100099.09;
    }
}
