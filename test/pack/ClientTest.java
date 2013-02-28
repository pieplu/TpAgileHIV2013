/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexis
 */
public class ClientTest {
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of DefaultClient method, of class Client.
     */
    @Test
    public void testDefaultClient() {
        System.out.println("DefaultClient");
        Client instance = new Client();
        instance.DefaultClient();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClientID method, of class Client.
     */
    @Test
    public void testGetClientID() {
        System.out.println("getClientID");
        Client instance = new Client();
        double expResult = 0.0;
        double result = instance.getClientID();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContract method, of class Client.
     */
    @Test
    public void testGetContract() {
        System.out.println("getContract");
        Client instance = new Client();
        char expResult = ' ';
        char result = instance.getContract();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
