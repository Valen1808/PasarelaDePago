package modelo;
import javax.swing.JOptionPane;

public class PagoBitCoin implements ProcesoDePago{
    public String direccionDestinatario;
    public double saldo;

    public PagoBitCoin(String direccionDestinatario, double saldo) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public PagoBitCoin() {}

    @Override
    public int pagar(double monto) {
        if(this.saldo>monto){
            JOptionPane.showMessageDialog(null, "Pago con Bit Coin exitoso");
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;  
        }
    }  
}

