/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;
import pack.validation.Amount;
import pack.validation.Validation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
