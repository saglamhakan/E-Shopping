package demo.EShopping.responses;

import lombok.Data;

import java.util.Date;

@Data
public class GetAllUserResponse {

    private String userName;

    private int age;

    private Long userId;

    private Date birthDate;

  //  public GetUserResponse(User entity){
    //    this.userName=entity.getUserName();
      //  this.userId=entity.getUserId();
    }

