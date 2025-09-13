/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fronent;

/**
 *
 * @author usuario
 */
public class Validaciones {

    public static boolean campoVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

//    public static boolean campoNumerico(String valor) {
//        return valor.matches("\\d+");
//    }
    
    public static boolean campoNumerico(String valor) {
    return valor.matches("[0-9.,]*");
}


    public static boolean campoAlfabetico(String valor) {
        return valor.trim().matches("[A-Za-zÁÉÍÓÚáéíóú ]+");
    }

    public static boolean tarjeta(String tarjeta) {
        return tarjeta.matches("\\d{13,}");
    }

    public static boolean cvv(String cvv) {
        return cvv.matches("\\d{3}");
    }

    public static boolean paypal(String paypal) {
        return paypal.matches("\\\\d{13,}");
    }

    public static boolean correoValido(String texto) {
        return texto.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
    }

    public static boolean validarWalletBTC(String wallet) {
        return wallet.matches("^(1|3|bc1)[a-zA-Z0-9]{25,39}$");
    }

    public static boolean validarPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/]).{8,}$");

    }

}
