package app.user;

import org.mindrot.jbcrypt.*;
import static app.Application.userDao;
import app.user.UserDao;

public class UserController {

    static String salt = "$2a$10$h.dl5J86rGH7I8bD9bZeZe";
    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String username, String password) {
//        if (username.isEmpty() || password.isEmpty()) {
//            System.out.println("\nceva empty");
//            return false;
//        }
        User user = userDao.getUserByUsername(username,password);
        if (user.getUsername() == null) {
            System.out.println("\nauthenticate failed");
            return false;
        }
        System.out.println("\nauthenticate succeded");

        user.setHashedPassword(BCrypt.hashpw(password, salt));
        System.out.println("Crypted pass:\n" + user.getHashedPassword());

        //String hashedPassword = BCrypt.hashpw(password, salt);
        //return hashedPassword.equals(user.getHashedPassword());

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
