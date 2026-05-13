package entity;

public class Candidate {
    private String locationId;
    private int priorityScore;
    public String getLocationId() {
        return locationId;
    }
    public int getPriorityScore() {
        return priorityScore;
    }
    public Candidate(String locationId, int priorityScore) {
        this.locationId = locationId;
        this.priorityScore = priorityScore;
    }

    @Override
    public String toString() {
        return "model.Candidate{" +
                "locationId='" + locationId + '\'' +
                ", priorityScore=" + priorityScore +
                '}';
    }
}
