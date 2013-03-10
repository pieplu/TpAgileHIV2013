/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author hj991118
 */
public class ClientIDTest {
    
    public ClientIDTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isClientNumberValid method, of class ClientID.
     */
    @Test
    public void testIsClientNumberValid() {
        System.out.println("isClientNumberValid");
        String clientID = "";
        boolean expResult = false;
        boolean result = ClientID.isClientNumberValid(clientID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isClientNumberLengthValid method, of class ClientID.
     */
    @Test
    public void testIsClientNumberLengthValid() {
        System.out.println("isClientNumberLengthValid");
        String clientID = "";
        boolean expResult = false;
        boolean result = ClientID.isClientNumberLengthValid(clientID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
