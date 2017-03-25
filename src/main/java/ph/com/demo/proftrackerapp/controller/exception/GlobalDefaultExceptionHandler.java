package ph.com.demo.proftrackerapp.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ph.com.demo.proftrackerapp.controller.exception.domain.ExceptionMessage;
import ph.com.demo.proftrackerapp.exception.ProfTrackerAppException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nikkiromero on 23/03/2017.
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionMessage defaultErrorHandler(HttpServletRequest req, Exception e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setStatus(500);
        exceptionMessage.setException(e.getClass().toString());
        exceptionMessage.setMessage(e.getMessage());
        return exceptionMessage;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProfTrackerAppException.class)
    public ExceptionMessage profTrackerAppExceptionHandler(HttpServletRequest req, ProfTrackerAppException e) {
        ExceptionMessage exceptionMessage = new ExceptionMessage();
        exceptionMessage.setStatus(400);
        exceptionMessage.setException(e.getClass().toString());
        exceptionMessage.setMessage(e.getMessage());
        return exceptionMessage;
    }
}
