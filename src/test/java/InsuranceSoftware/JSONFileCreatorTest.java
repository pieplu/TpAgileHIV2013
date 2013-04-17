/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InsuranceSoftware;

import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author fe291196
 */
public class JSONFileCreatorTest {
    
    JSONFileCreator mockFileToTest;
    JSONObject testJSONObject;
    
    @Before
    public void setUp() throws Exception {
        testJSONObject = JSONObject.fromObject("{\"dossier\": \"A660323"
                + "\",\"mois\": \"2013-03\",\"reclamations\": [{\"soin\": \"175\","
                + "\"code\": \"H1\",\"date\": \"2013-03-02\",\"montant\": \"100,00$"
                + "\"}]}");
        mockFileToTest = new JSONFileCreator (testJSONObject);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetJSONArrayByName() {
        JSONArray testJSONArray = JSONArray.fromObject("[{\"soin\": \"175\","
                + "\"code\": \"H1\",\"date\": \"2013-03-02\",\"montant\": \"100,00$\"}]");
        JSONArray result = mockFileToTest.getJSONArrayByName("reclamations");
        assertEquals(testJSONArray, result);
    }

    @Test
    public void testObtainJSONStringContent() {
        String result = mockFileToTest.obtainJSONStringContent("dossier");
        assertEquals("A660323", result);
    }

}
