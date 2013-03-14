/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import Validator.ServiceNumber;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Mathieu Latour
 */
public class ServiceNumberTest {

    
    static String serviceList[] = new String[]{"0", "100", "200", "300",
        "400", "500", "600", "700"};
    
    @Test
    public void serviceNumberIsValid() {
        assertTrue(ServiceNumber.isServiceNumberValid("0"));
        assertTrue(ServiceNumber.isServiceNumberValid("100"));
        assertTrue(ServiceNumber.isServiceNumberValid("200"));
        assertTrue(ServiceNumber.isServiceNumberValid("300"));
        assertTrue(ServiceNumber.isServiceNumberValid("400"));
        assertTrue(ServiceNumber.isServiceNumberValid("500"));
        assertTrue(ServiceNumber.isServiceNumberValid("600"));
        assertTrue(ServiceNumber.isServiceNumberValid("700"));
        
        assertTrue(ServiceNumber.isServiceNumberValid("150"));
        assertTrue(ServiceNumber.isServiceNumberValid("175"));
        
    }

    @Test
    public void serviceNumberIsValid2() {
        assertTrue(ServiceNumber.isServiceNumberValid("350"));
    }

    @Test
    public void serviceNumberIsInvalid() {
        assertFalse(ServiceNumber.isServiceNumberValid("1"));
    }

    
}
