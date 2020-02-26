/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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

public class Host implements Serializable {
    
    private Adaptador_Red enlace;
    private String nombre;
    private LinkedList<String> IPs = new LinkedList<>();
    private LinkedList<String> masks = new LinkedList<>();;
    private boolean Estado;

    
      public Host(String nombre) {
        this.nombre = nombre;
        this.enlace = null;
        Estado = false;
    }
    
    
    public Host(String nombre, String ip) {
        this.nombre = nombre;
        this.enlace = null;
        IPs.add(ip);
        masks.add("255.255.255.255");
        Estado = false;
    }

    public Host(String nombre, String ip, String mask) {
        this.nombre = nombre;
        IPs.add(ip);
        masks.add(mask);
        Estado = false;
    }
    
    
   

    public String getNombre() {
        return nombre;
    }

    public Adaptador_Red getEnlace() {
        return enlace;
    }

    public void setEnlace(Adaptador_Red enlace) {
        this.enlace = enlace;
    }

    public LinkedList<String> getIPs() {
        return IPs;
    }

    public LinkedList<String> getMasks() {
        return masks;
    }

    public boolean getEstado() {      
        return Estado;
    }


    

    

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }
    
        @Override
    public String toString() {
        if (IPs.size() > 1){
            return nombre ;
        }else{
            return nombre + " : " + IPs.getFirst() + " / " + masks.getFirst();}
    }
    
}
