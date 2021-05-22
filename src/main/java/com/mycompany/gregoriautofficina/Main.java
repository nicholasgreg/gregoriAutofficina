/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import eccezioni.EccezioneValoreNonEsistente;
import eccezioni.EccezioniPosizioneNonValida;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Main implements Serializable
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
        //LocalDate data;
        int giorno,mese,anno;
        float costo;
        //int id=0;
        
        String nomeFile="autofficina.txt";
        String nomeFileBin="autofficina.bin";
        
        
        vociMenu[0]="esci";
        vociMenu[1]="registrare una nuova revisione";
        vociMenu[2]="visualizza revisioni automezzo in base alla targa";
        vociMenu[3]="visualizza interventi giorno";
        vociMenu[4]="elimina una revisione effettuata";
        vociMenu[5]="Visualizza revisoni auto persona in ordine inverso";
        vociMenu[6]="Esportare in formato CSV tutti gli interventi ";
        vociMenu[7]="Salva revisioni su file binario";
        
        try
        {
            FileInputStream f1=new FileInputStream(nomeFileBin);
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                a=(Autofficina)reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");
                        
            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
        
        //int id=a.getNumeroRevPresenti();
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
            {
                    int id=a.getCodice(a.getNumeroRevPresenti()-1);
                    
                    
                    //System.out.println("Premi un tasto per continuare...");
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
                            if(a.getNumeroRevPresenti()>= a.getNUM_MAX_REVISIONI())
                            {
                                System.out.println("Il numero massimo di revisioni è stato raggiunto");
                                System.out.println("premi un tasto per continuar....");
                                tastiera.nextLine();
                                break;
                            }
                            
                           try
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
                                //data=LocalDate.of(anno, mese, giorno);
                                System.out.println("Costo --> ");
                                costo=tastiera.nextFloat();
                                
                                id++;
                                revisione=new Revisione(id,targa,nome,cognome,descrizioneIntervento,costo,anno,mese,giorno);
                                
                                a.aggiungiRevisione(revisione);

                                break;
                           }
                           catch(InputMismatchException e1)
                            {
                                System.out.println("il valore che è stato inserito non è corretto");
                                tastiera.nextLine();
                                
                                break;
                            }
                           
                        }
                        case 2:
                        {
                            try
                            {
                            
                                Revisione[] elencoTarga;
                                String targa1;
                                System.out.println("Targa-->");
                                targa1=tastiera.nextLine();

                                elencoTarga=a.revisioniTarga(targa1);
                                
                                       for(int i=0;i<elencoTarga.length;i++)
                                       {
                                           if(elencoTarga[0]==null)
                                               System.out.println("nessuna revisione per la targa "+targa1);
                                           if(elencoTarga[i]!=null)
                                              System.out.println(elencoTarga[i]);
                                           else 
                                           {
                                               break;
                                           }
                                               
                                           
                                       }
                             break;
                            }
                            catch(ArrayIndexOutOfBoundsException e1)
                            {
                                    System.out.println("la targa inserita non è presente ");
                                    System.out.println("Premi un tasto per continuare...");
                                    tastiera.nextLine();
                                    break;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("l'inserimento non è valido");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println("La targa inserita non è esistente");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 

                            
                        }
                        case 3:
                        {
                            try
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
                                           if(elencoGiorno[i]!=null)
                                              System.out.println(elencoGiorno[i]);

                                  }

                                break;
                                
                            }
                            catch(DateTimeException e1)
                            {
                                System.out.println("errore nell'inserimento della data");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("l'inserimento non è valido");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            }  
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println("Il giorno inserito non è esistente");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                        }
                        case 4:
                        {
                            try
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
                            catch(InputMismatchException ex)
                            {
                                System.out.println("l'inserimento non è valido");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println(ex.toString());
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                        }
                        case 5:
                        {


                            try
                            {
                                Revisione[] elencoRevisioniPersona;
                                String nome1,cognome1;

                                System.out.println("Nome-->");
                                nome1=tastiera.nextLine();
                                System.out.println("Cognome-->");
                                cognome1=tastiera.nextLine();

                                elencoRevisioniPersona=a.InterventiAutoPersonaDecrescente(nome1, cognome1);
                                    for(int i=0;i<elencoRevisioniPersona.length;i++)
                                    {
                                        System.out.println("CodiceId--> "+elencoRevisioniPersona[i].getCodiceId()+" Targa--> "+elencoRevisioniPersona[i].getTarga()+" Cognome--> "+elencoRevisioniPersona[i].getCognome()+" Nome--> "+elencoRevisioniPersona[i].getNome()+" Descrizione intervento--> "+elencoRevisioniPersona[i].getDescrizioneIntervento()+" Data--> "+elencoRevisioniPersona[i].getData()+" Costo--> "+elencoRevisioniPersona[i].getCosto());
                                    }
                                    System.out.println("premi un pulsante per continuare");
                                        tastiera.nextLine();  
                            }
                            catch(NullPointerException e1)
                            {
                                System.out.println("si è verificato un problema");
                            }
                            catch(ArrayIndexOutOfBoundsException e2)
                            {
                            System.out.println("la persona inserita non è presente");
                            break;
                            }
                            catch(EccezioneValoreNonEsistente ex)
                            {
                                System.out.println("Il nome e cognome inseriti non sono esistenti");
                                System.out.println("Premi un tasto per continuare...");
                                tastiera.nextLine();
                                break;
                            } 
                            /*try
                            {
                                elencoRevisioniPersona=a.InterventiAutoPersonaDecrescente(nome1, cognome1);

                                if(elencoRevisioniPersona==null)
                                        System.out.println("nessuna revisione per la persona "+nome1+" "+cognome1);
                                else
                                  {
                                       for(int i=0;i<elencoRevisioniPersona.length;i++)
                                           System.out.println(elencoRevisioniPersona[i]);

                                  }
                            }
                            catch(NullPointerException e1)
                            {
                                System.out.println("si è verificato un problema");
                            }*/


                            break;
                        }
                        case 6:
                        {
                            try
                                {
                                    a.salvaRevisione(nomeFile);
                                    System.out.println("salvataggio avvenuto correttamente");
                                }
                                catch(IOException e1)
                                {
                                    System.out.println("impossibile accedere al file, le revisioni non sono state salvate");
                                }
                                catch(FileException e2)
                                {
                                    System.out.println(e2.toString());
                                } 
                                catch(EccezioniPosizioneNonValida e1)
                                {
                                    System.out.println("La posizione non è valida");
                                }


                            break;
                        }
                        case 7:
                        {
                            try
                                {
                                    a.salvaRevisioneBin(nomeFileBin);
                                    System.out.println("salvataggio avvenuto correttamente");
                                }
                                catch(IOException e1)
                                {
                                    System.out.println("impossibile accedere al file binario, le revisioni non sono state salvate");
                                }
                                catch(FileException e2)
                                {
                                    System.out.println(e2.toString());
                                } 
                                catch(EccezioniPosizioneNonValida e1)
                                {
                                    System.out.println("La posizione non è valida");
                                }

                            break;
                        }


                    }
            }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("l'input non è corretto");
            }      
            
            
            
            
        }while(sceltaUtente!=0);
        
        /*Revisione r=new Revisione(0,"bbbbb","nik","Greg","cambio olio",(float)2.5,2001,1,1);
        Autofficina a=new Autofficina();
        
        System.out.println(r.toString());
        
        System.out.println(a.aggiungiRevisione(r));*/
        
    }
}
