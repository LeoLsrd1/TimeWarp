package fr.mightycode.cpoo.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .authorizeHttpRequests(authorizeRequests ->
        authorizeRequests
          .requestMatchers(new AntPathRequestMatcher("/user/signup")).permitAll()
          .requestMatchers(new AntPathRequestMatcher("/user/signin")).permitAll()
          .requestMatchers("/error").permitAll()
          .anyRequest().authenticated())
      .csrf(AbstractHttpConfigurer::disable)
      .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
    UserDetails user = User.withUsername("user")
      .password(passwordEncoder.encode("user"))
      .roles("USER")
      .build();
    UserDetails admin = User.withUsername("admin")
      .password(passwordEncoder.encode("admin"))
      .roles("USER", "ADMIN")
      .build();
    return new InMemoryUserDetailsManager(user, admin);
  }
}
