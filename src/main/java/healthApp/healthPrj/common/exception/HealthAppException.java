package healthApp.healthPrj.common.exception;

import org.springframework.http.HttpStatus;

public class HealthAppException extends RuntimeException{

    private final ErrorCode errorCode;

    public HealthAppException(ErrorCode errorCode) {
        super(errorCode.detail());
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode(){
        return this.errorCode;
    }

    public HttpStatus status(){
        return errorCode.httpStatus();
    }

}
