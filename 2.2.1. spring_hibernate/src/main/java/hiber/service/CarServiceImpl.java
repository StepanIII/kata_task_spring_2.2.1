package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional
    @Override
    public List<Car> getListCar() {
        return carDao.getListCar();
    }

    @Transactional
    @Override
    public Car getCarById(long id) {
        return carDao.getCarById(id);
    }

    @Transactional
    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    @Transactional
    @Override
    public void deleteCar(Car car) {
        carDao.deleteCar(car);
    }
}
