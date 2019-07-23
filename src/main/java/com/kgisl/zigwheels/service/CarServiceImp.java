package com.kgisl.zigwheels.service;

import java.util.List;

import com.kgisl.zigwheels.model.Car;
import com.kgisl.zigwheels.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CarServiceImpl
 */
@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getCars() {
        System.out.println(""+carRepository.findAll());
        return carRepository.findAll();
    }

}