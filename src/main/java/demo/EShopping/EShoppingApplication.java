package demo.EShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
public class EShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShoppingApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(Exception exception){

		return "Hata: " + exception.getMessage();
	}


}
