package pro.sky.homework25.exeption;

public class EmployeeWrongTextEntryException extends RuntimeException {

    public EmployeeWrongTextEntryException(String message) {
        super(message);
    }
}
