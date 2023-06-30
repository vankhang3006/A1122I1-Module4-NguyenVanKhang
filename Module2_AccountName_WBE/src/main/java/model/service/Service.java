package model.service;

public class Service {
    private int id;
    private String name;
    private double area;
    private double price;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private int poolArea;
    private int floorNumber;
    private int serviceTypeId;
    private int rentTypeId;

    public Service() {
    }

    public Service(int id, String name, double area, double price, int maxPeople, String standardRoom, String description, int poolArea, int floorNumber, int rentTypeId, int serviceTypeId) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
        this.serviceTypeId = serviceTypeId;
        this.rentTypeId = rentTypeId;
    }

    public Service(String name, double area, double price, int maxPeople, String standardRoom, String description, int poolArea, int floorNumber, int rentTypeId, int serviceTypeId) {
        this.name = name;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
        this.serviceTypeId = serviceTypeId;
        this.rentTypeId = rentTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standarRoom) {
        this.standardRoom = standarRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

}
