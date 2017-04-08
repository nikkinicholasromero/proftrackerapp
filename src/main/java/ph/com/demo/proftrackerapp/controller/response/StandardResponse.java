package ph.com.demo.proftrackerapp.controller.response;

import java.util.List;

/**
 * Created by nikkiromero on 08/04/2017.
 */
public class StandardResponse<T> {
    private String status;
    private T payload;
    private List<Error> errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "StandardResponse{" +
                "status='" + status + '\'' +
                ", payload=" + payload +
                ", errors=" + errors +
                '}';
    }
}
