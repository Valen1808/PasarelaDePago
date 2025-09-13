package modelo;
import javax.swing.JOptionPane;

public class PagoEfectivo implements ProcesoDePago{
    private double billeteRecibido;

    public PagoEfectivo(double billeteRecibido) {
        this.billeteRecibido = billeteRecibido;
    }

    public PagoEfectivo() {}
    
    @Override
    public int pagar(double monto) {
        if(billeteRecibido>monto){
            double devuelta = billeteRecibido - monto;
            JOptionPane.showMessageDialog(null, "Total pagado: "+devuelta);
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;
        }
    }
}
