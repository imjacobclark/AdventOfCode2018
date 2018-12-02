package xyz.jacobclark.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;

public class ResultingFrequencyTest {
    @Test
    public void shouldCalculateASinglePositiveInteger() {
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("+100");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(frequency, 100);
    }

    @Test
    public void shouldCalculateForASingleNegativeInteger() {
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("-100");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(frequency, -100);
    }

    @Test
    public void shouldCalculateForMultiplePositiveIntegers() {
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("+50");
        frequencies.add("+50");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(frequency, 100);
    }

    @Test
    public void shouldCalculateForMultipleNegativeIntegers() {
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("-50");
        frequencies.add("-50");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(frequency, -100);
    }

    @Test
    public void shouldCalculateForMultiplePositiveAndNegativeIntegers() {
        ArrayList<String> frequencies = new ArrayList<>();
        frequencies.add("-50");
        frequencies.add("-50");
        frequencies.add("+50");
        frequencies.add("+1");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(frequency, -49);
    }
}
