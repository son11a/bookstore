package sammi.bookstore1.domain;

import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}


    @Bean
public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests( authorize -> authorize
		.requestMatchers("/delete/**").hasRole("ADMIN")
		.anyRequest().authenticated()
	)
    .formLogin( formlogin -> formlogin
			.loginPage("/login")
			.defaultSuccessUrl("/booklist", true)
			.permitAll()
		);
	
	return http.build();
}

  @Bean
    CommandLineRunner loadUsers(UserRepository userRepository,
                                PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.findByUsername("user") == null) {

                User user = new User(
                        "user",
                        passwordEncoder.encode("password"),
                        "user@email.com",
                        "ROLE_USER"
                );

                User admin = new User(
                        "admin",
                        passwordEncoder.encode("admin"),
                        "admin@email.com",
                        "ROLE_ADMIN"
                );

                userRepository.save(user);
                userRepository.save(admin);

                
            }
        };
    }

}
