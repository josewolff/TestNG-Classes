package dataProvidersExamples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExampleDynamicStructure {

    @DataProvider(name = "ExampleDP", parallel = true)
    public Iterator<Object[]> locales() {
        List<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < 15; i++){
            data.add(new Integer[]{i});
        }
        return data.iterator();
    }

    @Test(dataProvider = "ExampleDP")
    public void exampleDP(int number) throws InterruptedException {
        if(number <= 10){
            Thread.sleep(10000);
            System.out.println(number );
        }else{
            Assert.fail(number + " is greater than 10");
        }

    }
}
