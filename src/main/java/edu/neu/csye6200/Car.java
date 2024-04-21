package edu.neu.csye6200;

public class Car {

    public final String car_id;
    public final String car_name;
    public final String description;
    public final String price;

    public Car(String car_id, String car_name, String description, String price) {
        this.car_id = car_id;
        this.car_name = car_name;
        this.description = description;
        this.price = price;
    }

    public String getCar_id() {
        return car_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
