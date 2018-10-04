package in.geektrust.traffic.common;

import in.geektrust.traffic.city.Areas;

public class EfficientWay {
    private Areas startPoint;
    private EfficientOrbit[] efficientPath;
    private Vehicle vehicle;

    public EfficientWay(){

    }

    public EfficientWay(Vehicle vehicle, EfficientOrbit[] efficientPath, Areas startPoint){
        this.vehicle = vehicle;
        this.efficientPath = efficientPath;
        this.startPoint = startPoint;

    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        output.append("Vehicle "+vehicle.getName()+" to ");
        int i=0,pathLength = efficientPath.length;
        Areas currentPoint = startPoint;
        for(EfficientOrbit o: efficientPath){
            Areas point = o.getOrbit().getRoute().getOtherPoint(currentPoint);

            output.append(point.getName() +" via Orbit"+o.getOrbit().getOrbitNumber());
            if(i == pathLength-2){
                output.append(" and ");
            }
            else if(i < pathLength-2) {
                output.append(", ");
            }
            currentPoint = point;
            i = i+1;
        }
        return output.toString();
    }
}


