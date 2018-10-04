package in.geektrust.traffic.city;

public enum Areas {
    SILKDORB("Silk Dorb"),
    HALLITHARAM("Hallitharam"),
    RKPURAM("RK Puram");

    private final String name;

    Areas(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
