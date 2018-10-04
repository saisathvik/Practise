package in.geektrust.traffic.trafficOps;

import in.geektrust.traffic.city.Areas;
import in.geektrust.traffic.common.EfficientWay;

import java.util.HashSet;

public class Traffic {

    public static void main(String[] args){

        Areas startPoint = Areas.SILKDORB;
        Areas[] destinations = new Areas[] {Areas.RKPURAM, Areas.HALLITHARAM};

        HashSet<Areas> areas = new HashSet<Areas>();
        areas.add(startPoint);
        for(Areas point: destinations){
            areas.add(point);
        }

        TravelPlanner travelPlanner = new TravelPlanner(areas);

        EfficientWay efficientWay = travelPlanner.getEfficientWay(startPoint, destinations);
        System.out.println(efficientWay.toString());
    }

}
