/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsuranceSoftware;

import java.util.ArrayList;
import net.sf.json.JSONObject;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author fe291196
 */
public class ValidationRunnerTest {

    JSONFileCreator mockFileToTest;
    JSONObject testJSONObject;
    String ErrorMessage = "";

    @Before
    public void setUp() throws Exception {
        testJSONObject = JSONObject.fromObject("{\"dossier\": \"A660323"
                + "\",\"mois\": \"2013-03\",\"reclamations\": [{\"soin\": \"175\","
                + "\"code\": \"H1\",\"date\": \"2013-03-02\",\"montant\": \"100,00$"
                + "\"}]}");
        mockFileToTest = new JSONFileCreator(testJSONObject);
    }

    @After
    public void tearDown() {
        String ErrorMessage = "";
    }

    @Test
    public void testSetErrorMessage() {
        ValidationRunner.setErrorMessage("test");
        assertEquals("test", ValidationRunner.getErrorMessage());
    }

    @Test
    public void testGetErrorMessage() {
        ValidationRunner.setErrorMessage("test");
        assertEquals("test", ValidationRunner.getErrorMessage());
    }

    @Test
    public void testRunValidationProcess() throws Exception {
        assertTrue(ValidationRunner.runValidationProcess(mockFileToTest));
    }
    
    @Test
    public void testIsFileToValidateInValidFormat() {
        assertFalse(ValidationRunner.isFileToValidateInValidFormat());
        //verifie que rien ne traine dans fileToValidate
    }

}
