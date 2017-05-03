import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    @InjectMocks
    private MathApplication mathApplication = new MathApplication();

    @Mock
    private CalculatorService calculatorService;

    @Test
    public void testAdd(){
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);

        // check that the required arguments were provided to the add method
//        verify(calculatorService).add(10.0, 20.0);

        // check that the add method was called only once, no more, no less (add the additional assertion statement below to test)
//        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
//        verify(calculatorService, times(1)).add(anyDouble(), anyDouble());

        // check that the multiplication method was never called
        verify(calculatorService, never()).multiply(anyDouble(), anyDouble());

        // check that the add subtract method was called at least once
        when(calculatorService.subtract(anyDouble(), anyDouble())).thenReturn(40.0);
        Assert.assertEquals(mathApplication.subtract(50.0, 10.0), 40.0, 0);
        verify(calculatorService, atLeastOnce()).subtract(anyDouble(), anyDouble());

        // check that the division method was called at least or at most 3 times
        when(calculatorService.divide(anyDouble(), anyDouble())).thenReturn(2.0);
        Assert.assertEquals(mathApplication.divide(10.0, 5.0), 2.0, 0);
//        verify(calculatorService, atLeast(3)).divide(anyDouble(), anyDouble());
        verify(calculatorService, atMost(3)).divide(anyDouble(), anyDouble());
    }

    @Test
    public void testAddAny(){
        when(calculatorService.add(anyDouble(), anyDouble())).thenReturn(30.0);
        Assert.assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);
    }

    @Test
    public void testSub(){
        when(calculatorService.subtract(20.0, 10.0)).thenReturn(10.0);
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
    }

    @Test
    public void testMult(){
        when(calculatorService.multiply(10.0, 20.0)).thenReturn(20.0);
        Assert.assertEquals(mathApplication.multiply(10.0, 20.0), 20.0, 0);
    }

    @Test
    public void testDiv(){
        when(calculatorService.divide(10.0, 20.0)).thenReturn(0.5);
        Assert.assertEquals(mathApplication.divide(10.0, 20.0), 0.5, 0);
    }

}
