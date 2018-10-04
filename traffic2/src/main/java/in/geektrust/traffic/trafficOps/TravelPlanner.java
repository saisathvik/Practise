package in.geektrust.traffic.trafficOps;

import in.geektrust.traffic.city.Areas;
import in.geektrust.traffic.city.Lebengaburu;
import in.geektrust.traffic.common.*;

import java.util.*;

public class TravelPlanner {
    private Orbit[] orbits;
    private Weather weather;
    private HashSet<Areas> areas = new HashSet<Areas>();
    private HashMap<Integer,Float> trafficSpeeds = new HashMap();
    private HashMap<TrafficParameters, EfficientOrbit> efficientOrbitHashMap =
            new HashMap<TrafficParameters, EfficientOrbit>();

    TravelPlanner(HashSet<Areas> areas){
        this.areas = areas;
        this.orbits = Lebengaburu.getOrbits(areas);
        getInputs();
        populateEfficientOrbitHashMap();
    }

    private void getInputs(){
        Scanner input = new Scanner(System.in);
        try {
            weather = Weather.parse(input.nextLine());
        } catch (InvalidWeatherException ex){
            System.err.print(ex);
        }

        for(int i = 0; i < this.orbits.length; i++){
            String orbitString = input.nextLine()
                                .replaceAll("[^0-9]+"," ");
            String[] orbitInfo = orbitString.trim().split(" ");
            trafficSpeeds.put(Integer.parseInt(orbitInfo[0]), Float.parseFloat(orbitInfo[1]));
        }
    }

    private void populateEfficientOrbitHashMap(){
        Route[] routes = Lebengaburu.getAllRoutes(areas);
        for(Vehicle vehicle: weather.getUsableVehicles()){
            for(Route route: routes){
                efficientOrbitHashMap.
                        put(new TrafficParameters(weather,vehicle,route), populateHelper(vehicle,route));
            }
        }
    }

    private EfficientOrbit populateHelper(Vehicle vehicle, Route route){
        Orbit[] orbits = Lebengaburu.getOrbits(route);
        Orbit efficientOrbit = orbits[0];
        Float minTime = (float) Integer.MAX_VALUE;
        for(Orbit orbit: orbits){
            Float tempTime = orbit.getTime2Travel(weather,vehicle,trafficSpeeds.get(orbit.getOrbitNumber()));
            if(tempTime < minTime){
                minTime = tempTime;
                efficientOrbit = orbit;
            }
        }
        return new EfficientOrbit(efficientOrbit, minTime);
    }

    private static void getPermutedPaths(ArrayList<Areas[]> possiblePermutations,Areas[] areas, int index){
        int length = areas.length;
        if(index >= length-1){
            possiblePermutations.add(areas);
            return;
        }

        for(int i = index; i < length; i++){
            Areas temp = areas[index];
            areas[index] = areas[i];
            areas[i] = temp;

            getPermutedPaths(possiblePermutations,areas.clone(),index+1);

            temp = areas[index];
            areas[index] = areas[i];
            areas[i] = temp;
        }
    }

    private ArrayList<Areas[]> getPossiblePaths(Areas startPoint,Areas[] areas){
        int length = areas.length+1;
        ArrayList<Areas[]> possiblePaths = new ArrayList<Areas[]>();
        ArrayList<Areas[]> possiblePermutations = new ArrayList<Areas[]>();
        getPermutedPaths(possiblePermutations,areas,0);
        for(Areas[] permutedPath: possiblePermutations){
            Areas[] possiblePath = new Areas[length];
            possiblePath[0] = startPoint;
            for(int i=1;i<length;i++){
                possiblePath[i] = permutedPath[i-1];
            }
            possiblePaths.add(possiblePath);
        }
        return possiblePaths;
    }

    public EfficientOrbit getEfficientOrbit(Vehicle vehicle, Areas pointA, Areas pointB){

        TrafficParameters trafficParameters = new TrafficParameters(weather, vehicle, pointA, pointB);
        return efficientOrbitHashMap.get(trafficParameters);
    }

    public EfficientOrbit getEfficientOrbit(Vehicle vehicle, Route route){

        TrafficParameters trafficParameters = new TrafficParameters(weather, vehicle, route);
        return efficientOrbitHashMap.get(trafficParameters);
    }

    public EfficientOrbit[] getEfficientOrbits(Vehicle vehicle,Areas[] areas){
        ArrayList<EfficientOrbit> efficientOrbits = new ArrayList<EfficientOrbit>();
        for(int i = 0; i < areas.length-1; i++){
            efficientOrbits.add(getEfficientOrbit(vehicle,areas[i],areas[i+1]));
        }
        return efficientOrbits.toArray(new EfficientOrbit[efficientOrbits.size()]);
    }

    public EfficientWay getEfficientWay(Areas startPoint, Areas[] destinations){

        if(!areas.contains(startPoint)){
            return new EfficientWay();
        }
        for(Areas area: destinations){
            if(!areas.contains(area)){
                return new EfficientWay();

            }
        }

        Vehicle effVehicle = Vehicle.CAR;
        EfficientOrbit[] bestPath = new EfficientOrbit[]{new EfficientOrbit(orbits[0],(float)0)};
        Float minTime = (float) Integer.MAX_VALUE;

        ArrayList<Areas[]> possiblePaths = getPossiblePaths(startPoint,destinations);

        for(Vehicle vehicle: weather.getUsableVehicles()){
            for(Areas[] areas: possiblePaths){
                EfficientOrbit[] efficientOrbits = getEfficientOrbits(vehicle,areas);
                Float tempTime = (float) 0;
                for(EfficientOrbit orbit: efficientOrbits){
                    tempTime = tempTime + orbit.getTime();
                }
                if(tempTime < minTime){
                    minTime = tempTime;
                    bestPath = efficientOrbits;
                    effVehicle = vehicle;
                }
            }
        }
        return new EfficientWay(effVehicle, bestPath,startPoint);
    }

}
