package in.geektrust.traffic.common;

public enum  Weather {

    SUNNY(-10, new Vehicle[]{Vehicle.BIKE, Vehicle.TUKTUK, Vehicle.CAR}),
    RAINY(20, new Vehicle[]{Vehicle.TUKTUK, Vehicle.CAR}),
    WINDY(0, new Vehicle[]{Vehicle.BIKE, Vehicle.CAR});

    private final int craterChange;
    private final Vehicle[] usableVehicles;

    Weather(int craterChange, Vehicle[] usableVehicles){
        this.craterChange = craterChange;
        this.usableVehicles = usableVehicles;
    }

    public float getCraterChangeFactor(){
        float changeFactor = (1 + ((float)craterChange/100) );
        return changeFactor;
    }

    public Vehicle[] getUsableVehicles(){
        return usableVehicles;
    }

    public static Weather parse(String weatherString) throws InvalidWeatherException{
        if(weatherString.endsWith("Sunny")){
            return SUNNY;
        }
        if(weatherString.endsWith("Windy")){
            return WINDY;
        }
        if(weatherString.endsWith("Rainy")){
            return RAINY;
        }
        else {
            throw new InvalidWeatherException("Invalid Weather entered: "+ weatherString);
        }
    }
}
