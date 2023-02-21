package demo.EShopping.service;

import demo.EShopping.dataAccess.FavoriteRepository;
import demo.EShopping.dataAccess.ProductRepository;
import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.entities.Category;
import demo.EShopping.entities.Favorites;
import demo.EShopping.mappers.ModelMapperService;
import demo.EShopping.requests.AddFavoriteRequest;
import demo.EShopping.responses.GetAllFavoriteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;

    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository,
                           ProductRepository productRepository, ModelMapperService modelMapperService,
                           UserRepository userRepository) {
        this.favoriteRepository = favoriteRepository;
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
        this.userRepository = userRepository;
    }

    public List<GetAllFavoriteResponse> getAllFavorites() {

        List<Favorites> favorites = favoriteRepository.findAll();

      List<GetAllFavoriteResponse> favoriteResponses=favorites.stream()
              .map(favorites1 -> this.modelMapperService.forResponse()
                      .map(favorites1, GetAllFavoriteResponse.class)).collect(Collectors.toList());

      return favoriteResponses;

        }



    public Favorites save(AddFavoriteRequest addFavoriteRequest) {

        Favorites favorites = this.modelMapperService.forRequest().map(addFavoriteRequest, Favorites.class);

        return favoriteRepository.save(favorites);
    }

    public void deleteById(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}
