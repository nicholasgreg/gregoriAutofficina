/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import eccezioni.FileException;
import file.TextFile;
import java.io.IOException;
import java.time.LocalDate;
import eccezioni.*;
import file.TextFile;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.util.InputMismatchException;

/**
 * la classe rappresenta un autofficina
 * La classe contiene tutti i metodi per effettuare operazioni sugli oggetti 
 * di classe Revisone, essi sno contenuti in un arrey
 * i suoi attributi sono:<br>
 * elencoRevisioni: è un array di oggetti di classe Revisione 
 * NUM_MAX_REVISIONI: attributo statico,è una costante, rappresenta il numero masiimo delle revisioni che è 100
 * numeroRevPresenti: è un contatore che conta il numero di revisioni presenti nell'array
 * @author Nicolas
 * @version 1.0
 */
public class Autofficina implements Serializable
{
    private Revisione[] elencoRevisioni;
    private static int NUM_MAX_REVISIONI=100;
    private int numeroRevPresenti=0;
    /**
     * Costruttore della classe Autofficina
     * Consente di istanziare una nuova autofficina
     * costituito da NUM_MAX_REVISIONI revisioni vuote
     */

    public Autofficina() 
    {
        elencoRevisioni =new Revisione[NUM_MAX_REVISIONI];
    }
    /**
     * Costruttore di copia. Consente di istanziare una nuova Autofficina,
     * copiando un altro oggetto di classe Autofficina
     * copia dell' Autofficina passata come parametro
     * @param a oggetto di classe Autofficina da cui effettuare la copia
     */
    public Autofficina(Autofficina a)
    {
        elencoRevisioni=new Revisione[NUM_MAX_REVISIONI];       
              
        for(int i=0;i<getNUM_MAX_REVISIONI();i++)
        {
            elencoRevisioni[i]=a.getRevisione(i);
        }
    }
    /**
     * Metodo getter della costante NUM_MAX_REVISIONI
     * Ci permette di visualizzare il valore della variabile NUM_MAX_REVISIONI
     * @return valore NUM_MAX_REVISIONI
     */

    public int getNUM_MAX_REVISIONI() 
    {
        return NUM_MAX_REVISIONI;
    }
    /**
     * Metodo setter della costante NUM_MAX_REVISIONI
     * Ci permette di assegnare un valore alla variabile NUM_MAX_REVISIONI 
     * @param NUM_MAX_REVISIONI valore della variabile NUM_MAX_REVISIONI
     */
    public static void setNUM_MAX_REVISIONI(int NUM_MAX_REVISIONI) 
    {
        Autofficina.NUM_MAX_REVISIONI = NUM_MAX_REVISIONI;
    }
    /**
     * Metodo getter della variabile numeroRevPresenti
     * Ci permette di visualizzare il valore della variabile numeroRevPresenti
     * @return valore  numeroRevPresenti
     */
    public int getNumeroRevPresenti() 
    {
        return numeroRevPresenti;
    }

    /*public void setNumeroRevPresenti(int numeroRevPresenti) 
    {
        this.numeroRevPresenti = numeroRevPresenti;
    }*/
    /**
     * Metodo getter dell'array di oggetti di classe Revisione elencoRevisioni
     * inserendo la posizione dell'oggetto che vogliamo visualizzare
     * Ci permette di visualizzare il contenuto dell'oggetto in posizione posizione
     * @param posizione è la posizione in cui voglio vedere l'oggetto
     * @return Il contenuto dell'array elencorevisioni in posizione posizione, sarà un oggetto di classe Revisione
     */
    public Revisione getRevisione(int posizione)
    {
        return elencoRevisioni[posizione];
    }
    /**
     * Metodo che restituisce il codice identificativo dell'oggetto in posizione posizione
     * inserendo la posizione restituisce il valore del codice identificativo dell'oggetto in posizione posizione
     * @param posizione è la posizione in cui voglio vedere il codice identificativo
     * @return il codice identificativo dell'oggetto in posizione posizione dell'array
     * 
     */
    public int getCodice(int posizione)
    {
         return elencoRevisioni[posizione].getCodiceId();  
    }
    
    /**
     * Metodo getter del numero delle revisioni presenti con valore diverso da null
     * Ci permette di visualizzare il numero di revisioni presenti nell'array con contenuto diverso da null
     * @return numero di revisioni presenti nell'array con valore diverso da null
     */
    public int getNumRevisioni()
    {
        int contatore=0;
   
        for(int i=0;i<NUM_MAX_REVISIONI;i++)
        {
            if(elencoRevisioni[i]!=null)
                contatore++;
        }
        return contatore;
    }
    /**
     * Metodo aggiungi revisione all'array
     * Ci permette di aggiungere una nuova revisione all'array di oggetti di classe Revisione
     * @param r oggetto di classe Revisione da aggiungere all'array
     * @return restituisce 0 se l'aggiunta è andata a buon fine
     * @throws InputMismatchException .
     */
    
