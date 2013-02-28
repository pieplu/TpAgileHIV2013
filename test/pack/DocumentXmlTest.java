/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Alexis
 */
public class DocumentXmlTest {
    
    public DocumentXmlTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNodesByName method, of class DocumentXml.
     */
    @Test
    public void testGetNodesByName() {
        System.out.println("getNodesByName");
        String NodeName = "";
        NodeList expResult = null;
        NodeList result = DocumentXml.getNodesByName(NodeName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtainNodeContent method, of class DocumentXml.
     */
    @Test 
    public void testObtainNodeContent() {
        System.out.println("obtainNodeContent");
        Node parent = null;
        String NodeName = "";
        DocumentXml instance = new DocumentXml();
        String expResult = "";
        String result = instance.obtainNodeContent(parent, NodeName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
