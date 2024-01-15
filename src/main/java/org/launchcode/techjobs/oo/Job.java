package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // Constructor to initialize the id field with a unique value.
    public Job() {
        id = nextId;
        nextId++;
    }
    // Second constructor that takes 5 parameters and assigns values to fields. It also calls the first constructor.
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this(); // Calling the first constructor to initialize the 'id' field.
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public static void resetNextId() {
        nextId = 1;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nName: " + (name != null && !name.isEmpty() ? name : "Data not available") +
                "\nEmployer: " + (employer != null && employer.getValue() != null && !employer.getValue().isEmpty() ? employer.getValue() : "Data not available") +
                "\nLocation: " + (location != null && location.getValue() != null && !location.getValue().isEmpty() ? location.getValue() : "Data not available") +
                "\nPosition Type: " + (positionType != null && positionType.getValue() != null && !positionType.getValue().isEmpty() ? positionType.getValue() : "Data not available") +
                "\nCore Competency: " + (coreCompetency != null && coreCompetency.getValue() != null && !coreCompetency.getValue().isEmpty() ? coreCompetency.getValue() : "Data not available") +
                "\n";
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.
    // Custom equals and hashCode methods. Considers two Job objects equal when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
