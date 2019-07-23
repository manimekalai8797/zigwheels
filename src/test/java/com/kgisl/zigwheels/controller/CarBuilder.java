package com.kgisl.zigwheels.controller;

import com.kgisl.zigwheels.model.Car;

/**
 * CarBuilder
 */
public class CarBuilder {

    Car car = new Car();

    public CarBuilder id(Long id) {
        car.setId(id);
        return this;
    }

    public CarBuilder name(String name) {
        car.setName(name);
        return this;
    }

    public Car build() {
        return this.car;
    }
}