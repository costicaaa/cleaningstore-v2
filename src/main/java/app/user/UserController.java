package app.user;

import app.util.Misc;
import org.mindrot.jbcrypt.*;
import static app.Application.userDao;

public class UserController {

    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        User user = userDao.getUserByEmail(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = Misc.hashPW(password);
        return hashedPassword.equals(user.getPassword());
    }

    // This method doesn't do anything, it's just included as an example
    public static void setPassword(String username, String oldPassword, String newPassword) {
        if (authenticate(username, oldPassword)) {
            String newHashedPassword = BCrypt.hashpw(Misc.salt, newPassword);
            // Update the user salt and password
        }
    }
}
