package in.geektrust.traffic.common;

import in.geektrust.traffic.common.Orbit;

public class EfficientOrbit{
    private Orbit orbit;
    private Float effTime;

    public EfficientOrbit(Orbit orbit, Float effTime){
        this.orbit = orbit;
        this.effTime = effTime;
    }

    public Float getTime() {
        return effTime;
    }

    public Orbit getOrbit() {
        return orbit;
    }
}
