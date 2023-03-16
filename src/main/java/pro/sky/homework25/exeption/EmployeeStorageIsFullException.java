package pro.sky.homework25.exeption;

public class EmployeeStorageIsFullException extends RuntimeException{

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }

}
