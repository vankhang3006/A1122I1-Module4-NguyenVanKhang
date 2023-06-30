package model.Contract;

public class Contract {
    private int contractId;
    private String startDate;
    private String endDate;
    private double deposit;
    public Contract() {
    }

    public Contract(int contractId, String startDate, String endDate, double deposit) {
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;

    }

    public Contract(String startDate, String endDate, double deposit) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

}
