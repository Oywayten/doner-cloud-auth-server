package doners.authorization;

import doners.authorization.users.User;
import doners.authorization.users.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.save(new User("habuma", passwordEncoder.encode("password"), "ROLE_ADMIN"));
            userRepository.save(new User("donerchef", passwordEncoder.encode("password"), "ROLE_ADMIN"));
        };
    }

}
