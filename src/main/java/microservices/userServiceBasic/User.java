package microservices.userServiceBasic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import microservices.utils.emailServices;

@Entity
public class User {

    private @Id
    @GeneratedValue
    long id;
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String nationality;

    public User() {
    }

    public User(String name, String lastName) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.email = "-";
        this.address = "-";
        this.nationality = "-";
    }

    public User(long id, String name, String lastName, String email, String address, String nationality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "User{" +
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
        //TODO set validations rules
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        //TODO set validations rules
    }

    public void setEmail(String email) {

        if (emailServices.isValidEmailAddress(email)) {
            this.email = email;
        }
        //TODO email validation else condition
    }

    public void setAddress(String address) {
        this.address = address;
        //TODO set validations rules
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
        //TODO validate nationality against a nationalities' list
    }
}