package com.ride_api.auth.repository;

import com.ride_api.auth.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
    Ride findByStart(String start);
    Ride findByTime(String time);
}
