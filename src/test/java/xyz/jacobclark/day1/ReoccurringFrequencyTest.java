package xyz.jacobclark.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class ReoccurringFrequencyTest {
    @Test
    public void shouldStartAtFrequency0AndMatch0WithAdditional0Frequency() throws Exception {
        List<String> frequencies = new ArrayList<>();

        frequencies.add("+0");

        ReoccurringFrequency reoccurringFrequency = new ReoccurringFrequency(frequencies);
        int actualReoccurringFrequency = reoccurringFrequency.getFirstReoccurringFrequency();

        assertEquals(0, actualReoccurringFrequency);
    }

    @Test
    public void reaches0Twice() throws Exception {
        List<String> frequencies = new ArrayList<>();

        frequencies.add("+1");
        frequencies.add("-1");

        ReoccurringFrequency reoccurringFrequency = new ReoccurringFrequency(frequencies);
        int actualReoccurringFrequency = reoccurringFrequency.getFirstReoccurringFrequency();

        assertEquals(0, actualReoccurringFrequency);
    }

    @Test
    public void reaches10Twice() throws Exception {
        List<String> frequencies = new ArrayList<>();

        frequencies.add("+3");
        frequencies.add("+3");
        frequencies.add("+4");
        frequencies.add("-2");
        frequencies.add("-4");

        ReoccurringFrequency reoccurringFrequency = new ReoccurringFrequency(frequencies);
        int actualReoccurringFrequency = reoccurringFrequency.getFirstReoccurringFrequency();

        assertEquals(10, actualReoccurringFrequency);
    }

    @Test
    public void reaches5Twice() throws Exception {
        List<String> frequencies = new ArrayList<>();

        frequencies.add("-6");
        frequencies.add("+3");
        frequencies.add("+8");
        frequencies.add("+5");
        frequencies.add("-6");

        ReoccurringFrequency reoccurringFrequency = new ReoccurringFrequency(frequencies);
        int actualReoccurringFrequency = reoccurringFrequency.getFirstReoccurringFrequency();

        assertEquals(5, actualReoccurringFrequency);
    }

    @Test
    public void reaches14Twice() throws Exception {
        List<String> frequencies = new ArrayList<>();

        frequencies.add("+7");
        frequencies.add("+7");
        frequencies.add("-2");
        frequencies.add("-7");
        frequencies.add("-4");

        ReoccurringFrequency reoccurringFrequency = new ReoccurringFrequency(frequencies);
        int actualReoccurringFrequency = reoccurringFrequency.getFirstReoccurringFrequency();

        assertEquals(14, actualReoccurringFrequency);
    }
}
