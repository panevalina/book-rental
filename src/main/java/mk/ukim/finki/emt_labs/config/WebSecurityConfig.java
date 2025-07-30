//package mk.ukim.finki.emt_labs.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class WebSecurityConfig {
//
//    private final PasswordEncoder passwordEncoder;
//
//    public WebSecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .headers((headers) -> headers
//                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
//                )
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/api/books/add", "/api/books/mark-bad-condition/**", "/api/books/mark-rented/**")
//                        .hasRole("USER")
//                        .requestMatchers("/api/auth/login", "/api/auth/register")
//                        .permitAll()
//                        .anyRequest()
//                        .hasRole("LIBRARIAN")
//                )
//                .formLogin((form) -> form.loginProcessingUrl(
//                                "/api/user/login")
//                        .permitAll()
//                        .failureUrl("/api/user/login?error=BadCredentials")
//                        .defaultSuccessUrl(
//                                "/swagger-ui/index.html",
//                                true
//                        ))
//                .logout((logout) -> logout.logoutUrl("/api/user/logout")
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(
//                                true)
//                        .deleteCookies("JSESSIONID")
//                        .logoutSuccessUrl("/api/user/login"))
//                .exceptionHandling((ex) -> ex.accessDeniedPage(
//                        "/access_denied"));
//        return http.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        UserDetails librarian = User.builder()
////                .username("librarian")
////                .password(passwordEncoder.encode("lb"))
////                .roles("LIBRARIAN")
////                .build();
////
////        UserDetails user = User.builder()
////                .username("user")
////                .password(passwordEncoder.encode("user"))
////                .roles("USER")
////                .build();
////
////        UserDetails admin = User.builder()
////                .username("lp")
////                .password(passwordEncoder.encode("lp"))
////                .roles("ADMIN")
////                .build();
////
////        return new InMemoryUserDetailsManager(librarian, user, admin);
////    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//
//        return authenticationManagerBuilder.build();
//    }
//
//
//}
//
