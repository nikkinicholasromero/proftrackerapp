package ph.com.demo.proftrackerapp.exception;

/**
 * Created by nikkiromero on 23/03/2017.
 */
public class ProfTrackerAppException extends RuntimeException {
    public ProfTrackerAppException(ExceptionConstants message) {
        super(message.toString());
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
