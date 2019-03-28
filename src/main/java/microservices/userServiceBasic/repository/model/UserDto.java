package microservices.userServiceBasic.repository.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import microservices.utils.emailServices;

@Entity
public class UserDto {

    private @Id
    @GeneratedValue
    long id;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String nationality;

    public UserDto() {
    }

    public UserDto(String name, String lastName) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.email = "-";
        this.address = "-";
        this.nationality = "-";
    }

    public UserDto(long id, String name, String lastName, String email, String address, String nationality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    // A user Id can't be changed

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {

        if (emailServices.isValidEmailAddress(email)) {
            this.email = email;
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}