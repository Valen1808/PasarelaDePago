package modelo;
import javax.swing.JOptionPane;

public class PagoPayPal implements ProcesoDePago{
    private String correo;
    private String contrasena;
    private double saldo;
    private int documento;

    public PagoPayPal() {}

    public PagoPayPal(String correo, int documento,String contrasena, double saldo) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.documento= documento;
        this.saldo=saldo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    @Override
    public int pagar(double monto) {
        if(this.saldo>monto){
            JOptionPane.showMessageDialog(null, "Pago con PayPal esitoso");
            return 1;
        }else{
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
            return -1;
        }
    } 
}