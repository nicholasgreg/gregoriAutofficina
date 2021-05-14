/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Nicolas
 */
public class Revisione //controllare la classe localdate
{
    private int codiceId;
    private String targa;
    private String nome;
    private String cognome;
    private String descrizioneIntervento;
    private LocalDate data;
    private float costo;

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

    public int getCodiceId() 
    {
        return codiceId;
    }

    public String getTarga() 
    {
        return targa;
    }

    public String getNome() 
    {
        return nome;
    }

    public String getCognome()
    {
        return cognome;
    }

    public String getDescrizioneIntervento() 
    {
        return descrizioneIntervento;
    }

    public LocalDate getData()
    {
        return data;
    }

    
    public float getCosto()
    {
        return costo;
    }

    public void setCodiceId(int codiceId)
    {
        this.codiceId = codiceId;
    }

    public void setTarga(String targa)
    {
        this.targa = targa;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public void setDescrizioneIntervento(String descrizioneIntervento) 
    {
        this.descrizioneIntervento = descrizioneIntervento;
    }

    public void setData(int anno,int mese,int giorno) 
    {
        data=LocalDate.of(anno,mese,giorno);
    }

    public void setCosto(int costo) 
    {
        this.costo = costo;
    }

    @Override
    public String toString() 
    {
        return "Revisione{" + "codiceId= " + codiceId + ", targa= " + targa + ", nome= " + nome + ", cognome= " + cognome + ", descrizioneIntervento= " + descrizioneIntervento + ", data= " + data + ", costo= " + costo + '}';
    }
    
    
    
    
    
    
}
