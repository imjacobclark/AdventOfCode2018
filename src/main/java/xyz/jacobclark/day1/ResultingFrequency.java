package xyz.jacobclark.day1;

import java.util.List;

public class ResultingFrequency {
    private final List<String> frequencies;

    public ResultingFrequency(List<String> frequencies) {
        this.frequencies = frequencies;
    }

    public Integer calculateResultingFrequency() {
        return this.frequencies.stream().mapToInt(Integer::valueOf).sum();
    }
}
