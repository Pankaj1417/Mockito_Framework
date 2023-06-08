package MathApplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    MathApplication mathApplication;
    CalculatorService calculatorService;

    @Before
    public void setup() {
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        calculatorService = spy(calculator);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void testCase() {
        double n1 = 10.0;
        double n2 = 20.0;
        when(calculatorService.add(n1, n2)).thenReturn(35.0);
        double expected = mathApplication.add(n1, n2);
        Assert.assertNotEquals(expected, 30.0, 0);
    }
    @Test
    public void passingTestInorder() {
        double n1 = 20.0;
        double n2 = 10.0;
        //add the behavior to add numbers
        when(calculatorService.add(n1, n2)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(calculatorService.subtract(n1, n2)).thenReturn(10.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(n1, n2), 30.0, 0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(n1, n2), 10.0, 0);

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calculatorService);

        //following will make sure that add is first called then subtract is called.
        inOrder.verify(calculatorService).add(n1, n2);
        inOrder.verify(calculatorService).subtract(n1, n2);

    }

    @Test
    public void failingTestInorder() {
        double n1 = 20.0;
        double n2 = 10.0;
        //add the behavior to add numbers
        when(calculatorService.add(n1, n2)).thenReturn(30.0);

        //subtract the behavior to subtract numbers
        when(calculatorService.subtract(n1, n2)).thenReturn(10.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(n1, n2), 30.0, 0);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(n1, n2), 10.0, 0);

        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calculatorService);

        //following will make sure that subtract is first called then add is called.
        inOrder.verify(calculatorService).subtract(n1, n2);
        inOrder.verify(calculatorService).add(n1, n2);
    }

    @Test
    public void testForSpyCalculator(){
        double n1 = 20.0;
        double n2 = 10.0;
        Assert.assertEquals(mathApplication.add(n1,n2),30.0,0.0);
    }

}
