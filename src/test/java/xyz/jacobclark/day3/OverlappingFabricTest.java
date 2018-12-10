package xyz.jacobclark.day3;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class Fabric {
    List<Claim> claims = new ArrayList<>();

    public Fabric(){
        create();
    }

    private void create(){
        for(int x = 1; x <= 1000; x++){
            for(int y = 1; y <= 1000; y++){
                this.claims.add(new Claim(x, y));
            }
        }
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public void makeClaim(final int x , final int y){
        Claim claim = claims.stream().filter(claimToCheck -> claimToCheck.getX() == x && claimToCheck.getY() == y).findFirst().get();
        claim.setClaims(claim.getClaims() + 1);
    }

    public long getOverlappingClaims() {
        return claims
                .stream()
                .filter(claim -> claim.getClaims() > 1)
                .map(claim -> claim.getClaims())
                .count();
    }
}

class Claim {
    private int x;
    private int y;
    private int claims = 0;

    public Claim(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getClaims() {
        return claims;
    }

    public void setClaims(int claims) {
        this.claims = claims;
    }
}

public class OverlappingFabricTest {
    @Test
    public void shouldCount2OverlapsWhenTwoClaimsAreAtSamePosition() throws Exception {
        Fabric fabric = new Fabric();

        fabric.makeClaim(1,1);
        fabric.makeClaim(1,1);

        long overlappingClaims = fabric.getOverlappingClaims();

        assertEquals(1, overlappingClaims);
    }

    @Test
    public void shouldReturn4_When4ClaimsOverlap() throws Exception {
        Fabric fabric = new Fabric();

        // 1,3
        fabric.makeClaim(4,2);
        fabric.makeClaim(5,2);
        fabric.makeClaim(6,2);
        fabric.makeClaim(7,2);

        fabric.makeClaim(4,3);
        fabric.makeClaim(5,3);
        fabric.makeClaim(6,3);
        fabric.makeClaim(7,3);

        fabric.makeClaim(4,4);
        fabric.makeClaim(5,4);
        fabric.makeClaim(6,4);
        fabric.makeClaim(7,4);

        fabric.makeClaim(4,5);
        fabric.makeClaim(5,5);
        fabric.makeClaim(6,5);
        fabric.makeClaim(7,5);

        // 3,1
        fabric.makeClaim(2,4);
        fabric.makeClaim(3,4);
        fabric.makeClaim(4,4);
        fabric.makeClaim(5,4);

        fabric.makeClaim(2,5);
        fabric.makeClaim(3,5);
        fabric.makeClaim(4,5);
        fabric.makeClaim(5,5);

        fabric.makeClaim(2,6);
        fabric.makeClaim(3,6);
        fabric.makeClaim(4,6);
        fabric.makeClaim(5,6);

        fabric.makeClaim(2,7);
        fabric.makeClaim(3,7);
        fabric.makeClaim(4,7);
        fabric.makeClaim(5,7);

        // 5,5
        fabric.makeClaim(6,6);
        fabric.makeClaim(6,7);
        fabric.makeClaim(7,6);
        fabric.makeClaim(7,7);

        long overlappingClaims = fabric.getOverlappingClaims();

        assertEquals(4, overlappingClaims);
    }

    @Test
    public void shouldReturn0_WhenNoClaimsOverlap() throws Exception {
        Fabric fabric = new Fabric();

        fabric.makeClaim(4,2);
        fabric.makeClaim(4,3);

        long overlappingClaims = fabric.getOverlappingClaims();

        assertEquals(0, overlappingClaims);
    }

    @Test
    public void shouldReturn1_When1ClaimOverlaps() throws Exception {
        Fabric fabric = new Fabric();

        fabric.makeClaim(4,2);
        fabric.makeClaim(4,2);

        long overlappingClaims = fabric.getOverlappingClaims();

        assertEquals(1, overlappingClaims);
    }
}
