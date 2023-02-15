package demo.EShopping.requests;

import lombok.Data;

import java.util.Date;

@Data
public class AddUserRequest {

    private int userId;

    private String userName;

    private String password;

    private String email;

   private int birthDate;

   private int age;
}

