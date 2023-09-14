package demo.EShopping.requests;

import lombok.Data;

@Data
public class LoginRequest {

    //   int userId;
    private String email;
    private String password;

}
