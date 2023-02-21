package demo.EShopping.requests;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private int userId;

    private String userName;
    private String password;

    private String email;

    private int birthDate;

    private int age;
}
