package demo.EShopping.requests;

import lombok.Data;

@Data
public class UpdateUserRequest {

    private String userName;
    private String password;

    private String email;

    private int birthDate;

    private int age;
}
