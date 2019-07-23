package com.kgisl.zigwheels.repository;

import com.kgisl.zigwheels.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CarRepository
 */
public interface CarRepository extends JpaRepository<Car,Long>{

    
}
