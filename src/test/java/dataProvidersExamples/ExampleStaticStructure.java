package dataProvidersExamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleStaticStructure {

    @DataProvider(name = "ExampleDP")
    public static Object[][] ExampleDP() {
        return new Object[][] { { "1", "1","f" }, { "2", "2","f"  }};
    }

    @Test(dataProvider = "ExampleDP")
    public void exampleDP(String firstParameter, String secondParameters, String other){
        System.out.println(firstParameter + " " + secondParameters);
    }
}
