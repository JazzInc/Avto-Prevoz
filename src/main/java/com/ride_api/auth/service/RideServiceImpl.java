package com.ride_api.auth.service;

import com.ride_api.auth.model.Ride;
import com.ride_api.auth.repository.RideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    @Autowired
    private RideRepository rideRepository;

    @Override
    public void save(Ride ride) {
        rideRepository.save(ride);
    }

    @Override
    public Ride findByStart(String start) {
        return rideRepository.findByStart(start);
    }
    public Ride findByTime(String time) {
        return rideRepository.findByTime(time);
    }
}
