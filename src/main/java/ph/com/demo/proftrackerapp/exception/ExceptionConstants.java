package ph.com.demo.proftrackerapp.exception;

/**
 * Created by nikkiromero on 23/03/2017.
 */
public enum ExceptionConstants {
    MISSING_PROFESSOR_ID("Missing professor ID. "),
    MISSING_FIRST_NAME("Missing first name. "),
    MISSING_LAST_NAME("Missing last name. "),
    MISSING_BIRTH_DATE("Missing birth date. "),
    PROFESSOR_DOES_NOT_EXIST("Professor does not exist. "),
    PROFESSOR_ALREADY_EXISTS("Professor already exists. "),
    PROFESSOR_RECORD_IS_OUTDATED("Professor record is outdated. ");

    private String message;

    ExceptionConstants(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
