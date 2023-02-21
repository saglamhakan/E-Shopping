package demo.EShopping.responses;

import demo.EShopping.entities.Favorites;
import lombok.Data;

@Data
public class GetAllFavoriteResponse {

    private Long favoriteId;
    private int productId;

    private Long userId;




}
