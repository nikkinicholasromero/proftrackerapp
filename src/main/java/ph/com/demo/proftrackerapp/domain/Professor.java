package ph.com.demo.proftrackerapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nikkiromero on 22/03/2017.
 */
@Component
public class Professor {
    @Id
    @JsonIgnore
    private String _id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String profilePictureUrl;
    private String department;
    private List<Schedule> schedules;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "_id='" + _id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                ", department='" + department + '\'' +
                ", schedules=" + schedules +
                '}';
    }
}
