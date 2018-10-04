package in.geektrust.traffic.common;
/*
*Class acts as a custom key type for a HashMap with EfficientOrbit as value,
*to reduce repeated calculations.
*/

import in.geektrust.traffic.city.Areas;

public class TrafficParameters {
    Weather weather;
    Vehicle vehicle;
    Route route;

    public TrafficParameters(Weather weather,Vehicle vehicle, Route route){
        this.weather = weather;
        this.vehicle = vehicle;
        this.route = route;
    }

    public TrafficParameters(Weather weather, Vehicle vehicle, Areas pointA, Areas pointB){
        this.weather = weather;
        this.vehicle = vehicle;
        this.route = new Route(pointA,pointB);
    }

    @Override
    public boolean equals(Object obj){
        TrafficParameters trafficParameters = (TrafficParameters) obj;

        return this.vehicle == trafficParameters.vehicle && this.weather == trafficParameters.weather
                && this.route.equals(trafficParameters.route);
    }

    @Override
    public int hashCode(){
        return weather.hashCode()+vehicle.hashCode()+route.hashCode();
    }
}
