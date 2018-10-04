package in.geektrust.traffic.city;

import in.geektrust.traffic.parameters.*;

import java.util.HashMap;
import java.util.Scanner;

public class EfficientRoute {

    private Weather weather;
    private HashMap<Orbit, Float> trafficSpeeds;

    EfficientRoute(Weather weather, HashMap<Orbit,Float> trafficSpeeds){
        this.weather = weather;
        this.trafficSpeeds = trafficSpeeds;

    }

    public String getEfficientWay(){
        Vehicle efficientVehicle = Vehicle.BIKE;
        Orbit efficientOrbit = Lebengaburu.getOrbits()[0];
        float minTime = (float) Integer.MAX_VALUE;
        for(Vehicle vehicle: weather.getUsableVehicles()){
            for(Orbit orbit: trafficSpeeds.keySet()){
                float tempTime = orbit.getTime2Travel(weather,vehicle,trafficSpeeds.get(orbit));
                if(minTime > tempTime){
                    minTime = tempTime;
                    efficientOrbit = orbit;
                    efficientVehicle = vehicle;
                }
            }
        }
        return "Vehicle "+efficientVehicle.getName()+" on Orbit"+efficientOrbit.getOrbitNumber();
    }

    public static void main(String[] args){
        Areas fromArea = Areas.SILKDORB;
        Areas toArea = Areas.HALLITHARAM;

        HashMap<Orbit,Float> trafficSpeeds = new HashMap();
        Orbit[] orbits = Lebengaburu.getOrbits();

        Weather weather;
        Scanner input = new Scanner(System.in);

        String weatherInfo = input.nextLine();
        if(weatherInfo.endsWith("Sunny")){
            weather = Weather.SUNNY;
        }
        else if(weatherInfo.endsWith("Windy")){
            weather = Weather.WINDY;
        }
        else{
            weather = Weather.RAINY;
        }

        for(int i = 0; i < orbits.length; i++){
            trafficSpeeds.put(orbits[i],Float.parseFloat(input.nextLine().split(" ")[4]));
        }

        EfficientRoute route = new EfficientRoute(weather, trafficSpeeds);
        System.out.println(route.getEfficientWay());

    }
}
