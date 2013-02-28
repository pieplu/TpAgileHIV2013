/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;

/**
 *
 * @author Alexis
 */
public class TP1AGILETest {
    
    public TP1AGILETest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of enregistrerSous method, of class TP1AGILE.
     */
    @Test
    public void testEnregistrerSous() throws Exception {
        System.out.println("enregistrerSous");
        String nomFichier = "";
        Document doc = null;
        TP1AGILE.enregistrerSous(nomFichier, doc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TP1AGILE.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        TP1AGILE.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
