import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.when;

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