    public int aggiungiRevisione(Revisione r) throws InputMismatchException
    {
            elencoRevisioni[numeroRevPresenti]=new Revisione(r);
            numeroRevPresenti++;
            return 0;
            
    }
    /**
     * Metodo getter dell'array di oggetti di classe Revisione elencoRevisioni
     * inserendo la posizione dell'oggetto che vogliamo visualizzare
     * Ci permette di visualizzare il contenuto dell'oggetto in posizione posizione
     * @param posizione è la posizione in cui voglio vedere l'oggetto
     * @return Il contenuto dell'array elencorevisioni in posizione posizione, sarà un oggetto di classe Revisione
     */
    public Revisione getRevisionePosizione(int posizione)
    {
        return elencoRevisioni[posizione];
    }
    /**
     * Metodo che visulizza tutte le revisioni di una targa
     * Ci permette di visualizzare tuute le revisioni di una targa
     * @param targa targa di cui cercare le revisioni
     * @return un array di classe Revisione contenente tutte le revisioni di quella targa
     * @throws ArrayIndexOutOfBoundsException .
     * @throws InputMismatchException .
     * @throws EccezioneValoreNonEsistente  .
     */
    public Revisione[] revisioniTarga(String targa) throws ArrayIndexOutOfBoundsException,InputMismatchException,EccezioneValoreNonEsistente
    {
        Revisione[] revisioniTarga=new Revisione[getNumRevisioni()];
        Revisione revisione;
        int x=0;
        
        int c=0;
        
        for(int i=0;i<getNumRevisioni();i++)
        {
            if(elencoRevisioni[i].getTarga().compareToIgnoreCase(targa)==0)
            {
                revisione=elencoRevisioni[i];
                revisioniTarga[x]=revisione;
                x++;
            }
            else if(elencoRevisioni[i].getTarga().compareToIgnoreCase(targa)!=0)
            {
                c++;
            }
            
        }
        if(c==numeroRevPresenti)
            throw new EccezioneValoreNonEsistente(); 
        
        return revisioniTarga;
        
    }
    /**
     * Metodo che visulizza tutte le revisioni effettuate in un determinato giorno
     * Ci permette di visualizzare tuute le revisioni di un determinato giorno,mese,anno
     * @param data data di cui vuoi visualizzare le revisioni
     * @return un array di classe Revisione contenente tutte le revisioni del giorno inserito come input
     * @throws DateTimeException .
     * @throws InputMismatchException .
     * @throws EccezioneValoreNonEsistente  .
     */
    public Revisione[] revisioniGiorno(LocalDate data) throws DateTimeException, InputMismatchException,EccezioneValoreNonEsistente
    {
        Revisione[] revisioniGiorno=new Revisione[getNumRevisioni()];
        Revisione revisione;
        int x=0;
        int c=0;
        
        for(int i=0;i<getNumRevisioni();i++)
        {
            if(elencoRevisioni[i].getData().isEqual(data)==true)
            {
                revisione=elencoRevisioni[i];
                revisioniGiorno[x]=revisione;
                x++;
            }
            else if(elencoRevisioni[i].getData().isEqual(data)==false)
            {
                c++; 
            }
        }
        if(c==numeroRevPresenti)
            throw new EccezioneValoreNonEsistente(); 
        return revisioniGiorno;
          
    }
    /**
     * Metodo che elimina una revisione inserendo il codice identificativo della revisione
     * ci permette di eliminare una revisione dall'array elencoRevisioni
     * @param codice codice della revisione che vogliamo eliminare
     * @return restituisce: 
     *                      0: se l'eliminazione è andata a buon fine
     *                     -1: se l'eliminazione non è andata a buon fine
     * @throws InputMismatchException .
     * @throws EccezioneValoreNonEsistente  .
     */
    public int eliminaRevisione(int codice) throws InputMismatchException,EccezioneValoreNonEsistente
    {
        int c=0;
        
        for(int i=0;i<numeroRevPresenti;i++)
            {
                if (elencoRevisioni[i]!=null)
                {
                    if(elencoRevisioni[i].getCodiceId()==codice)
                    {
                        aggiornaPosizioneRevisione(i);
                        return 0; 
                    }
                    else if(elencoRevisioni[i].getCodiceId()!=codice)
                    {
                        c++;
                    }
                }
            }
        if(c==numeroRevPresenti)
            throw new EccezioneValoreNonEsistente(); 
        return -1;
        
        /*Revisione r;
        for (int i=0;i<getNumRevisioni();i++)
        {
            if (elencoRevisioni[i]!=null)
            {
                r=elencoRevisioni[i];
                if (r.getCodiceId()==codice)
                {
                    aggiornaPosizioneRevisione(i);
                    numeroRevPresenti--;
                    return 0; 
                }
            }
        }
        return -1;*/
    }
    /**
     * Metodo che aggiorna la posizione degli oggetti nell'array dopo l'eliminazione di un oggetto
     * Inserendo la posizione ci permette di spostare gli oggetti
     * per non lasciare il buco creato dall'eliminazione
     * @param posizione posizione in cui deve spostare gli elementi
     */
    private void aggiornaPosizioneRevisione(int posizione)
    {
        for (int i=posizione;i<numeroRevPresenti-1;i++)  
        {
            elencoRevisioni[i]=elencoRevisioni[i+1];
        }
        elencoRevisioni[numeroRevPresenti-1]=null;      //se ne elimini uno, sicuramente l'ultimo deve contenere null ( lo faccio per togliere dall'array la revisione eliminata)
        numeroRevPresenti--;
    }
    /**
     * Metodo che visualizza le revisioni effettuate sull'auto di una persona inserendo nome e cognome del cliente
     * e che ordina in ordine dal più recente al più vecchio le revisioni in base alla data
     * @param nome nome della persona cui vogliamo visualizzare le revisioni
     * @param cognome cognome della persona cui vogliamo visualizzare le revisioni
     * @return restituisce un array di oggetti di classe revisione contenente 
     * le revisioni di una persona ordinate dalla più recente alla più vecchia le revisioni in base alla data
     * @throws NullPointerException .
     * @throws ArrayIndexOutOfBoundsException .
     * @throws EccezioneValoreNonEsistente  .
     */
    public Revisione[] InterventiAutoPersonaDecrescente(String nome,String cognome) throws NullPointerException,ArrayIndexOutOfBoundsException,EccezioneValoreNonEsistente
    {
        Revisione[] interventiAutoDecresc=new Revisione[getNumeroRevPresenti()];
        Revisione revisione;
        int x=0;
        int c=0;
        
        for(int i=0;i<numeroRevPresenti;i++)
        {
            if(elencoRevisioni[i].getNome().compareToIgnoreCase(nome)==0 && elencoRevisioni[i].getCognome().compareToIgnoreCase(cognome)==0)
            {
                revisione=elencoRevisioni[i];
                interventiAutoDecresc[x]=revisione;
                x++;
            }
            else if(elencoRevisioni[i].getNome().compareToIgnoreCase(nome)!=0 && elencoRevisioni[i].getCognome().compareToIgnoreCase(cognome)!=0)
            {
                c++;
            }
        }
        if(c==numeroRevPresenti)
            throw new EccezioneValoreNonEsistente();
        
        interventiAutoDecresc=Ordinatore.selectionSortAutoPersonaDecrescente(interventiAutoDecresc);
        return interventiAutoDecresc;
    }
    /**
     * Metodo che salva tutte le revisioni dell'array su un file CSV
     * @param nomeFile nome del file CSV su cui vogliamo salvare i dati
     * @throws IOException .
     * @throws EccezioniPosizioneNonValida .
     * @throws FileException  .
     */      
    public void salvaRevisione(String nomeFile) throws IOException,EccezioniPosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Revisione revisione;
        for(int i=0;i<numeroRevPresenti;i++)
            {
               revisione=getRevisionePosizione(i);
                if(revisione!=null)
                {
                    f1.toFile(revisione.getCodiceId()+";"+revisione.getTarga()+";"+revisione.getNome()+";"+revisione.getCognome()+";"+revisione.getDescrizioneIntervento()+";"+revisione.getData()+";"+revisione.getCosto()+";");
                }
            }
        f1.close();
    }
    /**
     * Metodo che salva tutte le revisioni dell'array su un file binario
     * @param nomeFile nome del file binario su cui vogliamo salvare i dati
     * @throws IOException .
     * @throws EccezioniPosizioneNonValida .
     * @throws FileException  .
     */
    public void salvaRevisioneBin(String nomeFile) throws IOException,EccezioniPosizioneNonValida, FileException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    
    
    
    
    
    
    
}
