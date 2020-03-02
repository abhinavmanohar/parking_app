package pojo;

public class Vehicle {
    String registration_number;
    String color;

    public Vehicle(String registration_number, String color) {
        this.registration_number = registration_number;
        this.color = color;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
