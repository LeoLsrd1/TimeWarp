package fr.mightycode.cpoo.server.service;


import fr.mightycode.cpoo.server.Manager.TimeWarpUser;
import fr.mightycode.cpoo.server.Manager.TimeWarpUserDetailsManager;
import fr.mightycode.cpoo.server.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserService {

  private final PasswordEncoder passwordEncoder;

  //private final UserDetailsManager userDetailsManager;
  @Autowired
  private TimeWarpUserDetailsManager timeWarpUserDetailsManager;

  private final HttpServletRequest httpServletRequest;
  private final Map<String, String> listEmails = new HashMap<String, String>();
  //private final Map<String, Boolean> listOfConnect = new HashMap<String, Boolean>();


  /***
   * 0 if Username already exists
   * 1 if Email already exists
   * 2 if it's OK7
   ***/
  public int signup(final String username, final String email, final String password) {
    if (timeWarpUserDetailsManager.userExists(username))
      return 0;
    if (timeWarpUserDetailsManager.emailExists(email))
      return 1;
    final TimeWarpUser user = new TimeWarpUser(username,email, passwordEncoder.encode(password), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    timeWarpUserDetailsManager.createUser(user);
    return 2;
  }


  public boolean signin(final String login, final String password) throws ServletException {
    final HttpSession session = httpServletRequest.getSession(false);
    if (session != null)
      return false;
    httpServletRequest.login(login, password);
    httpServletRequest.getSession(true);
    return true;
  }


  public void signout() throws ServletException {
    httpServletRequest.logout();
  }



  public boolean delete(String username) {
    if (!timeWarpUserDetailsManager.userExists(username))
      return false;
    timeWarpUserDetailsManager.deleteUser(username);
    listEmails.remove(username);
    return true;
  }

  /***
   * 0 if it's OK
   * 1 User not logged in
   * 2 if Incorrect Old Password
   ***/
  public int changePwd(String oldPwd, String newPwd) throws ServletException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null || !(authentication instanceof UsernamePasswordAuthenticationToken)) {
      return 1; // User not logged in
    }

    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
    UserDetails userDetails = (UserDetails) token.getPrincipal();
    String username = userDetails.getUsername();
    UserDetails storedUserDetails = timeWarpUserDetailsManager.loadUserByUsername(username); // Get User details thanks to userDetailsManager

    if (!(passwordEncoder.matches(oldPwd, storedUserDetails.getPassword()))) {
      return 2; // Incorrect old password
    }

    timeWarpUserDetailsManager.changePassword(passwordEncoder.encode(oldPwd), passwordEncoder.encode(newPwd));

    UserDetails updatedUser = new User(username, passwordEncoder.encode(newPwd), userDetails.getAuthorities());
    UsernamePasswordAuthenticationToken updatedToken = new UsernamePasswordAuthenticationToken(updatedUser, token.getCredentials(), updatedUser.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(updatedToken);

    return 0; // Password change is a success
  }


}
