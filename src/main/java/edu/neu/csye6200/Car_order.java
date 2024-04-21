package edu.neu.csye6200;

public class Car_order {

    public final String car_id;
    public final int price;

    public Car_order(String car_id, int price) {
        this.car_id = car_id;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getCar_id() {
        return car_id;
    }
}
