package demo.EShopping.dataAccess;

import demo.EShopping.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByUserName(String username);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

}
