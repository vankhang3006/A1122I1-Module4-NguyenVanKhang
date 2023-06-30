package model.service;

public class Room extends Service{
    private String freeService;

    public Room() {
    }

    public Room(int id, String name, double area, double price, int maxPeople, String standardRoom, String description, int poolArea, int floorNumber, int rentTypeId, int serviceTypeId, String freeService) {
        super(id, name, area, price, maxPeople, standardRoom, description, poolArea, floorNumber, rentTypeId, serviceTypeId);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }


}
