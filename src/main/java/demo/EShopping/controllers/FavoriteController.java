package demo.EShopping.controllers;

import demo.EShopping.entities.Favorites;
import demo.EShopping.requests.AddFavoriteRequest;
import demo.EShopping.responses.GetAllFavoriteResponse;
import demo.EShopping.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteservice;

    @Autowired
    FavoriteController(FavoriteService favoriteservice){
        this.favoriteservice=favoriteservice;
    }

    @GetMapping("/getAll")
    public List<GetAllFavoriteResponse> getAll(){
        return favoriteservice.getAllFavorites();
    }

    @PostMapping("/add")
    public Favorites add(@RequestBody AddFavoriteRequest addFavoriteRequest){
        return favoriteservice.save(addFavoriteRequest);
    }

    @DeleteMapping("/deleteById")
    public void deleteOneFavorites(@RequestParam Long favoriteId){
         favoriteservice.deleteById(favoriteId);
    }
}
