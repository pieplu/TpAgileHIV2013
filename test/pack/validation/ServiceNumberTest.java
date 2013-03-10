/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import pack.validation.ServiceNumber;

/**
 *
 * @author Mathieu Latour
 */
public class ServiceNumberTest {

    @Test
    public void serviceNumberIsValid() {
        assertTrue(ServiceNumber.isServiceNumberValid("100"));
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
