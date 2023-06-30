package model.attachService;

public class AttachService {
    private int attachServiceId;
    private String attachServiceName;
    private String unit;
    private double price;

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, String unit, double price) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.unit = unit;
        this.price = price;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
