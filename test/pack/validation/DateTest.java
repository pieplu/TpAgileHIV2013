/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.validation;

import pack.validation.Date;

/**
 *
 * @author hj991118
 */
public class DateTest {

    @Test
    public void dateFormatValid() {
        assertTrue(Date.isDateValid("2013-01", "2013-01"));
    }

    @Test
    public void dateFormatInvalid() {
        assertFalse(Date.isDateValid("2013-01-", "2013-01"));
    }

    @Test
    public void dateFormatInvalid2() {
        assertFalse(Date.isDateValid("201a-01", "2013-01"));
    }

    @Test
    public void reclamationMonthCorrespondsToActualMonth() {
        assertTrue(Date.isDateValid("2012-11", "2012-11"));
    }

    @Test
    public void reclamationMonthDoesNotCorrespondToActualMonth() {
        assertFalse(Date.isDateValid("2012-12", "2012-11"));
    }
}
