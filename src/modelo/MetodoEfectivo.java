
package modelo;

import javax.swing.JOptionPane;

public class MetodoEfectivo implements ProcesoDePago{
    private double billeteRecibido;

    public MetodoEfectivo(double billeteRecibido) {
        this.billeteRecibido = billeteRecibido;
    }

    @Override
    public String pagar(double monto) {
        double devuelta = billeteRecibido - monto;
        JOptionPane.showMessageDialog(null, "Total pagado: "+devuelta);
        return "Devuelta: " + devuelta;
    }
}
