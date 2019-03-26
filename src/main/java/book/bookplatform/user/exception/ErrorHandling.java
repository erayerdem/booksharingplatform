package book.bookplatform.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandling {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException bindingResult, WebRequest request) {
        MyException myException = new MyException(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), bindingResult.getBindingResult().getFieldError().getDefaultMessage());
        System.out.println("invoked");
        return new ResponseEntity(myException, HttpStatus.BAD_REQUEST);
    }


}
