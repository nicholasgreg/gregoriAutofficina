/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

import com.mycompany.gregoriautofficina.*;

/**
 *
 * @author Nicolas
 */
public class EccezioneValoreNonEsistente extends Exception
{
   public String toString()
    {
        String s="";
        s+="Il codice inserito non è esistente";
        return s;
    } 
}
