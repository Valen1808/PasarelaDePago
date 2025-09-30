package modelo;
import javax.swing.JOptionPane;

public class PagoEfectivo implements ProcesoDePago{
    private double billeteRecibido;
    private double devuelta=0;

    public PagoEfectivo(double billeteRecibido) {
        this.billeteRecibido = billeteRecibido;
    }

    public double getBilleteRecibido() {
        return billeteRecibido;
    }

    public PagoEfectivo() {}
    
    @Override
    public int pagar(double monto) {
        if(billeteRecibido>=monto){
            devuelta = billeteRecibido - monto;
            JOptionPane.showMessageDialog(null, "Total devuelta: "+devuelta);
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;
        }
    }
    @Override 
    public String factura(){
        return "METODO DE PAGO: Efectivo \n Monto:"+getBilleteRecibido()+"    Cambio"+devuelta;
    }
}
