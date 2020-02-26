/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;

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

public class Red_Regla {


    public Red_Regla() {

    }
    
    
    public void Crear(LinkedList<Host> hosts){
        
        try {
           
        Iterator<Host> iterador_hosts = hosts.iterator();
       
        Host h;
        
            while(iterador_hosts .hasNext())  
                {
                    h = iterador_hosts .next();
                   if ( h.getEnlace() != null){
            
           if (h.getIPs().size() > 1)  { 
              for (int j=0; j< h.getIPs().size(); j++){             
                  Runtime.getRuntime().exec("cmd.exe /c route add "+h.getIPs().get(j)+" mask "+h.getMasks().get(j)+" "+h.getEnlace().getPuertaenlace()+" metric 1 if "+h.getEnlace().getIndice_metrica());
              }
           }else{
               Runtime.getRuntime().exec("cmd.exe /c route add "+h.getIPs().getFirst()+" mask "+h.getMasks().getFirst()+" "+h.getEnlace().getPuertaenlace()+" metric 1 if "+h.getEnlace().getIndice_metrica());
           }
          
          }
          }
            
            
     
        } catch (Exception ex) {
           System.gc();
            JOptionPane.showMessageDialog(null, "No se pudo crear la Regla para los hosts \n Rules not create","Swap",-1);
        }
    
    }
    
    
  public boolean verificar_adm(){
        try {
     Process p = Runtime.getRuntime().exec("cmd /c route add");
     BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                 String s= stdInput.readLine();
 
                 if (s == null){
                     return true;
                 }
                     
                     JOptionPane.showMessageDialog(null, "Ejecutar de nuevo como Administrador \n Run again how Administrator","Error",0);
                        return false;
                 
                 
        } catch (IOException | HeadlessException ex) {
            return false;
        }
      
  
  }
    
  
   public void Eliminar(LinkedList<Host> hosts){
 
        try {
          
        Iterator<Host> iterador_hosts = hosts.iterator();
       
        Host h;
        
            while(iterador_hosts .hasNext())  
                {
                    h = iterador_hosts .next();
                   if ( h.getEnlace() != null){
             
             if (h.getIPs().size() > 1)  {  
              for (int j=0; j< h.getIPs().size(); j++){
                 Runtime.getRuntime().exec("cmd.exe /c route delete "+h.getIPs().get(j));
              }}else{
                  Runtime.getRuntime().exec("cmd.exe /c route delete "+h.getIPs().getFirst());
             }
          
          }
          
          }
    
            
        } catch (Exception ex) {
           System.gc();
            
        }
    
    }
    
    
}
