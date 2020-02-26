/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;


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



public class Adaptador_Red implements Serializable{
    
    private boolean principal = false;
    private String nombre;
    private String IP;
    private String mascarasubred;
    private String puertaenlace;
    private String descripcion;
    private String indice_metrica;
    private String MAC;
    private int metrica;
    
    public Adaptador_Red(String nombre, String IP, String puertaenlace, String descripcion,String MAC) {
        this.nombre = nombre;
        this.IP = IP;
        this.puertaenlace = puertaenlace;
        this.descripcion = descripcion;
        this.MAC = MAC;
        }


    public String getIP() {
        return IP;
    }

    public String getMascarasubred() {
        return mascarasubred;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMAC() {
        return MAC;
    }

    public String getPuertaenlace() {
        return puertaenlace;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIndice_metrica() {
        return indice_metrica;
    }

    public int getMetrica() {
        return metrica;
    }

    public boolean isPrincipal() {
        return principal;
    }


    
    
    
    
    
    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMascarasubred(String mascarasubred) {
        this.mascarasubred = mascarasubred;
    }

    public void setPuertaenlace(String puertaenlace) {
        this.puertaenlace = puertaenlace;
    }

    public void setIndice_metrica(String indice_metrica) {
        this.indice_metrica = indice_metrica;
    }

    public void setMetrica(int metrica) {
        this.metrica = metrica;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }


    
    
    
        @Override
    public String toString() {
        return nombre;
    }
    
    
}
