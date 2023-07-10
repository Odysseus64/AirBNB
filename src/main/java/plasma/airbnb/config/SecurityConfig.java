package plasma.airbnb.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import plasma.airbnb.config.jwt.TokenVerifierFilter;
import plasma.airbnb.reposiroty.UserRepository;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenVerifierFilter tokenVerifierFilter;

    @Bean
    AuthenticationProvider authenticationProvider(UserRepository userRepository) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService((email) -> (UserDetails) userRepository.findByEmail( email ).orElseThrow(() ->
                new RuntimeException( "User with email: " + email + " not found!" ) ) );
        provider.setPasswordEncoder( passwordEncoder() );
        return provider;
    }

    @Bean
    SecurityFilterChain authorization(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests(auth -> auth
                        .antMatchers("/swagger", "/swagger-ui/index.html", "/**").permitAll() // Разрешаем только админу
                        .antMatchers(
                                "/api/product/save",
                                "/api/product/edit/**",
                                "/api/product/delete/**").hasAnyRole("USER", "ADMIN")
                        .antMatchers(
                                "api/v1/feedback/save/feedback",
                                "/api/v1/feedback/delete/FeedBack/**",
                                "/api/v1/feedback/update/feedback/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest()
    /*
        Когда тестируете не забудьте тестировать приложение на уязвимость IDOR (Можете по гуглить)
        проблемы у нас с модерацие я хз знаю почему мне это дали
    */
                        .permitAll())
                .sessionManagement()
                .sessionCreationPolicy( SessionCreationPolicy.STATELESS );
        http.addFilterBefore(tokenVerifierFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    // Также это написал он bekbolsun
    /*@Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http
                .cors()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();
        return http.build();
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}