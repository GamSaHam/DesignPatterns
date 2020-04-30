package testability;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DemoTest {

    @Test
    public void singletonTotalPopulationTests(){
        SingletonRecordFinder rf = new SingletonRecordFinder();

        List<String> names = Arrays.asList("Seoul", "Mexico City");

        int tp = rf.getTotalPopulation(names);

        System.out.println("test");
        assertThat(17500000+17400000, is(tp));

    }

    @Test
    public void dependentPopulationTest(){
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder rf = new ConfigurableRecordFinder(db);
        assertThat(4, is(rf.getTotalPopulation(Arrays.asList("alpha", "gamma"))));

    }
}