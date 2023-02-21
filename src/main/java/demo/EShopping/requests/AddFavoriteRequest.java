package demo.EShopping.requests;



import lombok.Data;

@Data
public class AddFavoriteRequest {

    private Long favoriteId;

    private int productId;

    private Long userId;



}
