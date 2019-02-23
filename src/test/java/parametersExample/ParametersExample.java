package parametersExample;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {

    @Test
    @Parameters({ "FirstParameter", "SecondParameter" })
    public void test(@Optional("HI") String param1, String param2) {
        System.out.println(param1 + " " +  param2);
    }
}
