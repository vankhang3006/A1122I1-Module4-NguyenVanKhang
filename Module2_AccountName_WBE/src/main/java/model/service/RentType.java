package model.service;

public class RentType {
    private int rentTypeId;
    private String rentTypeName;
    private int rentTypeDuration;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, int rentTypeDuration) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeDuration = rentTypeDuration;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public int getRentTypeDuration() {
        return rentTypeDuration;
    }

    public void setRentTypeDuration(int rentTypeDuration) {
        this.rentTypeDuration = rentTypeDuration;
    }
}
