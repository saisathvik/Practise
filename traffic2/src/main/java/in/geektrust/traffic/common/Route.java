package in.geektrust.traffic.common;
/*
* Class to store two connected areas of an Orbit, irrespective of order
*/

import in.geektrust.traffic.city.Areas;

public class Route {
    private Areas pointA;
    private Areas pointB;

    public Route(Areas pointA, Areas pointB){
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public boolean checkPointInRoute(Areas point){
        if(point == pointA || point == pointB){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Areas getOtherPoint(Areas point){
        if(point == pointA){
            return pointB;
        }
        if(point == pointB) {
            return pointA;
        }
        return point;
    }

    @Override
    public  boolean equals(Object obj){
        Route route = (Route) obj;
        boolean result = (this.pointA == route.pointA && this.pointB == route.pointB)
                            || (this.pointB == route.pointA && this.pointA == route.pointB);
        return result;

    }

    @Override
    public int hashCode(){
        return pointA.hashCode()+pointB.hashCode();
    }

}
