package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration


@EnableMethodSecurity
//This annotation enables Spring Security's method-level security, allowing you to 
//secure methods with annotations

public class SecurityConfig {
	
	

    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }
    //A constructor for the SecurityConfig class that takes a UserDetailsService 
    //as an argument and initializes the corresponding field.

    @Bean
    //
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //A static method that creates and returns a BCryptPasswordEncoder. 
    //This is a common choice for password encoding in security configurations.

    @Bean
    public AuthenticationManager authenticationManager(
                                 AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    //A method that retrieves the authentication manager from the provided AuthenticationConfiguration. 
    //This method is often used to configure the authentication manager.

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        //authorize.anyRequest().authenticated()
                        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                                .requestMatchers("/api/auth/**").permitAll()
                                .anyRequest().authenticated()

                );
        //SecurityfilterChain securityFilterChain(HttpSecurity http) throws Exception: A method that configures 
        //the security filter chain using the provided HttpSecurity object.
        
//        http.csrf().disable(): Disables CSRF protection. CSRF (Cross-Site Request Forgery) is a 
        // security feature to prevent unauthorized requests.
//         
//        authorizeRequests((authorize)->: Begins the configuration for request authorization.
//         
//        authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll(): Allows unrestricted 
        //access to GET requests under "/api/".
//         
//        authorize.requestMatchers("/api/auth/**").permitAll(): Allows unrestricted access to requests under "/api/auth/".
//         
//        authorize.anyRequest().authenticated(): Requires authentication for any other request.
         
        return http.build();
        //Builds and returns the configured HttpSecurity object.

        //return http.build();
    }

}
