package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> getListCar();
    Car getCarById(long id);
    void updateCar(Car car);
    void deleteCar(Car car);
}
