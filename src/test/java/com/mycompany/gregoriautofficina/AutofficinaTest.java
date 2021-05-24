/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gregoriautofficina;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas
 */
public class AutofficinaTest {
    
    Autofficina a;
    
    public AutofficinaTest() 
    {
        a=new Autofficina();
    }
    
    /**
     * Test of getNUM_MAX_REVISIONI method, of class Autofficina.
     */
    @Test
    public void testGetNUM_MAX_REVISIONI() 
    {
        System.out.println("getNUM_MAX_REVISIONI");
        Autofficina a2 = new Autofficina();
        int max = 100;
        int result = a2.getNUM_MAX_REVISIONI();
        assertEquals(max, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNUM_MAX_REVISIONI method, of class Autofficina.
     */
    @Test
    public void testSetNUM_MAX_REVISIONI() 
    {
        System.out.println("setNUM_MAX_REVISIONI");
        int NUM_MAX_REVISIONI = 50;
        Autofficina.setNUM_MAX_REVISIONI(NUM_MAX_REVISIONI);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroRevPresenti method, of class Autofficina.
     */
    @Test
    public void testGetNumeroRevPresenti() 
    {
        System.out.println("getNumeroRevPresenti");
        Autofficina instance = new Autofficina();
        int expResult = 1;
        int result = instance.getNumeroRevPresenti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevisione method, of class Autofficina.
     */
    @Test
    public void testGetRevisione() 
    {
        System.out.println("getRevisione");
        int posizione = 0;
        Autofficina instance = new Autofficina();
        Revisione expResult = null;
        Revisione result = instance.getRevisione(posizione);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCodice method, of class Autofficina.
     */
    @Test
    public void testGetCodice() 
    {
        System.out.println("getCodice");
        int posizione = 0;
        Autofficina instance = new Autofficina();
        int expResult = 0;
        int result = instance.getCodice(posizione);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumRevisioni method, of class Autofficina.
     */
    @Test
    public void testGetNumRevisioni() 
    {
        System.out.println("getNumRevisioni");
        Autofficina instance = new Autofficina();
        int expResult = 0;
        int result = instance.getNumRevisioni();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiRevisione method, of class Autofficina.
     */
    @Test
    public void testAggiungiRevisione() 
    {
        System.out.println("aggiungiRevisione");
        Revisione r = null;
        Autofficina instance = new Autofficina();
        int expResult = 0;
        int result = instance.aggiungiRevisione(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRevisionePosizione method, of class Autofficina.
     */
    @Test
    public void testGetRevisionePosizione() 
    {
        System.out.println("getRevisionePosizione");
        int posizione = 0;
        Autofficina instance = new Autofficina();
        Revisione expResult = null;
        Revisione result = instance.getRevisionePosizione(posizione);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisioniTarga method, of class Autofficina.
     */
    @Test
    public void testRevisioniTarga() throws Exception 
    {
        System.out.println("revisioniTarga");
        String targa = "arrr";
        Autofficina instance = new Autofficina();
        Revisione[] expResult = null;
        Revisione[] result = instance.revisioniTarga(targa);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisioniGiorno method, of class Autofficina.
     */
    @Test
    public void testRevisioniGiorno() throws Exception 
    {
        System.out.println("revisioniGiorno");
        LocalDate data = null;
        Autofficina instance = new Autofficina();
        Revisione[] expResult = null;
        Revisione[] result = instance.revisioniGiorno(data);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaRevisione method, of class Autofficina.
     */
    @Test
    public void testEliminaRevisione() throws Exception 
    {
        System.out.println("eliminaRevisione");
        int codice = 0;
        Autofficina instance = new Autofficina();
        int expResult = 0;
        int result = instance.eliminaRevisione(codice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InterventiAutoPersonaDecrescente method, of class Autofficina.
     */
    @Test
    public void testInterventiAutoPersonaDecrescente() throws Exception 
    {
        System.out.println("InterventiAutoPersonaDecrescente");
        String nome = "";
        String cognome = "";
        Autofficina instance = new Autofficina();
        Revisione[] expResult = null;
        Revisione[] result = instance.InterventiAutoPersonaDecrescente(nome, cognome);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaRevisione method, of class Autofficina.
     */
    @Test
    public void testSalvaRevisione() throws Exception 
    {
        System.out.println("salvaRevisione");
        String nomeFile = "";
        Autofficina instance = new Autofficina();
        instance.salvaRevisione(nomeFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaRevisioneBin method, of class Autofficina.
     */
    @Test
    public void testSalvaRevisioneBin() throws Exception 
    {
        System.out.println("salvaRevisioneBin");
        String nomeFile = "";
        Autofficina instance = new Autofficina();
        instance.salvaRevisioneBin(nomeFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
