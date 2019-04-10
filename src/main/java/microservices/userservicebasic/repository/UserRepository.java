package microservices.userservicebasic.repository;

import microservices.userservicebasic.repository.model.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDto, UUID> {
}
