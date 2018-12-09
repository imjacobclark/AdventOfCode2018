package xyz.jacobclark.day3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class OverlappingFabricTest {

    @Test
    public void should_Return0Overlaps_When_FabricDoesNotOverlaps() throws Exception {
        List<Fabric> proposedCuttings = new ArrayList<>();
        proposedCuttings.add(new Fabric(1,3,4,4));
        proposedCuttings.add(new Fabric(5,5,2,2));

        Cuttings cuttings = new Cuttings(proposedCuttings);

        assertEquals(0, cuttings.countOverlapping());
    }

    @Test
    public void should_Return1Overlaps_When_FabricOverlaps() throws Exception {
        List<Fabric> proposedCuttings = new ArrayList<>();
        proposedCuttings.add(new Fabric(1,3,4,4));
        proposedCuttings.add(new Fabric(3,1,4,4));
        proposedCuttings.add(new Fabric(5,5,2,2));

        Cuttings cuttings = new Cuttings(proposedCuttings);

        assertEquals(1, cuttings.countOverlapping());
    }

    @Test
    public void should_Return2Overlaps_When_FabricOverlaps() throws Exception {
        List<Fabric> proposedCuttings = new ArrayList<>();
        proposedCuttings.add(new Fabric(1,2,2,2));
        proposedCuttings.add(new Fabric(1,1,2,2));
        proposedCuttings.add(new Fabric(4,5,4,4));
        proposedCuttings.add(new Fabric(6,7,4,4));

        Cuttings cuttings = new Cuttings(proposedCuttings);

        assertEquals(2, cuttings.countOverlapping());
    }
}
