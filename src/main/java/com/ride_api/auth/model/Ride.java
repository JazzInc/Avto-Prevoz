package com.ride_api.auth.model;

import javax.persistence.*;

@Entity
@Table(name = "ride")
public class Ride {
    private Long id;
    private String start;
    private String destination;
    private String time;
    private String seats;
    private String price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeats() { return seats; }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getPrice() { return price; }

    public void setPrice(String price) {
        this.price = price;
    }
}
