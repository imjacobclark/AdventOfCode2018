package xyz.jacobclark.day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ChecksumCalculatorTest {
    @Test
    public void shouldReturn0WhenNoInputIsProvided() throws Exception {
        List<Box> boxes = new ArrayList<>();

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(0, actualChecksum);
    }

    @Test
    public void shouldReturn0WhenNoDoubleLettersOrTripleLetters() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("abcdef"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(0, actualChecksum);
    }

    @Test
    public void shouldCountOnlyOneLotOfDoubleLettersPerLine() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("aabbcc"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(0, actualChecksum);
    }

    @Test
    public void shouldCountOnlyOneLotOTrippleLettersPerLine() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("aaabbbccc"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(0, actualChecksum);
    }

    @Test
    public void shouldCountOnlyOneLotODoubleLettersPerLineOverMultipleLines() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("aabbcc"));
        boxes.add(new Box("ddeeff"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(0, actualChecksum);
    }

    @Test
    public void shouldCountOnlyOneLotOTripleLettersPerLineOverMultipleLines() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("aaabbbccc"));
        boxes.add(new Box("dddeeefff"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(0, actualChecksum);
    }

    @Test
    public void shouldCountOneLotOfDoubleAndOneLotOfTripleLettersPerLine() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("aabbccc"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(1, actualChecksum);
    }

    @Test
    public void shouldCountOneLotOfDoubleAndOneLotOfTripleLettersOverMultipleLines() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("aabbccc"));
        boxes.add(new Box("ddeefff"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(4, actualChecksum);
    }

    @Test
    public void shouldReturnExpectedResultForProvidedInput() throws Exception {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box("abcdef"));
        boxes.add(new Box("bababc"));
        boxes.add(new Box("abbcde"));
        boxes.add(new Box("abcccd"));
        boxes.add(new Box("aabcdd"));
        boxes.add(new Box("abcdee"));
        boxes.add(new Box("ababab"));

        int actualChecksum = new Boxes(boxes).checksum();

        assertEquals(12, actualChecksum);
    }
}
