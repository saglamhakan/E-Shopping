package demo.EShopping.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super();
    }
    public ProductNotFoundException(String message){
        super(message);
    }
}
