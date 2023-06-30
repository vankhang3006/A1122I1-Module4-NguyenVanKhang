package model.service;

public class House extends Service{
    private String standardRoom;
    private String convenience;
    private int numberOfFloors;

    public House() {
    }

    public House(int id, String name, double area, double price, int maxPeople, String standardRoom, String description, int poolArea, int floorNumber, int rentTypeId, int serviceTypeId, String standardRoom1, String convenience, int numberOfFloors) {
        super(id, name, area, price, maxPeople, standardRoom, description, poolArea, floorNumber, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom1;
        this.convenience = convenience;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
