package demo.EShopping.dataAccess;

import demo.EShopping.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorites, Long> {


    List<Favorites> findByUser_UserId(Long userId);
}
