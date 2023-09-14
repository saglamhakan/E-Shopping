package demo.EShopping.rules;

import demo.EShopping.dataAccess.UserRepository;
import demo.EShopping.exception.BusinessException;
import demo.EShopping.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    @Autowired
    private UserRepository userRepository;

    public void existsByUsername(String username){
        if (this.userRepository.existsByUsername(username)){
            throw new UserNotFoundException("User already available");
        }

    }

    public void existsByEmail(String email){
        if (this.userRepository.existsByEmail(email)){
            throw new BusinessException("Email already available");
        }
    }

    public void addPassword(String password){
        if (password.length()<5){
            throw new BusinessException("password cannot be less than 5 characters");
        }
    }
}
