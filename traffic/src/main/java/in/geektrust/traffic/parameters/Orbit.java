package in.geektrust.traffic.parameters;

import in.geektrust.traffic.city.Areas;

import java.util.Comparator;

public class Orbit {
    private final int orbitNumber;
    private final int distance;
    private final int noOfCraters;
    private final Areas poinA, pointB;

    public static Comparator<Orbit> OrbitNumberComparator = new Comparator<Orbit>() {
        public int compare(Orbit o1, Orbit o2) {
            return o1.getOrbitNumber()-o2.getOrbitNumber();
        }
    };


    public Orbit(int orbitNumber, int distance, int noOfCraters, Areas pointA, Areas pointB){
        this.orbitNumber = orbitNumber;
        this.distance = distance;
        this.noOfCraters = noOfCraters;
        this.poinA = pointA;
        this.pointB = pointB;
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

    public Areas[] getEndPoints(){
        return new Areas[]{poinA, pointB};
    }

    public float getTime2Travel(Weather weather, Vehicle vehicle, Float trafficSpeed){
        float speed = (vehicle.getSpeed() < trafficSpeed) ? vehicle.getSpeed() : trafficSpeed;
        float time = (60*distance/speed)
                    + (noOfCraters*weather.getCraterChangeFactor()*vehicle.getTime2CrossCrater());
        return time;
    }
}
