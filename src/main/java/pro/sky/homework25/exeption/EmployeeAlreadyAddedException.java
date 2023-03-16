package pro.sky.homework25.exeption;

public class EmployeeAlreadyAddedException extends RuntimeException{

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }

}
