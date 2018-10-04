package in.geektrust.traffic.city;

import in.geektrust.traffic.parameters.Orbit;


public class Lebengaburu {

    private static  Orbit[] orbits = new Orbit[]{
            new Orbit(1,18, 20, Areas.SILKDORB, Areas.HALLITHARAM),
            new Orbit(2, 20, 10, Areas.SILKDORB, Areas.HALLITHARAM),
    };

    public static Orbit[] getOrbits(){
        return orbits;
    }
}
