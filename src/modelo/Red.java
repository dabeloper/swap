/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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




public class Red {

    private String SO;
    private boolean estado = true;
    private int metrica_utilizada;
    private int metrica_principal;
    private Adaptador_Red adaptador_principal;
    private Adaptador_Red adaptador_utilizado;
    private LinkedList<Adaptador_Red> adapatadores = new LinkedList<>();
    
    public Red(Adaptador_Red adaptador_principal,String SO) {  
        this.adaptador_principal = adaptador_principal;
        metrica_principal = adaptador_principal.getMetrica();
        this.SO = SO;
 }
    
  public Red() {}
  
    public void Escoger(Adaptador_Red adaptador_a_utilizar,LinkedList<Adaptador_Red> adapatadores,boolean ping) {
        this.adapatadores = adapatadores;      
        this.adaptador_utilizado = adaptador_a_utilizar;
        this.metrica_utilizada = adaptador_a_utilizar.getMetrica();
        
        Iterator<Adaptador_Red> iterador_adapatadores ; 
        Adaptador_Red adapatador_get;
        
        try {
            Process p1;
            
              adapatadores.remove(adaptador_utilizado);
               p1 = Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adaptador_utilizado.getPuertaenlace()+" metric 1 if "+adaptador_utilizado.getIndice_metrica()); 
          
              iterador_adapatadores = adapatadores.iterator();
          
            while(iterador_adapatadores.hasNext())  
                {
                    adapatador_get = iterador_adapatadores .next();
                    Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adapatador_get.getPuertaenlace()+" metric "+(metrica_utilizada*2)+" if "+adapatador_get.getIndice_metrica());   
                }

     
                InputStreamReader is1 = new InputStreamReader(p1.getInputStream(), "UTF-8");
                BufferedReader bfr1 = new BufferedReader(is1);

                
                String s1;
                
                s1 = bfr1.readLine();
                
              if (! SO.equals("Windows XP")){
                 if(!" Correcto".equals(s1) && !s1.contains("OK")){
                    estado = false; 
                    JOptionPane.showMessageDialog(null, "Ejecutar de nuevo como Administrador \n Run again how Administrator","Error",-1);}
                }else{estado = true;}
            
            bfr1.close();    
            p1.destroy();  
            
