package model;

public class Path {
    private String fromLocation;
    private String toLocation;
    private int weight;
    public String getFromLocation() {
        return fromLocation;
    }
    public String getToLocation() {
        return toLocation;
    }
    public int getWeight() {
        return weight;
    }
    public Path(String fromLocation, String toLocation, int weight) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "model.Path{" +
                "fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", weight=" + weight +
                '}';
    }

}
