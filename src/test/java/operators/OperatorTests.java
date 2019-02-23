package operators;

import ExampleClass.Mult;
import ExampleClass.Resta;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OperatorTests {

    @Test
    public void resta(){
        Resta resta =  new Resta();
        double values = resta.operate(5,5);
        Assert.assertEquals(values,0.0);
    }

    @Test
    public void Multi(){
        Mult mult =  new Mult();
        double values = mult.operate(5,5);
        Assert.assertEquals(values,25.0);
    }
}
