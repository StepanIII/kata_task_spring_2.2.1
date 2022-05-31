package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru"));

      userService.addUser(new User("User5", "LastName5", "user5@mail.ru", new Car("BMW", 5)));
      userService.addUser(new User("User6", "LastName6", "user6@mail.ru", new Car("BMW", 6)));
      userService.addUser(new User("User7", "LastName7", "user7@mail.ru", new Car("BMW", 7)));
      userService.addUser(new User("User8", "LastName8", "user8@mail.ru", new Car("BMW", 8)));

      List<User> users = userService.getListUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      User user = userService.getUserByModelCarAndSeries("BMW", 5);
      System.out.println("Id = " + user.getId());
      System.out.println("First Name = " + user.getFirstName());
      System.out.println("Last Name = " + user.getLastName());
      System.out.println("Email = " + user.getEmail());
      System.out.println("Car = " + user.getCar());
      System.out.println();

      List<Car> cars = carService.getListCar();

      for (Car car : cars) {
         System.out.println(car);
      }

      carService.addCar(new Car("Porsche1", 1));
      carService.addCar(new Car("Porsche2", 2));
      carService.addCar(new Car("Porsche3", 3));


      List<Car> cars2 = carService.getListCar();

      for (Car car : cars2) {
         System.out.println(car);
      }


      context.close();
   }
}
