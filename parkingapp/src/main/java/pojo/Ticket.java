package pojo;

import java.util.Date;

public class Ticket {
    private Integer number_hours;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private Integer amount;
    private Boolean isActive;

    public Ticket(Vehicle vehicle, ParkingSlot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.isActive=true;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getNumber_hours() {
        return number_hours;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public void setNumber_hours(Integer number_hours) {
        this.number_hours = number_hours;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
