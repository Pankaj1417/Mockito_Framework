package MathApplication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester{

    MathApplication mathApplication;
    CalculatorService calculatorService;

    @Before
    public void setup(){
        mathApplication = new MathApplication();
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }
    @Test
    public void passingTest(){
        double n1 = 10.0;
        double n2 = 20.0;
        when(calculatorService.add(n1,n2))
                .thenReturn(30.0);

        double expected = mathApplication.add(n1, n2);


        Assert.assertEquals(expected,30.0,0);
        verify(calculatorService,times(1)).add(n1,n2);
    }
    @Test
    public void failingTest(){
        double n1 = 10.0;
        double n2 = 20.0;
        when(calculatorService.add(n1,n2)).thenReturn(35.0);
        double expected = mathApplication.add(n1, n2);
        Assert.assertNotEquals(expected,30.0,0);
    }
}
