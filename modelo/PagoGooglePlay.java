package modelo;
import javax.swing.JOptionPane;

public class PagoGooglePlay implements ProcesoDePago{
    public boolean confirmación;
    public double saldo;

    public PagoGooglePlay(boolean confirmación, double saldo) {
        this.confirmación = confirmación;
        this.saldo = saldo;
    }

    public boolean getConfirmación() {
        return confirmación;
    }

    public void setConfirmación(boolean confirmación) {
        this.confirmación = confirmación;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    

    public PagoGooglePlay() {}
    
    @Override
    public int pagar(double monto) {
        if(confirmación){
            JOptionPane.showMessageDialog(null,"Pago procesado con GooglePlay exitoso");
        return 1;
        }else{
            JOptionPane.showMessageDialog(null,"Error en la confirmación");
            return -1;  
        } 
    }
}
