package MathApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Stack;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester{

    @InjectMocks
    MathApplication mathApplication = new MathApplication();
    @Mock
    CalculatorService calculatorService;
    @Test
    public void passingTest(){
        double n1 = 10.0;
        double n2 = 20.0;
        doThrow(new RuntimeException("divide operation not implemented"))
                .when(calculatorService).add(n1,n2);

//        when(calculatorService.add(n1,n2))
//                .thenReturn(30.0);

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
