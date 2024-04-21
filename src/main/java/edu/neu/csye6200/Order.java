package edu.neu.csye6200;

public class Order {

    public final String Order_No;
    public final String Order_date;
    public final String item_id;
    public final String Customer_id;
    public final String Quantity;
    public final String Price;
    public final String Discount;
    public final String Amount;

    public Order(String order_No, String order_date, String item_id, String customer_id, String quantity, String price, String discount, String amount) {
        Order_No = order_No;
        Order_date = order_date;
        this.item_id = item_id;
        Customer_id = customer_id;
        Quantity = quantity;
        Price = price;
        Discount = discount;
        Amount = amount;
    }

    public String getOrder_No() {
        return Order_No;
    }

    public String getOrder_date() {
        return Order_date;
    }

    public String getItem_id() {
        return item_id;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getPrice() {
        return Price;
    }

    public String getDiscount() {
        return Discount;
    }

    public String getAmount() {
        return Amount;
    }
}
