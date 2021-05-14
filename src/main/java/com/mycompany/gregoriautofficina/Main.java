/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[8];
        int sceltaUtente=-1;
        Scanner tastiera=new Scanner(System.in);
        
        Autofficina a=new Autofficina();
        Revisione revisione;
        
        int codiceId;
        String targa;
        String nome;
        String cognome;
        String descrizioneIntervento;
        LocalDate data;
        int giorno,mese,anno;
        float costo;
        int id=0;
        
        
        
        vociMenu[0]="esci";
        vociMenu[1]="registrare una nuova revisione";
        vociMenu[2]="visualizza revisioni automezzo in base alla targa";
        vociMenu[3]="visualizza interventi giorno";
        vociMenu[4]="elimina una revisione effettuata";
        vociMenu[5]="Visualizza revisoni auto persona in ordine inverso";
        vociMenu[6]="Esportare in formato CSV tutti gli interventi ";
        vociMenu[7]="Salva revisioni su file binario";
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            System.out.println("Premi un tasto per continuare...");
            tastiera.nextLine();
            sceltaUtente=menu.sceltaMenu();
            System.out.println("Premi un tasto per continuare...");
            tastiera.nextLine();
            
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione e' terminata");
                    break;
                }
                case 1:
                {
                    
                    System.out.println("Targa-->");
                    targa=tastiera.nextLine();
                    System.out.println("Nome-->");
                    nome=tastiera.nextLine();
                    System.out.println("Cognome-->");
                    cognome=tastiera.nextLine();
                    System.out.println("Descrizione intervento-->");
                    descrizioneIntervento=tastiera.nextLine();
                    System.out.println("Data: ");
                    System.out.println("Giorno --> ");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese --> ");
                    mese=tastiera.nextInt();
                    System.out.println("Anno --> ");
                    anno=tastiera.nextInt();
                    data=LocalDate.of(anno, mese, giorno);
                    System.out.println("Costo --> ");
                    costo=tastiera.nextFloat();
                    
                    revisione=new Revisione(id,targa,nome,cognome,descrizioneIntervento,costo,anno,mese,giorno);
                    id++;
                    a.aggiungiRevisione(revisione);
                    
                    break;
                }
                case 2:
                {
                    Revisione[] elencoTarga;
                    String targa1;
                    System.out.println("Targa-->");
                    targa1=tastiera.nextLine();
                    
                    elencoTarga=a.revisioniTarga(targa1);
                    
                    
                    if(elencoTarga==null)
                            System.out.println("nessuna revisione per la targa "+targa1);
                    else
                      {
                           for(int i=0;i<elencoTarga.length;i++)
                               System.out.println(elencoTarga[i]);
                           
                      }
                    
                    
                    break;
                }
                case 3:
                {
                    Revisione[] elencoGiorno;
                    int anno1,mese1,giorno1;
                    LocalDate data1;
                    System.out.println("Anno-->");
                    anno1=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese1=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    giorno1=tastiera.nextInt();
                    data1=LocalDate.of(anno1,mese1,giorno1);
                    
                    elencoGiorno=a.revisioniGiorno(data1);
                    
                    
                    if(elencoGiorno==null)
                            System.out.println("nessuna revisione per il giorno "+data1);
                    else
                      {
                           for(int i=0;i<elencoGiorno.length;i++)
                               System.out.println(elencoGiorno[i]);
                           
                      }
                    
                    break;
                }
                case 4:
                {
                    int codice,x;
                    System.out.println("codice-->");
                    codice=tastiera.nextInt();
                    
                    x=a.eliminaRevisione(codice);
                    if(x==0)
                        System.out.println("eliminazione avvenuta correttamente");
                    else
                        System.out.println("eliminazione non avvenuta");
                    
                    break;
                }
                case 5:
                {
                    Revisione[] elencoRevisioniPersona;
                    String nome1,cognome1;
                    
                    System.out.println("Nome-->");
                    nome1=tastiera.nextLine();
                    System.out.println("Cognome-->");
                    cognome1=tastiera.nextLine();
                    
                    elencoRevisioniPersona=a.InterventiAutoPersonaDecrescente(nome1, cognome1);
                    
                    if(elencoRevisioniPersona==null)
                            System.out.println("nessuna revisione per la persona "+nome1+" "+cognome1);
                    else
                      {
                           for(int i=0;i<elencoRevisioniPersona.length;i++)
                               System.out.println(elencoRevisioniPersona[i]);
                           
                      }
                   
                    break;
                }
                case 6:
                {
                    
                    
                    break;
                }
                case 7:
                {
                    
                    
                    break;
                }
                
                
            }
            
            
            
            
        }while(sceltaUtente!=0);
        
        /*Revisione r=new Revisione(0,"bbbbb","nik","Greg","cambio olio",(float)2.5,2001,1,1);
        Autofficina a=new Autofficina();
        
        System.out.println(r.toString());
        
        System.out.println(a.aggiungiRevisione(r));*/
        
    }
}
