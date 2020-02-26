/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedList;

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

public class Guardar_Leer {
    
     private LinkedList<Host> hosts = new LinkedList<>() ;
     private String fichero = "./Swap_hosts.dat";
     
    public Guardar_Leer() {}
     
     
     
     public void Guardar(LinkedList<Host> hts)
    {
     
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fichero));
            
        Iterator<Host> iterador_hosts = hts.iterator(); 
        Host host_get,h;
        
            while(iterador_hosts .hasNext())  
            {
                    host_get = iterador_hosts .next();
            
                h = host_get;
                h.setEnlace(null);
                h.setEstado(false);
                oos.writeObject(h);
            }
            oos.close();
        } catch (Exception e)
        {
          
        }
    }
    

     
    public void anhadeFichero ()
    {
        try
        {  
            MiObjectOutputStream oos = new MiObjectOutputStream(
                    new FileOutputStream(fichero,true));
            
            oos.close();
        } catch (Exception e){
          
        }

    }
    

    public void Leer()
    {
        
        try
        {
           
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            
            
            Object aux = ois.readObject();
            
            
            while (aux!=null)
            {
                if (aux instanceof Host){
                    hosts.add((Host)aux);
                    }
                aux = ois.readObject();
            }
            ois.close();
        }
        catch (Exception e1)
        {
            
        }
    }

    
    
    public LinkedList<Host> Leer(String path)
    {
        LinkedList<Host> hs = new LinkedList<>();
        try
        {
           
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            
            
            Object aux = ois.readObject();
            
            
            while (aux!=null)
            {
                if (aux instanceof Host){
                    hs.add((Host)aux);
                    }
                aux = ois.readObject();
            }
            ois.close();
            return hs;
        }
        catch (Exception e1)
        {
            
            return hs;
        }
    }
    
    
    public LinkedList<Host> getHosts() {
        return hosts;
    }
    
    
}
