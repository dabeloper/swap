package modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
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



public class Return {
 

 
   public void deleteFile(String folder, String ext) {
 
     GenericExtFilter filter = new GenericExtFilter(ext);
     File dir = new File(folder);
 

     String[] list = dir.list(filter);
 
     if (list.length == 0) return;
 
     File fileDelete;
 
     for (String file : list){
   	String temp = new StringBuffer(folder)
                      .append(File.separator)
                      .append(file).toString();
    	fileDelete = new File(temp);
    	boolean isdeleted = fileDelete.delete();
    	
        
        if (!isdeleted){ 
               try {
                   Runtime.getRuntime().exec("cmd /c attrib +H \""+temp+"\"");
               } catch (Exception ex) {
                   return;
               }
 }
        
     }
   }
 

   public class GenericExtFilter implements FilenameFilter {
 
       private String ext;
 
       public GenericExtFilter(String ext) {
         this.ext = ext;             
       }
 
       @Override
       public boolean accept(File dir, String name) {
         return (name.endsWith(ext));
       }
    }
}