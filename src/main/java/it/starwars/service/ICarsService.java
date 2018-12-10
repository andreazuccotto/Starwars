/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.starwars.service;

import it.starwars.bean.Car;
import java.util.List;

public interface ICarsService {
    
    public List<Car> findAllCars();
    public Car findCar(Long id);
    public void saveCar(Car car);
}
