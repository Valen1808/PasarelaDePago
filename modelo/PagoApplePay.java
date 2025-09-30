package modelo;
import javax.swing.JOptionPane;

public class PagoApplePay implements ProcesoDePago{
    private boolean confirmar;
    private double saldo;

    public PagoApplePay() {}

    public PagoApplePay(boolean confirmar, double saldo) {
        this.confirmar = confirmar;
        this.saldo = saldo;
    }

    public boolean getConfirmar() {
        return confirmar;
    }
    public void setConfirmar(boolean confirmar) {
        this.confirmar = confirmar;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public int pagar(double monto) {
        if(confirmar && this.saldo>monto){
            JOptionPane.showMessageDialog(null,"Pago procesado con ApplePay exitoso");
            return 1;
        }else{
            JOptionPane.showMessageDialog(null,"Error en la confirmación");
            return -1;  
        }
        
    }

    @Override
    public String factura() {
        return "METODO DE PAGO: ApplePay";
    }
    
    

}
