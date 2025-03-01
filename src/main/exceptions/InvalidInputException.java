package exceptions;

// a class representing an exception for invalid user inputs
public class InvalidInputException extends Exception {

    // constructs an exception
    public InvalidInputException() {
    }

    public InvalidInputException(String input) {
        super(input);
    }
}

//