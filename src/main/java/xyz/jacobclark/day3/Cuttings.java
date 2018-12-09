package xyz.jacobclark.day3;

import java.util.List;

class Cuttings {
    private List<Fabric> cuttings;

    public Cuttings(List<Fabric> cuttings){
        this.cuttings = cuttings;
    }

    public int countOverlapping(){
        int overlaps = 0;
        int boxToCompare = 0;

        while(true){
            if(this.cuttings.isEmpty()){
                return overlaps;
            }

            boolean noFurtherFabricsToCompareAgainst = boxToCompare == this.cuttings.size();
            if(noFurtherFabricsToCompareAgainst){
                this.cuttings.remove(this.cuttings.get(0));
                boxToCompare = 0;
                continue;
            }

            boolean comparingSelf = this.cuttings.get(0).equals(this.cuttings.get(boxToCompare));
            if(comparingSelf){
                boxToCompare++;
                continue;
            }

            boolean fabricsOverlap = this.cuttings.get(0).compareOverlap(this.cuttings.get(boxToCompare));
            if (fabricsOverlap) {
                overlaps++;
            }

            boxToCompare++;
        }
    }
}