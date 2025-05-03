package controller;

import dao.UserDAO;
import model.User;

public class AuthController {

    private final UserDAO userDAO = new UserDAO(); /* Invoke the UserDAO to Connect */
    public boolean register(String username, String plainPassword) {
        User user = new User(0, username, plainPassword, "user");
        /*  */
        return userDAO.registerUser(user);
    }
    
    public User login(String username, String plainPassword) {
        User user = userDAO.loginUser(username);
        /* Check the user data is not null and check the password is equal */
        if (user != null && user.getPassword().equals(plainPassword)) {
            return user;
        }
        /* If not User data extract means return null */
        return null;
    }
    
}
