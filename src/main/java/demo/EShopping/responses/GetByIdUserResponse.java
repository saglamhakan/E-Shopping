package demo.EShopping.responses;

import lombok.Data;

@Data
public class GetByIdUserResponse {

   private int userId;

   private String userName;

   private String email;
}
