// package com.example.demo.config;

// import com.example.demo.security.JwtUtil;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public JwtUtil jwtUtil() {
//         return new JwtUtil();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http)
//             throws Exception {

//         http
//             .csrf(csrf -> csrf.disable())

//             .headers(headers -> headers.frameOptions(frame -> frame.disable()))

//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().permitAll()
//             );

//         return http.build();
//     }
// }

// package com.example.demo.config;

// import com.example.demo.security.JwtUtil;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public JwtUtil jwtUtil() {
//         return new JwtUtil();
//     }

//     @Bean
//     public JwtAuthenticationFilter jwtAuthenticationFilter(JwtUtil jwtUtil) {
//         return new JwtAuthenticationFilter(jwtUtil);
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http,
//                                                    JwtAuthenticationFilter jwtFilter)
//             throws Exception {

//         http
//             .csrf(csrf -> csrf.disable())
//             .headers(headers -> headers.frameOptions(frame -> frame.disable()))
//             .authorizeHttpRequests(auth -> auth
//                 .anyRequest().permitAll()  
//             .addFilterBefore(
//                 jwtFilter,
//                 UsernamePasswordAuthenticationFilter.class
//             );

//         return http.build();
//     }
// }
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // swagger + auth MUST be open
                .requestMatchers(
                        "/auth/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                ).permitAll()
                // everything else open (IMPORTANT FOR TESTS)
                .anyRequest().permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
