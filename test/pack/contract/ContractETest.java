/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.contract;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author utilisateur
 */
public class ContractETest {
    
    public ContractETest() {
    }
    
    @Before
    public void setUp() {
    }

    
    @Test
    public void refundCalculationForSoin0TypeE(){
      assertTrue(15 == Contract.refundCalculator("E", 100, 0));
    }
   
    
    @Test
    public void refundCalculationForSoin0InvalidTypeE(){
      assertFalse(0 == Contract.refundCalculator("E", 100, 0));
    }
    
    @Test
    public void refundCalculationForSoin100TypeE(){
      assertTrue(25 == Contract.refundCalculator("E", 100, 100));
    }
   
    
    @Test
    public void refundCalculationForSoin100InvalidTypeE(){
      assertFalse(10 == Contract.refundCalculator("E", 100, 100));
    }
    
     @Test
    public void refundCalculationForSoin150TypeE(){
      assertTrue(15 == Contract.refundCalculator("E", 100, 150));
    }
   
    
    @Test
    public void refundCalculationForSoin150InvalidTypeE(){
      assertFalse(10 == Contract.refundCalculator("E", 100, 150));
    }
    
     @Test
    public void refundCalculationForSoin175TypeEMaxRefund(){
      assertTrue(20 == Contract.refundCalculator("E", 150, 175));
    }
    
    @Test
    public void refundCalculationForSoin175TypeEMaxRefundInvalid(){
      assertFalse(150 == Contract.refundCalculator("E", 150, 175));
    }
    
    
       @Test
    public void refundCalculationForSoin175TypeE(){
      assertTrue(10 == Contract.refundCalculator("E", 40, 175));
    }
   
    
    @Test
    public void refundCalculationForSoin175InvalidTypeE(){
      assertFalse(10 == Contract.refundCalculator("E", 100, 175));
    }
    
      @Test
    public void refundCalculationForSoin200TypeE(){
      assertTrue(12 == Contract.refundCalculator("E", 100, 200));
    }
   
    
    @Test
    public void refundCalculationForSoin200InvalidTypeE(){
      assertFalse(10 == Contract.refundCalculator("E", 100, 200));
    }
    
      @Test
    public void refundCalculationForSoin300TypeE(){
      assertTrue(60 == Contract.refundCalculator("E", 100, 300));
    }
   
    
    @Test
    public void refundCalculationForSoin300InvalidTypeE(){
      assertFalse(50 == Contract.refundCalculator("E", 100, 300));
    }
    
    
     @Test
    public void refundCalculationForSoin400TypeEMaxRefund(){
      assertTrue(15 == Contract.refundCalculator("E", 150, 400));
    }
    
    @Test
    public void refundCalculationForSoin400TypeEMaxRefundInvalid(){
      assertFalse(150 == Contract.refundCalculator("E", 150, 400));
    }
    
    
     @Test
    public void refundCalculationForSoin400TypeE(){
      assertTrue(10 == Contract.refundCalculator("E", 40, 400));
    }
   
    
    @Test
    public void refundCalculationForSoin400InvalidTypeE(){
      assertFalse(25 == Contract.refundCalculator("E", 100, 400));
    }
    
    @Test
    public void refundCalculationForSoin500TypeEMaxRefund(){
      assertTrue(20 == Contract.refundCalculator("E", 150, 500));
    }
    
    @Test
    public void refundCalculationForSoin500TypeEMaxRefundInvalid(){
      assertFalse(40 == Contract.refundCalculator("E", 150, 500));
    }
    
    
     @Test
    public void refundCalculationForSoin500TypeE(){
      assertTrue(15 == Contract.refundCalculator("E", 50, 500));
    }
   
    
    @Test
    public void refundCalculationForSoin500InvalidTypeE(){
      assertFalse(25 == Contract.refundCalculator("E", 100, 500));
    }
    
    @Test
    public void refundCalculationForSoin600TypeE(){
      assertTrue(15 == Contract.refundCalculator("E", 100, 600));
    }
   
    
    @Test
    public void refundCalculationForSoin600InvalidTypeE(){
      assertFalse(25 == Contract.refundCalculator("E", 100, 600));
    }
    
    @Test
    public void refundCalculationForSoin70TypeE(){
      assertTrue(22 == Contract.refundCalculator("E", 100, 700));
    }
   
    
    @Test
    public void refundCalculationForSoin700InvalidTypeE(){
      assertFalse(25 == Contract.refundCalculator("E", 100, 700));
    }
}
