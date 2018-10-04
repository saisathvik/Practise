package in.geektrust.traffic.common;

import in.geektrust.traffic.city.Areas;


public class Orbit {
    private static final int MINUTES_PER_HOUR = 60;
    private final int orbitNumber;
    private final int distance;
    private final int noOfCraters;
    private final Route route;

    public Orbit(int orbitNumber, int distance, int noOfCraters, Areas pointA, Areas pointB){
        this.orbitNumber = orbitNumber;
        this.distance = distance;
        this.noOfCraters = noOfCraters;
        this.route = new Route(pointA,pointB);
    }

    public int getOrbitNumber(){
        return orbitNumber;
    }

    public int getDistance(){
        return distance;
    }

    public int getNoOfCraters(){
        return noOfCraters;
    }

    public Route getRoute(){
        return route;
    }

    public float getTime2Travel(Weather weather, Vehicle vehicle, Float trafficSpeed){
        float speed = (vehicle.getSpeed() < trafficSpeed) ? vehicle.getSpeed() : trafficSpeed;
        float time = (MINUTES_PER_HOUR*distance/speed)
                    + (noOfCraters*weather.getCraterChangeFactor()*vehicle.getTime2CrossCrater());
        return time;
    }
}
