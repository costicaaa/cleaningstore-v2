package app.user;

import lombok.*;

// All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class User {
    private int id;
    private String name;
    private String email;
    private int role;
    private String password;
    String salt;
    String hashedPassword;

    User() {
        System.out.println("user constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return "$2a$10$h.dl5J86rGH7I8bD9bZeZe";
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
