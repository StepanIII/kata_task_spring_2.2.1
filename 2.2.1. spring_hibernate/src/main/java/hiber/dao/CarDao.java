package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    void addCar(Car car);
    List<Car> getListCar();
    Car getCarById(long id);
    void updateCar(Car car);
    void deleteCar(Car car);
}
