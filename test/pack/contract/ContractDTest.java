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
public class ContractDTest {
    
    public ContractDTest() {
    }
    
    @Before
    public void setUp() {
    }

    
    @Test
    public void refundCalculationForSoin0TypeDMaxRefund(){
      assertTrue(85.00 == Contract.reimburseCalculation("D", 100, 0));
    }
    
    @Test
    public void refundCalculationForSoin0TypeDMaxRefundInvalid(){
      assertFalse(100.00 == Contract.reimburseCalculation("D", 100, 0));
    }
    
     @Test
    public void refundCalculationForSoin0TypeD(){
      assertTrue(50.00 == Contract.reimburseCalculation("D", 50, 0));
    }
   
    
    @Test
    public void refundCalculationForSoin0InvalidTypeD(){
      assertFalse(49 == Contract.reimburseCalculation("D", 100, 0));
    }
    
    @Test
    public void refundCalculationForSoin100TypeDMaxRefund(){
      assertTrue(75.00 == Contract.reimburseCalculation("D", 100, 100));
    }
    
    @Test
    public void refundCalculationForSoin100TypeDMaxRefundInvalid(){
      assertFalse(100.00 == Contract.reimburseCalculation("D", 100, 100));
    }
    
     @Test
    public void refundCalculationForSoin100TypeD(){
      assertTrue(50.00 == Contract.reimburseCalculation("D", 50, 100));
    }
   
    
    @Test
    public void refundCalculationForSoin100InvalidTypeD(){
      assertFalse(99 == Contract.reimburseCalculation("D", 100, 100));
    }
    
    @Test
    public void refundCalculationForSoin150TypeDMaxRefund(){
      assertTrue(150 == Contract.reimburseCalculation("D", 150, 150));
    }
    
    @Test
    public void refundCalculationForSoin150TypeDMaxRefundInvalid(){
      assertFalse(200 == Contract.reimburseCalculation("D", 200, 150));
    }
    
     @Test
    public void refundCalculationForSoin150TypeD(){
      assertTrue(50.00 == Contract.reimburseCalculation("D", 50, 150));
    }
   
    
    @Test
    public void refundCalculationForSoin150InvalidTypeD(){
      assertFalse(99 == Contract.reimburseCalculation("D", 100, 150));
    }
    
     @Test
    public void refundCalculationForSoin175TypeD(){
      assertTrue(95.00 == Contract.reimburseCalculation("D", 100, 175));
    }
   
    
    @Test
    public void refundCalculationForSoin175InvalidTypeD(){
      assertFalse(99 == Contract.reimburseCalculation("D", 100, 175));
    }
    
     @Test
    public void refundCalculationForSoin200TypeDMaxRefund(){
      assertTrue(100 == Contract.reimburseCalculation("D", 150, 200));
    }
    
    @Test
    public void refundCalculationForSoin200TypeDMaxRefundInvalid(){
      assertFalse(200 == Contract.reimburseCalculation("D", 200, 200));
    }
    
    @Test
    public void refundCalculationForSoin200TypeD(){
      assertTrue(80.00 == Contract.reimburseCalculation("D", 80, 200));
    }
   
    
    @Test
    public void refundCalculationForSoin200InvalidTypeD(){
      assertFalse(80 == Contract.reimburseCalculation("D", 100, 200));
    }
    
    @Test
    public void refundCalculationForSoin300TypeD(){
      assertTrue(1000.0 == Contract.reimburseCalculation("D", 1000, 300));
    }
   
    
    @Test
    public void refundCalculationForSoin300InvalidTypeD(){
      assertFalse(99 == Contract.reimburseCalculation("D", 100, 300));
    }
    
    @Test
    public void refundCalculationForSoin400TypeDMaxRefund(){
      assertTrue(65 == Contract.reimburseCalculation("D", 150, 400));
    }
    
    @Test
    public void refundCalculationForSoin400TypeDMaxRefundInvalid(){
      assertFalse(150 == Contract.reimburseCalculation("D", 150, 400));
    }
    
    @Test
    public void refundCalculationForSoin400TypeD(){
      assertTrue(50.0 == Contract.reimburseCalculation("D", 50, 400));
    }
   
    
    @Test
    public void refundCalculationForSoin400InvalidTypeD(){
      assertFalse(0 == Contract.reimburseCalculation("D", 50, 400));
    }
    
    @Test
    public void refundCalculationForSoin500TypeD(){
      assertTrue(50.0 == Contract.reimburseCalculation("D", 50, 500));
    }
   
    
    @Test
    public void refundCalculationForSoin500InvalidTypeD(){
      assertFalse(0 == Contract.reimburseCalculation("D", 50, 500));
    }
    
    @Test
    public void refundCalculationForSoin600TypeDMaxRefund(){
      assertTrue(100 == Contract.reimburseCalculation("D", 150, 600));
    }
    
    @Test
    public void refundCalculationForSoin600TypeDMaxRefundInvalid(){
      assertFalse(150 == Contract.reimburseCalculation("D", 150, 600));
    }
    
    @Test
    public void refundCalculationForSoin600TypeD(){
      assertTrue(50.0 == Contract.reimburseCalculation("D", 50, 600));
    }
   
    
    @Test
    public void refundCalculationForSoin600InvalidTypeD(){
      assertFalse(0 == Contract.reimburseCalculation("D", 50, 600));
    }
    
    @Test
    public void refundCalculationForSoin700TypeDMaxRefund(){
      assertTrue(90 == Contract.reimburseCalculation("D", 150, 700));
    }
    
    @Test
    public void refundCalculationForSoin700TypeDMaxRefundInvalid(){
      assertFalse(150 == Contract.reimburseCalculation("D", 150, 700));
    }
    
    @Test
    public void refundCalculationForSoin700TypeD(){
      assertTrue(50.0 == Contract.reimburseCalculation("D", 50, 700));
    }
   
    
    @Test
    public void refundCalculationForSoin700InvalidTypeD(){
      assertFalse(0 == Contract.reimburseCalculation("D", 50, 700));
    }
}
