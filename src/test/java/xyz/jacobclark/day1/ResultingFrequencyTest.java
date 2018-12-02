package xyz.jacobclark.day1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ResultingFrequencyTest {
    @Test
    public void shouldCalculateForASinglePositiveInteger() {
        List<String> frequencies = new ArrayList<>();
        frequencies.add("+100");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(100, frequency);
    }

    @Test
    public void shouldCalculateForASingleNegativeInteger() {
        List<String> frequencies = new ArrayList<>();
        frequencies.add("-100");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(-100, frequency);
    }

    @Test
    public void shouldCalculateForMultiplePositiveIntegers() {
        List<String> frequencies = new ArrayList<>();
        frequencies.add("+50");
        frequencies.add("+50");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(100, frequency);
    }

    @Test
    public void shouldCalculateForMultipleNegativeIntegers() {
        List<String> frequencies = new ArrayList<>();
        frequencies.add("-50");
        frequencies.add("-50");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(-100, frequency);
    }

    @Test
    public void shouldCalculateForMultiplePositiveAndNegativeIntegers() {
        List<String> frequencies = new ArrayList<>();
        frequencies.add("-50");
        frequencies.add("-50");
        frequencies.add("+50");
        frequencies.add("+1");

        ResultingFrequency resultingFrequency = new ResultingFrequency(frequencies);
        int frequency = resultingFrequency.calculateResultingFrequency();

        assertEquals(-49, frequency);
    }
}
