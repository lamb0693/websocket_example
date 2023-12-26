package ldw.com.example.websocketexample.config;

import ldw.com.example.websocketexample.service.MemberUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@Log4j2
public class SecurityConfig {
    private MemberUserDetailsService memberUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( (request) -> {
                    request.requestMatchers("/", "/testMember").permitAll()
                            .requestMatchers("/auth/login").permitAll()
                            .anyRequest().authenticated();
                })
                .userDetailsService(memberUserDetailsService)
                .httpBasic(
                        AbstractHttpConfigurer::disable
                )
                .formLogin( form -> {
                    form.loginPage("/auth/login")
                            .defaultSuccessUrl("/");
                });

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
