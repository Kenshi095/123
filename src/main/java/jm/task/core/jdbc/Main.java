package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try {
            userService.createUsersTable();

            userService.saveUser("Иван", "Иванов", (byte) 25);
            userService.saveUser("Петр", "Петров", (byte) 30);
            userService.saveUser("Сергей", "Сергеев", (byte) 35);
            userService.saveUser("Алексей", "Алексеев", (byte) 40);

            for (User user : userService.getAllUsers()) {
                System.out.println(user);
            }

            userService.cleanUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}