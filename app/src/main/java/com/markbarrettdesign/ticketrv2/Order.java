package com.markbarrettdesign.ticketrv2;

/**
 * Created by markbarrett on 20/04/2017.
 */

public class Order {
    String order_number;
    int ticket;
    int event;
    int user;
    String order_code;
    boolean used;
    boolean for_sale;

    public Order(String order_number, int ticket, int event, int user, String order_code, boolean used, boolean for_sale) {
        this.order_number = order_number;
        this.ticket = ticket;
        this.event = event;
        this.user = user;
        this.order_code = order_code;
        this.used = used;
        this.for_sale = for_sale;
    }
}
