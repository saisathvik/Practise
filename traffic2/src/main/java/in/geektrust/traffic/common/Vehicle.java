package in.geektrust.traffic.common;

public enum Vehicle {

    BIKE(10,2,"Bike"),
    TUKTUK(12,1,"TukTuk"),
    CAR(20,3,"Car");

    private final int speed;
    private final int time2CrossCrater;
    private final String name;

    Vehicle(int speed, int time2CrossCrater, String name){
        this.speed = speed;
        this.time2CrossCrater = time2CrossCrater;
        this.name = name;
    }

    public int getSpeed(){
        return speed;
    }

    public int getTime2CrossCrater(){
        return time2CrossCrater;
    }

    public String getName(){
        return name;
    }
}
