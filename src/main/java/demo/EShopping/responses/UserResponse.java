package demo.EShopping.responses;

import demo.EShopping.entities.User;
import lombok.Data;

@Data
public class UserResponse {

    private String userName;

    private int userId;

    public UserResponse(User entity){
        this.userName=entity.getUserName();
        this.userId=entity.getUserId();
    }
}
