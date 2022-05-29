package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getListCar() {
        return sessionFactory.getCurrentSession().createQuery("from Car").getResultList();
    }

    @Override
    public Car getCarById(long id) {
        return sessionFactory.getCurrentSession().get(Car.class, id);
    }

    @Override
    public void updateCar(Car car) {
        sessionFactory.getCurrentSession().update(car);
    }

    @Override
    public void deleteCar(Car car) {
        sessionFactory.getCurrentSession().delete(car);
    }
}
