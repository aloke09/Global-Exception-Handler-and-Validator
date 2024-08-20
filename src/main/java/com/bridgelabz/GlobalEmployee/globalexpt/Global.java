package com.bridgelabz.GlobalEmployee.globalexpt;

import com.bridgelabz.GlobalEmployee.DTO.responseDTO;
import com.bridgelabz.GlobalEmployee.except.CustomeExept;
import com.bridgelabz.GlobalEmployee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Global
{
    @ExceptionHandler(CustomeExept.class)
    public responseDTO<Employee> handleCustomExceptioninput(CustomeExept ex) {
        responseDTO<Employee> errorResponse = new responseDTO<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null
        );
        System.out.println("Custom Exception Occurred: " + ex.getMessage());
        return errorResponse;
    }
    @ExceptionHandler(CustomeExept.class)
    public responseDTO<Employee> handleCustomExceptionById(CustomeExept ex) {
        responseDTO<Employee> errorResponse = new responseDTO<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null
        );
        System.out.println("Custom Exception Occurred: " + ex.getMessage());
        return errorResponse;
    }
    @ExceptionHandler(CustomeExept.class)
    public responseDTO<Employee> handleCustomExceptiongetAll(CustomeExept ex) {
        responseDTO<Employee> errorResponse = new responseDTO<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null
        );
        System.out.println("Custom Exception Occurred: " + ex.getMessage());
        return errorResponse;
    }
    @ExceptionHandler(CustomeExept.class)
    public responseDTO<Employee> handleCustomExceptionUpdateById(CustomeExept ex) {
        responseDTO<Employee> errorResponse = new responseDTO<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null
        );
        System.out.println("Custom Exception Occurred: " + ex.getMessage());
        return errorResponse;
    }
    @ExceptionHandler(CustomeExept.class)
    public responseDTO<Employee> handleCustomExceptionDelById(CustomeExept ex) {
        responseDTO<Employee> errorResponse = new responseDTO<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null
        );
        System.out.println("Custom Exception Occurred: " + ex.getMessage());
        return errorResponse;
    }
}
