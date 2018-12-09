package xyz.jacobclark.day3;

class Fabric {
    private final int y;
    private final int x;
    private final int width;
    private final int height;

    public Fabric(int x, int y, int width, int height){
        this.y = y;
        this.x = x;
        this.width = width;
        this.height = height;
    }

    public int getStartingYPosition(){
        return this.y + 1;
    }

    public int getStartingXPosition(){
        return this.x + 1;
    }

    public int getFinishingXPosition(){
        return this.x + 1 + this.height;
    }

    public int getFinishingYPosition(){
        return this.y + 1 + this.width;
    }

    public boolean compareOverlap(Fabric fabricToCompareAgainst){
        boolean y_overlap = this.getFinishingYPosition() > fabricToCompareAgainst.getStartingYPosition();
        boolean x_overlap = this.getFinishingXPosition() > fabricToCompareAgainst.getStartingXPosition();

        return y_overlap && x_overlap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fabric fabric = (Fabric) o;

        if (y != fabric.y) return false;
        if (x != fabric.x) return false;
        if (width != fabric.width) return false;
        return height == fabric.height;
    }

    @Override
    public int hashCode() {
        int result = y;
        result = 31 * result + x;
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}
