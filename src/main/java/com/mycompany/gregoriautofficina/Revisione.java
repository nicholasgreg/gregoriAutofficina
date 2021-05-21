/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

/**
 * la classe rappresenta una revisione su un auto
 * i suoi attributi sono:<br>
 * codiceId: codice identificativo della revisione<br>
 * targa: targa del mezzo da revisionare<br>
 * nome: nome del proprietario del mezzo da revisionare<br>
 * cognome: cognome del proprietario del mezzo da revisionare<br>
 * descrizioneIntervento: breve descrizione dell'intervento che si andrà ad effettuare<br>
 * data: data in cui viene fatta la revisione<br>
 * costo: costo dell'intervento<br>
 * In questa classe vengono inserite tutte le informazioni
 * di una revisione.
 * @author Nicolas
 * @version 1.0
 */
public class Revisione implements Serializable
{
    private int codiceId;
    private String targa;
    private String nome;
    private String cognome;
    private String descrizioneIntervento;
    private LocalDate data;
    private float costo;

    /**
     * Costruttore della classe Revisione 
     * Consente di istanziare una nuova revisione
     * @param codiceId: codice identificativo della revisione
     * @param targa: targa del mezzo da revisionare
     * @param nome: nome del proprietario del mezzo da revisionare
     * @param cognome: cognome del proprietario del mezzo da revisionare
     * @param descrizioneIntervento: breve descrizione dell'intervento che si andrà ad effettuare
     * @param costo: costo dell'intervento
     * @param anno: anno in cui viene effettuata la revisone
     * @param mese: mese in cui viene effettuata la revisone
     * @param giorno: giorno in cui viene effettuata la revisone
     */
    public Revisione(int codiceId, String targa, String nome, String cognome, String descrizioneIntervento, float costo,int anno,int mese,int giorno) 
    {
        this.codiceId = codiceId;
        this.targa = targa;
        this.nome = nome;
        this.cognome = cognome;
        this.descrizioneIntervento = descrizioneIntervento;
        data=LocalDate.of(anno,mese,giorno);
        this.costo = costo;
    }
    /**
     * Costruttore di copia della classe Revisione. consente di istanziare una nuova revisione
     * copia della revisione passata come parametro
     * @param r Oggetto di classe Revisione di cui verrà effettuata la copia nel costruttore di copia
     */
    public Revisione(Revisione r)
    {
        codiceId=r.getCodiceId();
        targa=r.getTarga();
        nome=r.getNome();
        cognome=r.getCognome();
        descrizioneIntervento=r.getDescrizioneIntervento();
        data=r.getData();
        costo=r.getCosto();
    }
    /**
     * Costruttore di default della classe Revisione
     * Consente di istanziare un oggetto di classe Revsione con valori nulli 
     * alle variabili
     * codiceId: con valore 0
     * targa: come stringa vuota
     * nome: come stringa vuota
     * cognome: come stringa vuota
     * descrizioneIntervento: come stringa vuota
     * data: con valore del giorno,mese e anno e momento in cui viene istanziata
     * costo: con valore 0
     */
    public Revisione()
    {
        codiceId=0;
        targa="";
        nome="";
        cognome="";
        descrizioneIntervento="";
        data=LocalDate.now();
        costo=0;
    }

    /**
     * Metodo getter della variabile CodiceId
     * Ci permette di visualizzare il valore della variabile codice identificativo
     * @return codiceId
     */
    public int getCodiceId() 
    {
        return codiceId;
    }

    /**
     * Metodo getter della variabile Targa
     * Ci permette di visualizzare il contenuto della variabile Targa
     * @return targa
     */
    public String getTarga() 
    {
        return targa;
    }

    /**
     * Metodo getter della variabile Nome
     * Ci permette di visualizzare il contenuto della variabile nome
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * Metodo getter della variabile cognome
     * Ci permette di visualizzare il contenuto della variabile cognome
     * @return cognome
     */
    public String getCognome()
    {
        return cognome;
    }

    /**
     * Metodo getter della variabile descrizioneIntervento
     * Ci permette di visualizzare il contenuto della variabile descrizioneIntervento
     * @return descrizioneIntervento
     */
    public String getDescrizioneIntervento() 
    {
        return descrizioneIntervento;
    }

    /**
     * Metodo getter della variabile data
     * Ci permette di visualizzare il contenuto della variabile data
     * @return data
     */
    public LocalDate getData()
    {
        return data;
    }
    /**
     * Metodo getter della variabile costo
     * Ci permette di visualizzare il contenuto della variabile costo
     * @return costo
     */
    
    public float getCosto()
    {
        return costo;
    }

    /**
     * Metodo setter della variabile codiceId
     * Ci permette di assegnare un valore alla variabile codiceId
     * @param codiceId valore della variabile codiceId
     */
    public void setCodiceId(int codiceId)
    {
        this.codiceId = codiceId;
    }
    /**
     * Metodo setter della variabile targa
     * Ci permette di assegnare un valore alla variabile targa
     * @param targa valore della variabile targa
     */
    public void setTarga(String targa)
    {
        this.targa = targa;
    }
    /**
     * Metodo setter della variabile nome
     * Ci permette di assegnare un valore alla variabile nome
     * @param nome valore della variabile nome
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    /**
     * Metodo setter della variabile cognome
     * Ci permette di assegnare un valore alla variabile cognome
     * @param cognome valore della variabile cognome
     */
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }
    /**
     * Metodo setter della variabile descrizioneIntervento
     * Ci permette di assegnare un valore alla variabile descrizioneIntervento
     * @param descrizioneIntervento valore della variabile descrizioneIntervento
     */
    public void setDescrizioneIntervento(String descrizioneIntervento) 
    {
        this.descrizioneIntervento = descrizioneIntervento;
    }
    /**
     * Metodo setter della variabile data
     * Ci permette di assegnare un valore alla variabile data inserendo il valore di anno,mese e giorno.
     * @param anno valore della variabile anno
     * @param mese valore della variabile mese
     * @param giorno valore della variabile giorno
     */
    public void setData(int anno,int mese,int giorno) 
    {
        data=LocalDate.of(anno,mese,giorno);
    }

    /**
     * Metodo setter della variabile costo
     * Ci permette di assegnare un valore alla variabile costo
     * @param costo valore della variabile costo
     */
    public void setCosto(int costo) 
    {
        this.costo = costo;
    }

    /**
     * Metodo toString di tutti gli attributi della classe Revisone, degli oggetti di classe Revsione
     * Ci permette di visualizzare il valore di tutti gli attributi dell'oggetto di classe Revisione
     * @return una stringa contenente il valore deglia attributi di revisione
     */
    @Override
    public String toString() 
    {
        return "Revisione{" + "codiceId= " + codiceId + ", targa= " + targa + ", nome= " + nome + ", cognome= " + cognome + ", descrizioneIntervento= " + descrizioneIntervento + ", data= " + data + ", costo= " + costo + '}';
    }
    
    
    
    
    
    
}
