package com.StudentsApp.StudentsApp.exceptions;

public class StudentAlreadyExistException extends RuntimeException{

    public StudentAlreadyExistException (String message) {
        super(message);
    }
}
