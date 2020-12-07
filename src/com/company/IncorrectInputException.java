package com.company;

public class IncorrectInputException extends NumberFormatException{
    public IncorrectInputException() {super();}
    public IncorrectInputException(String s) {
        super (s);
    }

}
