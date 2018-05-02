package app.user;

import org.mindrot.jbcrypt.*;
import static app.Application.userDao;

public class UserController {

    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String username, String password) {
        System.out.println("\nauthenticate");
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("\nceva empty");
            return false;
        }
        User user = userDao.getUserByUsername(username,password);
        if (user.getEmail() == null) {
            System.out.println("getUser failed");
            return false;
        }
        //String hashedPassword = BCrypt.hashpw(password, user.getSalt());
        //return hashedPassword.equals(user.getHashedPassword());
        System.out.println(user.getName()+user.getRole()+user.getEmail()+user.getPassword());

        //return password.equals(user.getPassword());
        return true;
    }

    // This method doesn't do anything, it's just included as an example
    public static void setPassword(String username, String oldPassword, String newPassword) {
        if (authenticate(username, oldPassword)) {
            String newSalt = BCrypt.gensalt();
            String newHashedPassword = BCrypt.hashpw(newSalt, newPassword);
            // Update the user salt and password
        }
    }
}
