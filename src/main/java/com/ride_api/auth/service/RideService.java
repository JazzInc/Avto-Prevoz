package com.ride_api.auth.service;

import com.ride_api.auth.model.Ride;

public interface RideService {
    void save(Ride ride);

    Ride findByStart(String start);
    Ride findByTime(String time);
}
