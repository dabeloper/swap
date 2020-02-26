/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

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

public class MiObjectOutputStream extends ObjectOutputStream
{
  
    public MiObjectOutputStream(OutputStream out) throws IOException
    {
        super(out);
    }

   
    protected MiObjectOutputStream() throws IOException, SecurityException
    {
        super();
    }

   
    @Override
    protected void writeStreamHeader() throws IOException
    {
    }

}
