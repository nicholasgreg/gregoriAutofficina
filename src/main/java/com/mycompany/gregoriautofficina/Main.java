/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

/**
 *
 * @author Nicolas
 */
public class Main 
{
    public static void main(String[] args) 
    {
        
        Revisione r=new Revisione(0,"bbbbb","nik","Greg","cambio olio",(float)2.5,2001,1,1);
        Autofficina a=new Autofficina();
        
        System.out.println(r.toString());
        
        System.out.println(a.aggiungiRevisione(r));
        
    }
}
