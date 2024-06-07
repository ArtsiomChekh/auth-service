package repository;

import com.github.artsiomchekh.MySpringBootApp;
import com.github.artsiomchekh.model.User;
import com.github.artsiomchekh.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Collections;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertTrue;

@SpringBootTest(classes = MySpringBootApp.class)
public class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void findByUserTest() {
        User user = new User();
        user.setUsername("antoni");
        user.setPassword("pass123");
        user.setEmail("examplemail@test.com");
        user.setRoles(Collections.singletonList("ROLE_USER"));
        mongoTemplate.save(user);

        Optional<User> foundUser = userRepo.findByUsername("antoni");

        assertTrue(foundUser.isPresent());
    }
}
