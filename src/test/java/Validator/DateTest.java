/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;
import Validator.Date;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author hj991118
 */
public class DateTest {

    @Test
    public void dateFormatValid() {
        assertTrue(Date.isDateValid("2013-01", "2013-01-01"));
    }

    @Test
    public void dateFormatInvalid() {
        assertFalse(Date.isDateValid("2013-01-", "2013-01-01"));
    }

    @Test
    public void dateFormatInvalid2() {
        assertFalse(Date.isDateValid("201a-01", "2013-01-01"));
    }

    @Test
    public void reclamationMonthCorrespondsToDate() {
        assertTrue(Date.isDateValid("2012-11","2012-11-01"));
    }

    @Test
    public void reclamationMonthDoesNotCorrespondToDate() {
        assertFalse(Date.isDateValid("2012-12", "2012-11-21"));
    }
    
    @Test
    public void reclamationMonthDoesNotCorrespondToDate() {
        assertFalse(Date.isDateValid("2011-02", "2011-02-29"));
    }
}
