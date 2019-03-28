package microservices.userServiceBasic;

import lombok.extern.slf4j.Slf4j;
import microservices.userServiceBasic.repository.UserRepository;
import microservices.userServiceBasic.repository.model.UserDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class Database {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new UserDto("Gian", "Tedesco")));
            log.info("Preloading " + repository.save(new UserDto("Paulo", "Fernandes")));
        };
    }
