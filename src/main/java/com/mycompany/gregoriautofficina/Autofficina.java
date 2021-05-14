/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import java.time.LocalDate;

/**
 *
 * @author Nicolas
 */
public class Autofficina 
{
    private Revisione[] elencoRevisioni;
    private static int NUM_MAX_REVISIONI=100;
    private int numeroRevPresenti=0;
    

    public Autofficina() 
    {
        elencoRevisioni =new Revisione[NUM_MAX_REVISIONI];
    }

    public Autofficina(Autofficina a)
    {
        elencoRevisioni=new Revisione[NUM_MAX_REVISIONI];       
              
        for(int i=0;i<getNUM_MAX_REVISIONI();i++)
        {
            elencoRevisioni[i]=a.getRevisione(i);
        }
    }
    

    public static int getNUM_MAX_REVISIONI() 
    {
        return NUM_MAX_REVISIONI;
    }

    public static void setNUM_MAX_REVISIONI(int NUM_MAX_REVISIONI) 
    {
        Autofficina.NUM_MAX_REVISIONI = NUM_MAX_REVISIONI;
    }

    public int getNumeroRevPresenti() 
    {
        return numeroRevPresenti;
    }

    public void setNumeroRevPresenti(int numeroRevPresenti) 
    {
        this.numeroRevPresenti = numeroRevPresenti;
    }
    
    public Revisione getRevisione(int posizione)
    {
        return elencoRevisioni[posizione];
    }
    
    public int aggiungiRevisione(Revisione r)
    {
            elencoRevisioni[numeroRevPresenti]=new Revisione(r);
            numeroRevPresenti++;
            return 0;
            
    }
    
    public Revisione[] revisioniTarga(String targa)
    {
        Revisione[] revisioniTarga=new Revisione[getNumeroRevPresenti()];
        Revisione revisione;
        int x=0;
        
        for(int i=0;i<numeroRevPresenti;i++)
        {
            if(elencoRevisioni[i].getTarga().compareToIgnoreCase(targa)==0)
            {
                revisione=elencoRevisioni[i];
                revisioniTarga[x]=revisione;
                x++;
            }
                
        }
        return revisioniTarga;
    }
    
    public Revisione[] revisioniGiorno(LocalDate data)//controllare
    {
        Revisione[] revisioniGiorno=new Revisione[getNumeroRevPresenti()];
        Revisione revisione;
        int x=0;
        
        for(int i=0;i<numeroRevPresenti;i++)
        {
            if(elencoRevisioni[i].getData().isEqual(data)==true)
            {
                revisione=elencoRevisioni[i];
                revisioniGiorno[x]=revisione;
                x++;
            }
                
        }
        return revisioniGiorno;
          
    }
    
    public int eliminaRevisione(int codice)
    {
        Revisione r;
        for (int i=0;i<numeroRevPresenti;i++)
        {
            if (elencoRevisioni[i]!=null)
            {
                r=elencoRevisioni[i];
                if (r.getCodiceId()==codice)
                {
                    aggiornaPosizioneRevisione(i);
                    return 0; 
                }
            }
        }
        return -1;
    }
    
    private void aggiornaPosizioneRevisione(int posizione)
    {
        for (int i=posizione;i<numeroRevPresenti-1;i++)  
        {
            elencoRevisioni[i]=elencoRevisioni[i+1];
        }
        elencoRevisioni[numeroRevPresenti-1]=null;      //se ne elimini uno, sicuramente l'ultimo deve contenere null ( lo faccio per togliere dall'array la revisione eliminata)
        numeroRevPresenti--;
    }
    
    public Revisione[] InterventiAutoPersonaDecrescente(String nome,String cognome)
    {
        Revisione[] interventiAutoDecresc=new Revisione[getNumeroRevPresenti()];
        Revisione revisione;
        int x=0;
        
        for(int i=0;i<numeroRevPresenti;i++)
        {
            if(elencoRevisioni[i].getNome().compareToIgnoreCase(nome)==0 && elencoRevisioni[i].getCognome().compareToIgnoreCase(cognome)==0)
            {
                revisione=elencoRevisioni[i];
                interventiAutoDecresc[x]=revisione;
                x++;
            }
        }
        interventiAutoDecresc=Ordinatore.selectionSortAutoPersonaDecrescente(interventiAutoDecresc);
        return interventiAutoDecresc;
    }
            
    
    
    
    
    
}
