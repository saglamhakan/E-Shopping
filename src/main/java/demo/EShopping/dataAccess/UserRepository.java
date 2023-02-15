package demo.EShopping.dataAccess;

import demo.EShopping.entities.User;
import demo.EShopping.responses.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}
