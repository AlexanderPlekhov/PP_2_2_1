package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Алексей", "Лёшин", "user1@mail.ru", new Car("Тойота", 123)));
      userService.add(new User("Василий", "Васин", "user2@mail.ru", new Car("Рено", 231)));
      userService.add(new User("Владимир", "Вовин", "user3@mail.ru", new Car("Фольцваген", 312)));
      userService.add(new User("Иван", "Иванов", "user4@mail.ru", new Car("Мерседес", 4132)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("Тойота", 123));
      context.close();
   }
}