     if(ping){       
      byte b = 1; 
      ping(b,null);}
        } catch (IOException | java.lang.NullPointerException ex) {
            System.out.println("Error en Balancear: \n"+ex.getMessage());
            if (! SO.equals("Windows XP")){
            JOptionPane.showMessageDialog(null, "Ejecutar de nuevo como Administrador \n Run again how Administrator","Error",-1);
            estado = false;}
        }

        
        
    }

    
    public void Deshacer(boolean ping){
        
        Iterator<Adaptador_Red> iterador_adapatadores ; 
        Adaptador_Red adapatador_get;
        
        try {  
            adaptador_principal.setMetrica(metrica_principal);
            adaptador_utilizado.setMetrica(metrica_utilizada);
            adapatadores.add(adaptador_utilizado);
            
          if ("Windows XP".equals(SO) || SO.contains("XP")){
             
           
           adapatadores.remove(adaptador_principal);
           Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adaptador_principal.getPuertaenlace()+" metric 1 if "+adaptador_principal.getIndice_metrica()); 
           
           iterador_adapatadores = adapatadores.iterator();
           
           while(iterador_adapatadores.hasNext())  
                {
                  adapatador_get = iterador_adapatadores .next();
                  Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adapatador_get.getPuertaenlace()+" metric 1 if "+adapatador_get.getIndice_metrica()); 
               }
  
           
           adapatadores.add(adaptador_principal);
          }else{

          iterador_adapatadores = adapatadores.iterator();
         
          while(iterador_adapatadores.hasNext())  
                {
              adapatador_get = iterador_adapatadores.next();
              Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adapatador_get.getPuertaenlace()+" metric 2 if "+adapatador_get.getIndice_metrica());
 
                }
           
          }
         
      Certificar_Principal(adapatadores); 
      
      if (ping){
      byte b = 1; 
      ping(b,null);}
        } catch (IOException | NullPointerException ex) {
            System.out.println("Error en Deshacer: \n"+ex.getMessage());
            System.exit(-1);
        }
    
    }
    
    
    public void Certificar_Principal(LinkedList<Adaptador_Red> adapatadores){
      
        try{  

            Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adaptador_principal.getPuertaenlace()+" metric 1 if "+adaptador_principal.getIndice_metrica());
      
              
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Ejecutar de nuevo como Administrador \n Run again how Administrator","Error",-1); 
           System.out.println("Error en Certificar_Principal: \n"+ex.getMessage());
           System.exit(1);
        }
    }
        
    
        public void Certificar_Secundario(Adaptador_Red adap_secu){
      
        try{  
            Runtime.getRuntime().exec("cmd.exe /c route change 0.0.0.0 mask 0.0.0.0 "+adap_secu.getPuertaenlace()+" metric 2 if "+adap_secu.getIndice_metrica());
      
              
      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Ejecutar de nuevo como Administrador \n Run again how Administrator","Error",-1);
          System.out.println("Error en Certificar_Principal: \n"+ex.getMessage());
          System.exit(1);
        }
    }
    
    public void Restaurar (boolean ping){
          try{
              
       if (adapatadores.size() > 0){       
       Runtime.getRuntime().exec("cmd.exe /c ipconfig /release");
       Runtime.getRuntime().exec("cmd.exe /c ipconfig /renew");
       }
       
    if (ping){   
      byte b = 1; 
      ping(b,null);}
        } catch (IOException ex) {
            System.out.println("Error en Restaurar: \n"+ex.getMessage());
        }
    }
    
    
    
    public boolean getEstado() {
        return estado;
    }

    public Adaptador_Red getAdaptador_principa() {
        return adaptador_principal;
    }

    public Adaptador_Red getAdaptador_utilizado() {
        return adaptador_utilizado;
    }


    public String ping(byte i,String hst){
    try{
     i++;   
     Process p ;
     if (hst == null){
     p =Runtime.getRuntime().exec("cmd.exe /c ping -w 1000 google.com");
     }else{
     p =Runtime.getRuntime().exec("cmd.exe /c ping -w 1000 "+hst);
     }
     
     InputStreamReader is1 = new InputStreamReader(p.getInputStream(), "UTF-8");
     BufferedReader bfr1 = new BufferedReader(is1);
    bfr1.readLine();
    
     String s=bfr1.readLine();
     if (bfr1.readLine() != null){
         if (s.indexOf("[") != -1){
         if( s.substring(s.indexOf("[")+1, s.indexOf("]")).length() > 5 ){
             return s.substring(s.indexOf("[")+1, s.indexOf("]"));
         }
         }
             return null;
     }else{
         p.destroy();
         if (i == 2){
         return null;
         }else{
         return ping(i,hst);}
     }
     
     
     } catch (Exception ex) {
            System.out.println("Error en ping: \n"+ex.getMessage());
            return null;
        }
        
        
        
    }

   
  public String tracert(String ip){
    try{
  
     Process p ;
     p =Runtime.getRuntime().exec("cmd.exe /c tracert -h 2 "+ip);

     
     InputStreamReader is1 = new InputStreamReader(p.getInputStream(), "UTF-8");
     BufferedReader bfr1 = new BufferedReader(is1);
    bfr1.readLine();
    
     String s;
     
     while ( (s=bfr1.readLine()) != null){
         if (s.indexOf("[") != -1){   
            return s.substring(s.indexOf("[")+1, s.indexOf("]"));   
         }
            
     }
     
     return null;
     
     } catch (Exception ex) {
            System.out.println("Error en ping: \n"+ex.getMessage());
            return null;
        }   
        
    }
        
}
