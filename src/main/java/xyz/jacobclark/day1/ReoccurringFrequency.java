package xyz.jacobclark.day1;

import java.util.*;

public class ReoccurringFrequency {
    private List<String> frequencies;

    public ReoccurringFrequency(List<String> frequencies) {
        this.frequencies = frequencies;
    }

    public Integer getFirstReoccurringFrequency() {
        int[] frequencies = convertStringFrequenciesToInts();
        List<Integer> seenFrequencies = new ArrayList<>();

        seenFrequencies.add(0);

        int iterator = 0;

        while(true){
            int previousFrequenciesPosition = seenFrequencies.size() - 1;
            int currentIterationsFrequency = frequencies[iterator] + seenFrequencies.get(previousFrequenciesPosition);

            boolean currentFrequencyHasBeenSeenBefore = seenFrequencies.indexOf(currentIterationsFrequency) > -1;

            if(currentFrequencyHasBeenSeenBefore) {
                return currentIterationsFrequency;
            }

            seenFrequencies.add(currentIterationsFrequency);

            iterator = shouldResetIterator(frequencies.length - 1, iterator);
        }

    }

    private int shouldResetIterator(int frequenciesLength, int iterator) {
        return (iterator >= frequenciesLength) ? 0 : iterator + 1;
    }

    private int[] convertStringFrequenciesToInts() {
        return this.frequencies.stream().mapToInt(Integer::valueOf).toArray();
    }
}
