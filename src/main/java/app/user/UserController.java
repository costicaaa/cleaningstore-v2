package app.user;

import app.util.Misc;
import app.util.Path;
import app.util.ViewUtil;
import org.mindrot.jbcrypt.*;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static app.Application.*;
import static app.Application.serviceDao;
import static app.util.RequestUtil.getParamId;

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
//            String newHashedPassword = BCrypt.hashpw(Misc.salt, newPassword);
            // Update the user salt and password
        }
    }

    public static Route saveUser = (Request request, Response response) -> {
        //request params
        String name = request.queryParams("name");
        String email = request.queryParams("email");
        String password = request.queryParams("password");
        String role = request.queryParams("role");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(Misc.hashPW(password));
        user.setRole(Integer.parseInt(role));

        if(request.queryParams("password") == "yes")
        {
            userDao.update(user);
        }
        else
        {
            userDao.save(user);
        }
        //todo:: message

        Map<String, Object> model = new HashMap<>();
        response.redirect(Path.Web.USERS);
        return null;
    };

    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        List<User> users = userDao.getAllUsers();
        model.put("users", users);

        return ViewUtil.render(request, model, Path.Template.USERS);
    };

    public static Route serveViewPage = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();

        User user = userDao.getUserById(getParamId(request));
        model.put("user", user);

        return ViewUtil.render(request, model, Path.Template.USERS_VIEW);
    };


    public static Route serveAddPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.USERS_ADD);
    };
}
