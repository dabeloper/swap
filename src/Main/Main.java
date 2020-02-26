/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Inicio;
import vista.Pantalla_Principal;


/**
 *
 * @author DABELOPER
 * 
 * 
 * @Licence Swap se encuentra bajo una Licencia Creative Commons Atribución-NoComercial-SinDerivadas 3.0 Unported.
 *
 * 
 *
 */



public class Main {


    public static void main(String[] args) {
  try{ 
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Pantalla_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inicio in = new Inicio();
        in.Inciar();
        Pantalla_Principal pp = new Pantalla_Principal(in);
        pp.setVisible(true);
      }catch( java.lang.NoClassDefFoundError ex){
        JOptionPane.showMessageDialog(null, "Error iniciando Swap: "+ex.getMessage());  
        System.exit(-1);}
    }


}