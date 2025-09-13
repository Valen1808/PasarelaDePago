/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Fronent;

import javax.swing.JFrame;
  
/**
 *
 * @author usuario
 */
public class index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //RegistroProducto view = new RegistroProducto(); 
        
          Vista view = new Vista();
        //Registrarse view = new Registrarse();
        
    //Iniciar_Sesion view = new Iniciar_Sesion();
        view.setVisible(true);
        view.setSize(526, 620);
        view.setLocation(300, 10);

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
