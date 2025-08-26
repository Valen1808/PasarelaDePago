
package modelo;

import javax.swing.JOptionPane;

public class PagoApplePay implements Pagos{
    private boolean confirmar;
    @Override
    public void crearPago(){
        JOptionPane.showMessageDialog(null,"Pago hecho con ApplePay");
        
    }
}
