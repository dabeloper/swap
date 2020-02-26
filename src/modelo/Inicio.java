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
import java.util.Objects;
import javax.swing.JOptionPane;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;



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





public class Inicio {



private String encod=null,Path,SO,Leng,adaptador,descripcion,dir_fisica,ethernet,inalambrica,puerta_enl_pdt,ipv4; 
private LinkedList<Adaptador_Red> adaptadores = new LinkedList<>();
private Adaptador_Red adaptador_principal = null;


private boolean primer_inicio = true;


           
           
  public void Inciar() {
      if (encod == null){
            SO = System.getProperty("os.name");
            String pts = "";
            java.io.File temp = null; 
          try {
              
              temp = File.createTempFile("temp-file-name", ".tmp");
    		pts = temp.getCanonicalPath();
            } catch (IOException ex) {
              Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
          }
             Path = pts.substring(0, pts.lastIndexOf("\\"));

            
            if (SO.equals("Windows XP") || SO.contains("XP")){
                encod = "windows-1252";
            }else{
                encod = "CP850";
            }
            Leng = System.getProperty("user.language");
            Seleccionar_Variables();}
            UP();
                     
  }
  
  
    
  public void UP(){
    try { 
        if (SO.equals("Windows XP") || SO.contains("XP")){
                        ipv4 = "IP";
                    }
     

        
     Process p = Runtime.getRuntime().exec("cmd /c ipconfig /all");
     BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream(),encod));
     


      String nombreadap = "";
      String descripcion_adap = "";
      String mac_address = "";
      String s;
      String ip = "";
      String puerta_enlacepd = "";

     while ((s = stdInput.readLine()) != null) {
          
           if (s.contains(adaptador) && !s.contains(descripcion)){
            descripcion_adap = "";
            mac_address = "";
            ip = "";
            puerta_enlacepd = "";
            nombreadap = s.replace(':', ' ');}

            if ( (stdInput.read()!=-1) && !"".equals(nombreadap.trim())){
                
                         if (s.contains(descripcion)){               
                              descripcion_adap = s.substring(15).replace('.', ' ').replace(':', ' '); 
                        }
                         
                         if (s.contains(dir_fisica)){      
                              mac_address = s.substring(25).replace('.', ' ').replace(':', ' ');
                        }
                         
  
                       if (s.contains(ipv4)){              

                        
                         
                         ip = s.substring(s.indexOf(":")+1, s.length());
                         
                                 if (ip.contains("(")){
                                 ip = s.substring(s.indexOf(":")+1, s.length()-12);
                                 }

                       }
                       
                         if (s.contains(puerta_enl_pdt)){
                          
                      
                                 puerta_enlacepd = s.substring(s.indexOf(":")+1, s.length()); 

                          
                          if (!puerta_enlacepd.trim().equals("") ){
                              int ind;
                          
                          if (nombreadap.contains(ethernet) && nombreadap.contains(inalambrica)){
                          
                              if (nombreadap.indexOf(ethernet) < nombreadap.indexOf(inalambrica)){
                              ind = nombreadap.indexOf(ethernet);
                              }else{
                              ind = nombreadap.indexOf(inalambrica);
                              }
                          }else{
                              if (nombreadap.contains(ethernet)){
                              ind = nombreadap.indexOf(ethernet);
                              }else{
                              ind = nombreadap.indexOf(inalambrica);
                              }
                          }
                          
                          nombreadap = nombreadap.substring(ind+6,nombreadap.length());    
                          
                           
                          mac_address = mac_address.toLowerCase();
                          
                          if ((!"".equals(nombreadap)) && (!"".equals(descripcion_adap)) && (!"".equals(mac_address)) && (!"".equals(ip)) && (!"".equals(puerta_enlacepd))){
                          Adaptador_Red adap = new Adaptador_Red(nombreadap.trim(),ip.trim(),puerta_enlacepd.trim(),descripcion_adap.trim(),mac_address.trim().replace('-', ' '));
                          
                          if (!Contains_(adap)){
                          adaptadores.add(adap);}
                                                   
                           nombreadap = "";
                           descripcion_adap = "";
                           mac_address = "";
                           ip = "";
                           puerta_enlacepd = "";}
                          }
                          
                       }
                }
    
      }
      
      stdInput.close();
      p.destroy();
  
    //Destruccion de Objetos  
       p = null; 
       nombreadap = null;
       descripcion_adap = null;
       mac_address = null;
       s = null;
       ip = null;
       puerta_enlacepd = null;
      
      
      
