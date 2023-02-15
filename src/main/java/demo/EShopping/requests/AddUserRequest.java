package demo.EShopping.requests;

import lombok.Data;

@Data
public class AddUserRequest {

    private int userId;

    private String userName;

    private String password;
}
