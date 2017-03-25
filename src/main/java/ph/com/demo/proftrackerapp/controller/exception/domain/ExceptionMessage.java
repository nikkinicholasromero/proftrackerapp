package ph.com.demo.proftrackerapp.controller.exception.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by nikkiromero on 23/03/2017.
 */
public class ExceptionMessage {
    private int status;
    private String exception;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ExceptionMessage that = (ExceptionMessage) o;

        return new EqualsBuilder()
                .append(status, that.status)
                .append(exception, that.exception)
                .append(message, that.message)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(status)
                .append(exception)
                .append(message)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ExceptionMessage{" +
                "status=" + status +
                ", exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
