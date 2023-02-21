package demo.EShopping.requests;

import lombok.Data;

import java.util.Date;

@Data
public class AddUserRequest {

    //requestlerden ıd yi sil responselara ekle
    private int userId;

    private String userName;

    private String password;

    private String email;

   private int birthDate;

   private int age;
}

