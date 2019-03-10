package microservices.userServiceBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@SpringBootApplication
public class UserServiceBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceBasicApplication.class, args);
	}

}

@Component
class UserCLR implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {

		for (User u : this.userRepository.findAll()) {
			System.out.println(u.toString());
		}
	}

	@Autowired UserRepository userRepository;
}

interface UserRepository extends JpaRepository<User, Long> {

	Collection<User> findByLastName(String lastName);
}

@Entity
class User {

	private @Id @GeneratedValue long id;
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

//	public User(long id, String name, String lastName, String email, String address, String nationality) {
//		this.id = id;
//		this.name = name;
//		this.lastName = lastName;
//		this.email = email;
//		this.address = address;
//		this.nationality = nationality;
//	}

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
}