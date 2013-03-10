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
public class ContractLetterTest {
    
    public ContractLetterTest() {
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
     * Test of isContractLetterValid method, of class ContractLetter.
     */
    @Test
    public void testIsContractLetterValid() {
        System.out.println("isContractLetterValid");
        String contractLetter = "";
        boolean expResult = false;
        boolean result = ContractLetter.isContractLetterValid(contractLetter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
