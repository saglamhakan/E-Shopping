package demo.EShopping.responses;

import demo.EShopping.entities.User;
import lombok.Data;

@Data
public class GetUserResponse {

    private String userName;

    private int userId;

    public GetUserResponse(User entity){
        this.userName=entity.getUserName();
        this.userId=entity.getUserId();
    }
}
