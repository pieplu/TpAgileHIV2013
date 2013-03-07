/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contrat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexis
 */
public class ContratTest {
    
    public ContratTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of remboursement method, of class Contrat.
     */
    @Test
    public void testRemboursement() {
        System.out.println("remboursement");
        String typeContrat = "";
        double montant = 0.0;
        int numSoin = 0;
        double expResult = 0.0;
        double result = Contrat.remboursement(typeContrat, montant, numSoin);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
