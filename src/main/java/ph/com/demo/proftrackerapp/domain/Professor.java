package ph.com.demo.proftrackerapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by nikkiromero on 22/03/2017.
 */
@Component
public class Professor {
    @Id
    @JsonIgnore
    private String _id;
    private String professorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    @JsonIgnore
    private boolean deleted;
    @JsonIgnore
    private LocalDateTime dateCreated;
    @JsonIgnore
    private LocalDateTime dateModified;
    private long revisionNumber;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public long getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(long revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        return new EqualsBuilder()
                .append(deleted, professor.deleted)
                .append(revisionNumber, professor.revisionNumber)
                .append(_id, professor._id)
                .append(professorId, professor.professorId)
                .append(firstName, professor.firstName)
                .append(middleName, professor.middleName)
                .append(lastName, professor.lastName)
                .append(birthDate, professor.birthDate)
                .append(dateCreated, professor.dateCreated)
                .append(dateModified, professor.dateModified)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(_id)
                .append(professorId)
                .append(firstName)
                .append(middleName)
                .append(lastName)
                .append(birthDate)
                .append(deleted)
                .append(dateCreated)
                .append(dateModified)
                .append(revisionNumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Professor{" +
                "_id='" + _id + '\'' +
                ", professorId='" + professorId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", deleted=" + deleted +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", revisionNumber=" + revisionNumber +
                '}';
    }
}
