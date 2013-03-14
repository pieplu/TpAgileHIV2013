/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RefundCalculator;

import RefundCalculator.Calculator;
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
    public void refundCalculatorForSoin0TypeDMaxRefund(){
      assertTrue(85.00 == Calculator.refundCalculator("D", 100, 0));
    }
    
    @Test
    public void refundCalculatorForSoin0TypeDMaxRefundInvalid(){
      assertFalse(100.00 == Calculator.refundCalculator("D", 100, 0));
    }
    
     @Test
    public void refundCalculatorForSoin0TypeD(){
      assertTrue(50.00 == Calculator.refundCalculator("D", 50, 0));
    }
   
    
    @Test
    public void refundCalculatorForSoin0InvalidTypeD(){
      assertFalse(49 == Calculator.refundCalculator("D", 100, 0));
    }
    
    @Test
    public void refundCalculatorForSoin100TypeDMaxRefund(){
      assertTrue(75.00 == Calculator.refundCalculator("D", 100, 100));
    }
    
    @Test
    public void refundCalculatorForSoin100TypeDMaxRefundInvalid(){
      assertFalse(100.00 == Calculator.refundCalculator("D", 100, 100));
    }
    
     @Test
    public void refundCalculatorForSoin100TypeD(){
      assertTrue(50.00 == Calculator.refundCalculator("D", 50, 100));
    }
   
    
    @Test
    public void refundCalculatorForSoin100InvalidTypeD(){
      assertFalse(99 == Calculator.refundCalculator("D", 100, 100));
    }
    
    @Test
    public void refundCalculatorForSoin150TypeDMaxRefund(){
      assertTrue(150 == Calculator.refundCalculator("D", 150, 150));
    }
    
    @Test
    public void refundCalculatorForSoin150TypeDMaxRefundInvalid(){
      assertFalse(200 == Calculator.refundCalculator("D", 200, 150));
    }
    
     @Test
    public void refundCalculatorForSoin150TypeD(){
      assertTrue(50.00 == Calculator.refundCalculator("D", 50, 150));
    }
   
    
    @Test
    public void refundCalculatorForSoin150InvalidTypeD(){
      assertFalse(99 == Calculator.refundCalculator("D", 100, 150));
    }
    
     @Test
    public void refundCalculatorForSoin175TypeD(){
      assertTrue(95.00 == Calculator.refundCalculator("D", 100, 175));
    }
   
    
    @Test
    public void refundCalculatorForSoin175InvalidTypeD(){
      assertFalse(99 == Calculator.refundCalculator("D", 100, 175));
    }
    
     @Test
    public void refundCalculatorForSoin200TypeDMaxRefund(){
      assertTrue(100 == Calculator.refundCalculator("D", 150, 200));
    }
    
    @Test
    public void refundCalculatorForSoin200TypeDMaxRefundInvalid(){
      assertFalse(200 == Calculator.refundCalculator("D", 200, 200));
    }
    
    @Test
    public void refundCalculatorForSoin200TypeD(){
      assertTrue(80.00 == Calculator.refundCalculator("D", 80, 200));
    }
   
    
    @Test
    public void refundCalculatorForSoin200InvalidTypeD(){
      assertFalse(80 == Calculator.refundCalculator("D", 100, 200));
    }
    
    @Test
    public void refundCalculatorForSoin300TypeD(){
      assertTrue(1000.0 == Calculator.refundCalculator("D", 1000, 300));
    }
   
    
    @Test
    public void refundCalculatorForSoin300InvalidTypeD(){
      assertFalse(99 == Calculator.refundCalculator("D", 100, 300));
    }
    
    @Test
    public void refundCalculatorForSoin400TypeDMaxRefund(){
      assertTrue(65 == Calculator.refundCalculator("D", 150, 400));
    }
    
    @Test
    public void refundCalculatorForSoin400TypeDMaxRefundInvalid(){
      assertFalse(150 == Calculator.refundCalculator("D", 150, 400));
    }
    
    @Test
    public void refundCalculatorForSoin400TypeD(){
      assertTrue(50.0 == Calculator.refundCalculator("D", 50, 400));
    }
   
    
    @Test
    public void refundCalculatorForSoin400InvalidTypeD(){
      assertFalse(0 == Calculator.refundCalculator("D", 50, 400));
    }
    
    @Test
    public void refundCalculatorForSoin500TypeD(){
      assertTrue(50.0 == Calculator.refundCalculator("D", 50, 500));
    }
   
    
    @Test
    public void refundCalculatorForSoin500InvalidTypeD(){
      assertFalse(0 == Calculator.refundCalculator("D", 50, 500));
    }
    
    @Test
    public void refundCalculatorForSoin600TypeDMaxRefund(){
      assertTrue(100 == Calculator.refundCalculator("D", 150, 600));
    }
    
    @Test
    public void refundCalculatorForSoin600TypeDMaxRefundInvalid(){
      assertFalse(150 == Calculator.refundCalculator("D", 150, 600));
    }
    
    @Test
    public void refundCalculatorForSoin600TypeD(){
      assertTrue(50.0 == Calculator.refundCalculator("D", 50, 600));
    }
   
    
    @Test
    public void refundCalculatorForSoin600InvalidTypeD(){
      assertFalse(0 == Calculator.refundCalculator("D", 50, 600));
    }
    
    @Test
    public void refundCalculatorForSoin700TypeDMaxRefund(){
      assertTrue(90 == Calculator.refundCalculator("D", 150, 700));
    }
    
    @Test
    public void refundCalculatorForSoin700TypeDMaxRefundInvalid(){
      assertFalse(150 == Calculator.refundCalculator("D", 150, 700));
    }
    
    @Test
    public void refundCalculatorForSoin700TypeD(){
      assertTrue(50.0 == Calculator.refundCalculator("D", 50, 700));
    }
   
    
    @Test
    public void refundCalculatorForSoin700InvalidTypeD(){
      assertFalse(0 == Calculator.refundCalculator("D", 50, 700));
    }
}
