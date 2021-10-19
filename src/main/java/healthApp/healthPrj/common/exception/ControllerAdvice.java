package healthApp.healthPrj.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(HealthAppException.class)
    protected ResponseEntity<?> handleException(HealthAppException exception){
        exception.printStackTrace();

        return ResponseEntity.status(exception.status())
                .body(ErrorResponse.toResponseEntity(exception.errorCode()));
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<?> handleException(RuntimeException exception){
        exception.printStackTrace();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.toResponseEntity(ErrorCode.INTERNAL_ERROR));
    }


}