     if (adaptadores.size() > 0){
         
         
     Process route = Runtime.getRuntime().exec("cmd /c route print");
     InputStreamReader isr = new InputStreamReader(route.getInputStream(),encod);
     BufferedReader bfr = new BufferedReader(isr);
    
     String ip_predeterminada = null;
     String ts;
     boolean principal = true;
     Iterator<Adaptador_Red> iterador_adaptador ;
     Adaptador_Red adap_get;
     
          while ((ts = bfr.readLine()) != null ){
              iterador_adaptador = adaptadores.iterator();
              
          while(iterador_adaptador .hasNext())  
                {
                    adap_get = iterador_adaptador.next();
               
                if( adap_get.getIndice_metrica() == null ){
                    if (ts.contains(adap_get.getMAC())){
                        
                        adap_get.setIndice_metrica(ts.substring(0, ts.indexOf(".")).trim());
                        
                    }
                }
                  
                 if ( ts.contains(adap_get.getPuertaenlace())  && 
                            ts.contains("0.0.0.0") && 
                                ts.contains(adap_get.getIP())){
                    if ( principal ){
                        
                        adap_get.setPrincipal(principal);
                        principal = false;
                    } 
                       String metrica = ts.substring( (ts.length()-4), (ts.length()));
                       System.out.println(ts);
               try{
                       adap_get.setMetrica(Integer.parseInt(metrica.trim()));
                       
               }catch(java.lang.NumberFormatException ex){
                   adap_get.setMetrica(3);
               }
                       
                    }
   
                 
                  if (SO.equals("Windows XP") && ts.contains(puerta_enl_pdt)){
  
                      ip_predeterminada = ts.substring(ts.indexOf(":") + 1, ts.length());
                      
                  }
                 
           }
           
      }
      route.destroy();    
       bfr.close();
       
       
       
       ts = null;
       route = null;
       bfr = null;
       Adaptador_Red adaptador_principal_temporal = null ;
    
                     
       
       
     iterador_adaptador = adaptadores.iterator();
     adap_get = null;
     

       
          while(iterador_adaptador .hasNext())  
        {  
            adap_get = iterador_adaptador.next();
          if (adap_get.isPrincipal() ){   
              adaptador_principal = adap_get;
              adaptador_principal_temporal = adap_get;
              break;      
          }
         }
          

          
      
      
    if (SO.equals("Windows XP") || SO.contains("XP")){
       Buscar_principal(ip_predeterminada,adaptador_principal_temporal);

    }
    else{
     Iterator<Adaptador_Red> iterador_adaptador_ = adaptadores.iterator();
     adap_get = null;
       
       
          while(iterador_adaptador_.hasNext())  
        {
            adap_get = iterador_adaptador_.next();
            
            if(adaptador_principal != adap_get){
                       
                     if (adaptador_principal.getMetrica() != adap_get.getMetrica())  {
                                if (adaptador_principal.getMetrica() > adap_get.getMetrica()){
                                    adaptador_principal.setPrincipal(false);
                                    adaptador_principal = adap_get;
                                    adaptador_principal.setPrincipal(true);}
                             }else{
                     
                             if (adaptador_principal.getMetrica() == adap_get.getMetrica())  {
                                 
                                 String res,iptp = adaptador_principal.getPuertaenlace();
                                 iptp = iptp.substring(0 , iptp.lastIndexOf(".") );
                                 Red rtp = new Red();
                                 res = rtp.tracert(iptp+".0");
                                 
                                 
                                if (res.equals(adap_get.getIP())){
                                    
                                    rtp.Certificar_Secundario(adaptador_principal);
                                    adaptador_principal.setMetrica((adaptador_principal.getMetrica()+2));
                                    
                                    adaptador_principal.setPrincipal(false);
                                    adaptador_principal = adap_get;
                                    adaptador_principal.setPrincipal(true);
                                    

                                }else{
                                    rtp.Certificar_Secundario(adap_get);
                                }

                             }
                         
                            }
                   }       
          }       
        }
        
      
   if (primer_inicio){
    primer_inicio = false;
    
    Red er = new Red(adaptador_principal, SO);
    er.Certificar_Principal(adaptadores);

    
    er = null;
    }

   verificar_final();
   }
    }catch (Exception ex) {
      System.out.println(ex.getClass()+" Error en inciar UP() : "+ex.getMessage() +":"+ ex.toString());
      if (adaptadores.size() > 0){
          verificar_final();
          this.UP();
          return;}
      
      
        if(!SO.equals("Windows XP") || !SO.contains("XP"))
        {if ("es".equals(Leng) ){
            JOptionPane.showMessageDialog(null, "Ejecutar de nuevo como administrador","Swap",-1);
          }else{
            JOptionPane.showMessageDialog(null, "Run again how Administrator","Swap",-1);
          }}
        
                    System.exit(-1);
        }
  
  // Recolector de basura para limpiar la memoria  
  //  System.gc();
  }

  
  private void verificar_final(){
  
     Iterator<Adaptador_Red> iterador_adaptador = adaptadores.iterator();
     Adaptador_Red adap_get = null;
       
       
     while(iterador_adaptador .hasNext())  
        {  
            adap_get = iterador_adaptador.next();
    
        if (adap_get.getPuertaenlace().length() > 16){
          int opcion;  
            if ("es".equals(Leng) ){
           opcion = JOptionPane.showConfirmDialog(null, "Ops!! Swap encontro una falla en su sistema \n Verifica la conexion a Internet \n ¿Desea tratar de Corregirlo? ","Ops!!",-1,JOptionPane.OK_CANCEL_OPTION);
          }else{
           opcion = JOptionPane.showConfirmDialog(null, "Ops!! Swap Found a Bug in your system \n Check your Internet connection \n Do you want to try to correct it?","Ops!!",-1,JOptionPane.OK_CANCEL_OPTION);
          }
            
            if (opcion == 0){
                    try {
                        Runtime.getRuntime().exec("cmd.exe /c ipconfig /release");
                        Runtime.getRuntime().exec("cmd.exe /c ipconfig /renew");
                    } catch (IOException ex) {
                       JOptionPane.showMessageDialog(null, "Error!! \nEjecutar de nuevo como administrador","Swap",-1);
                       System.exit(-1);
                    }
                    JOptionPane.showMessageDialog(null, "Listo!! \nEjecutar de nuevo como administrador","Swap",0);
            }
            
           
           System.exit(-1);
        }
                
    }
  
  }
  
    public LinkedList<Adaptador_Red> getAdaptadores() {
        return adaptadores;
    }

    public Adaptador_Red getAdaptador_principal() {
        return adaptador_principal;
    }

    
    
    
    public boolean BuscarAdaptador(String mac){
      
     Iterator<Adaptador_Red> iterador_adaptador = this.getAdaptadores().iterator();
     Adaptador_Red adap_get ;
       
       
     while(iterador_adaptador .hasNext())  
        {  
            adap_get = iterador_adaptador.next();   
           if (adap_get.getMAC().equals(mac)){
               return true;} 
           }

      return false;  
    }
    
    public Adaptador_Red ObtenerAdaptador(String nombre){
     Iterator<Adaptador_Red> iterador_adaptador = this.getAdaptadores().iterator();
     Adaptador_Red adap_get ;
       
       
     while(iterador_adaptador.hasNext())  
        {  
            adap_get = iterador_adaptador.next();  
               if (adap_get.getNombre().equals(nombre)){
               return adap_get;}
         }
      return null;
      
    }
    
    
    public String getLeng() {
        return Leng;
    }

    public String getSO() {
        return SO;
    }

    public String getPath() {
        return Path;
    }
  
    
    
    public void Reiniciar(){
      if (!SO.equals("Windows XP") || !SO.contains("XP")){  
        primer_inicio = true;}
      
        adaptador_principal = null; 
        this.adaptadores.removeAll(adaptadores);       
        this.Inciar();
    }
      
    
    private boolean Contains_ (Adaptador_Red adap_){
    
       if (adaptadores.size() > 0){ 
           
     Iterator<Adaptador_Red> iterador_adaptador = adaptadores.iterator();
     Adaptador_Red adap_get ;
       
       
     while(iterador_adaptador.hasNext())  
        {  
                adap_get = iterador_adaptador.next();
            
                    if (adap_get.getMAC().equals(adap_.getMAC()) ){
                         if (adap_.isPrincipal()){
                             adap_get.setPrincipal(true);
                         }
                         return true;
                    }
               }
            }
            
           return false;
    }
  
    
    private void Buscar_principal(String ip_predeterminada,Adaptador_Red adaptador_principal_temporal){
      ip_predeterminada = ip_predeterminada.trim();
   
     Iterator<Adaptador_Red> iterador_adaptador;
     Adaptador_Red adap_get ;
      
    if (adaptadores.size() > 0 ){
        
    
    if( !(adaptador_principal.getPuertaenlace().equals(ip_predeterminada)) ){
 
        iterador_adaptador = adaptadores.iterator();
        
             while(iterador_adaptador.hasNext())  
        {  
                adap_get = iterador_adaptador.next();
                                
            if (adap_get.getPuertaenlace().equals(ip_predeterminada)){
                adaptador_principal.setPrincipal(false);
                adap_get.setPrincipal(true);
                adaptador_principal = adap_get; 
                break;
               }
            }
        
        if (adaptador_principal_temporal != adaptador_principal){
            
             iterador_adaptador = adaptadores.iterator();
             adap_get = null;
             
             while(iterador_adaptador.hasNext())  
        {  
                adap_get = iterador_adaptador.next();
                                    
                   if(adaptador_principal != adap_get){
                       
                     if (adaptador_principal.getMetrica() != adap_get.getMetrica()){
                         
                                if ((adaptador_principal.getMetrica() > adap_get.getMetrica()) &&
                                        (adap_get.getPuertaenlace().equals(ip_predeterminada))){
                                    adaptador_principal.setPrincipal(false);
                                    adaptador_principal = adap_get;
                                    adaptador_principal.setPrincipal(true);}
                             }
                   }
               }
        }
        
      }else{
    
             iterador_adaptador = adaptadores.iterator();
             adap_get = null;
             
             while(iterador_adaptador.hasNext())  
        {  
                adap_get = iterador_adaptador.next();
                   if ( (adap_get != adaptador_principal) && (adap_get.getPuertaenlace().equals(adaptador_principal.getPuertaenlace())) ){
                        adaptador_principal.setPrincipal(false);
                        adap_get.setPrincipal(true);
                        adaptador_principal = adap_get; 
                         break;}
                    }
           }
        }
    }
    
    
    
    private void Seleccionar_Variables (){
   
   if ("es".equals(Leng)){
        adaptador = "daptador";
        descripcion = "escripc";
        dir_fisica = "sica";
        ethernet = "hernet";
        inalambrica = "mbrica";
        puerta_enl_pdt = "enlace predeterminada";
        ipv4 = "IPv4";
      }else{  
        adaptador = "adapter";
        descripcion = "Description";
        dir_fisica = "Physical";
        ethernet = "hernet";
        inalambrica = "reless";
        puerta_enl_pdt = "Gateway";
        ipv4 = "IPv4";
   }
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inicio other = (Inicio) obj;
        if (!Objects.equals(this.encod, other.encod)) {
            return false;
        }
        if (!Objects.equals(this.adaptadores, other.adaptadores)) {
            return false;
        }
        if (!Objects.equals(this.adaptador_principal, other.adaptador_principal)) {
            return false;
        }
        if (!Objects.equals(this.SO, other.SO)) {
            return false;
        }
        if (!Objects.equals(this.Leng, other.Leng)) {
            return false;
        }
        if (!Objects.equals(this.adaptador, other.adaptador)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.dir_fisica, other.dir_fisica)) {
            return false;
        }
        if (!Objects.equals(this.ethernet, other.ethernet)) {
            return false;
        }
        if (!Objects.equals(this.inalambrica, other.inalambrica)) {
            return false;
        }
        if (!Objects.equals(this.puerta_enl_pdt, other.puerta_enl_pdt)) {
            return false;
        }
        if (!Objects.equals(this.ipv4, other.ipv4)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.encod);
        hash = 97 * hash + Objects.hashCode(this.adaptadores);
        hash = 97 * hash + Objects.hashCode(this.adaptador_principal);
        hash = 97 * hash + Objects.hashCode(this.SO);
        hash = 97 * hash + Objects.hashCode(this.Leng);
        hash = 97 * hash + (this.primer_inicio ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.adaptador);
        hash = 97 * hash + Objects.hashCode(this.descripcion);
        hash = 97 * hash + Objects.hashCode(this.dir_fisica);
        hash = 97 * hash + Objects.hashCode(this.ethernet);
        hash = 97 * hash + Objects.hashCode(this.inalambrica);
        hash = 97 * hash + Objects.hashCode(this.puerta_enl_pdt);
        hash = 97 * hash + Objects.hashCode(this.ipv4);
        return hash;
    }
    
  
    
}
