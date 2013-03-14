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
public class ContractATest {
    
    public ContractATest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void refundCalculationForSoin0TypeA(){
      assertTrue(25.00 == Contract.reimburseCalculation("A", 100, 0));
    }
    
    @Test
    public void refundCalculationForSoin0TypeAInvalid(){
      assertFalse(1 == Contract.reimburseCalculation("A", 100, 0));
    }
    
    @Test
    public void refundCalculationForSoin100TypeA(){
      assertTrue(35.00 == Contract.reimburseCalculation("A", 100, 100));
    }
    
    @Test
    public void refundCalculationForSoin100TypeAInvalid(){
      assertFalse(1 == Contract.reimburseCalculation("A", 100, 100));
    }
    
    @Test
    public void refundCalculationForSoin150TypeA(){
      assertTrue(0.00 == Contract.reimburseCalculation("A", 100, 150));
    }
    
    @Test
    public void refundCalculationForSoin150TypeAInvalid(){
      assertFalse(1 == Contract.reimburseCalculation("A", 100, 150));
    }
    
    @Test
    public void refundCalculationForSoin175TypeA(){
      assertTrue(50.00 == Contract.reimburseCalculation("A", 100, 175));
    }
    
    @Test
    public void refundCalculationForSoin175TypeAInvalid(){
      assertFalse(49 == Contract.reimburseCalculation("A", 100, 175));
    }
    
    @Test
    public void refundCalculationForSoin200TypeA(){
      assertTrue(25.00 == Contract.reimburseCalculation("A", 100, 200));
    }
    
    @Test
    public void refundCalculationForSoin200TypeAInvalid(){
      assertFalse(49 == Contract.reimburseCalculation("A", 100, 200));
    }
    
    @Test
    public void refundCalculationForSoin300TypeA(){
      assertTrue(0.00 == Contract.reimburseCalculation("A", 100, 300));
    }
    
    @Test
    public void refundCalculationForSoin300TypeAInvalid(){
      assertFalse(49 == Contract.reimburseCalculation("A", 100, 300));
    }
    
     
    @Test
    public void refundCalculationForSoin400TypeA(){
      assertTrue(0.00 == Contract.reimburseCalculation("A", 100, 400));
    }
    
    @Test
    public void refundCalculationForSoin400TypeAInvalid(){
      assertFalse(49 == Contract.reimburseCalculation("A", 100, 400));
    }
    
     @Test
    public void refundCalculationForSoin500TypeA(){
      assertTrue(25.00 == Contract.reimburseCalculation("A", 100, 500));
    }
    
    @Test
    public void refundCalculationForSoin500TypeAInvalid(){
      assertFalse(25.01 == Contract.reimburseCalculation("A", 100, 500));
    }
    
     @Test
    public void refundCalculationForSoin600TypeA(){
      assertTrue(40.00 == Contract.reimburseCalculation("A", 100, 600));
    }
    
    @Test
    public void refundCalculationForSoin600TypeAInvalid(){
      assertFalse(25.01 == Contract.reimburseCalculation("A", 100, 600));
    }
    
    @Test
    public void refundCalculationForSoin700TypeA(){
      assertTrue(0 == Contract.reimburseCalculation("A", 100, 700));
    }
    
    @Test
    public void refundCalculationForSoin700TypeAInvalid(){
      assertFalse(1 == Contract.reimburseCalculation("A", 100, 700));
    }
    
}
