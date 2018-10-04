package in.geektrust.traffic.city;
/*
* Class acts as a map of a City
* */

import in.geektrust.traffic.common.Orbit;
import in.geektrust.traffic.common.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Lebengaburu {

    private static  Orbit[] orbits = new Orbit[]{
            new Orbit(1,18, 20, Areas.SILKDORB, Areas.HALLITHARAM),
            new Orbit(2, 20, 10, Areas.SILKDORB, Areas.HALLITHARAM),
            new Orbit(3, 30, 15, Areas.SILKDORB, Areas.RKPURAM),
            new Orbit(4, 15, 18, Areas.RKPURAM, Areas.HALLITHARAM)
    };

    private static HashMap<Route,HashSet<Orbit>> cityMap = new HashMap<Route, HashSet<Orbit>>();
    static {
        for(Orbit orbit: orbits){
            Route route = orbit.getRoute();
            if(cityMap.keySet().contains(route)){
                cityMap.get(route).add(orbit);
            }
            else{
                HashSet<Orbit> orbitSet = new HashSet<Orbit>();
                orbitSet.add(orbit);
                cityMap.put(route,orbitSet);
            }
        }
    }

    public static Route[] getAllRoutes(){
        return cityMap.keySet().toArray(new Route[cityMap.size()]);
    }


    // get all the routes(connected areas) in a set of areas
    public static Route[] getAllRoutes(Areas[] areas){
        ArrayList<Route> routes = new ArrayList<Route>();
        for(int i = 0; i < areas.length-1; i++){
            for(int j = i; j < areas.length; j++){
                Route route = new Route(areas[i],areas[j]);
                if(cityMap.keySet().contains(route)){
                    routes.add(route);
                }
            }
        }
        return routes.toArray(new Route[routes.size()]);
    }

    public static Route[] getAllRoutes(HashSet<Areas> areas){
        return getAllRoutes(areas.toArray(new Areas[areas.size()]));
    }


    public static Orbit[] getAllOrbits(){
        return orbits;
    }

    public static HashMap<Route,HashSet<Orbit>>  getCityMap(){
        return cityMap;
    }

    public static HashSet<Orbit> getOrbits(Areas pointA, Areas pointB){
        Route route = new Route(pointA,pointB);
        return  cityMap.get(route);
    }

    public static Orbit[] getOrbits(Route route){
        return cityMap.get(route).toArray(new Orbit[cityMap.get(route).size()]);
    }

    //get all orbits connecting a set of areas
    public static Orbit[] getOrbits(Areas[] targetDestinations){
        int length = targetDestinations.length;
        HashSet<Orbit> orbits = new HashSet<Orbit>();

        for(int i = 0; i < length-1; i++){
            for(int j = i+1; j < length; j++){
                orbits.addAll(getOrbits(targetDestinations[i], targetDestinations[j]));
            }
        }
        return orbits.toArray(new Orbit[orbits.size()]);
    }

    public static Orbit[] getOrbits(HashSet<Areas> areas){
        return getOrbits(areas.toArray(new Areas[areas.size()]));
    }

}
