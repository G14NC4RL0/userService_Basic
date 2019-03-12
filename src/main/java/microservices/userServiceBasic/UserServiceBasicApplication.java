package microservices.userServiceBasic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
class UserRestController {

	@RequestMapping("/users")
	Collection<User> AllUsers() {
		return this.userRepository.findAll();
	}

	@Autowired UserRepository userRepository;
}