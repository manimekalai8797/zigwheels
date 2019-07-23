package com.kgisl.zigwheels.controller;

import java.util.List;

import com.kgisl.zigwheels.model.Car;
import com.kgisl.zigwheels.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Carcontroller
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/")
    public List<Car> getallcars() {
        return carService.getCars();
    }
}