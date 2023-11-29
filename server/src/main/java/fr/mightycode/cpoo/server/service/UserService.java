package fr.mightycode.cpoo.server.service;


import fr.mightycode.cpoo.server.Manager.TimeWarpUser;
import fr.mightycode.cpoo.server.Manager.TimeWarpUserDetailsManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  private TimeWarpUserDetailsManager timeWarpUserDetailsManager;

  private final HttpServletRequest httpServletRequest;

  /***
   * @param username
   * @param email
   * @param password
   * @return 0 if Username already exists /
   *  1 if Email already exists /
   * 2 if it's OK
   */
  public int signup(final String username, final String email, final String password) {
    if (timeWarpUserDetailsManager.userExists(username))
      return 0;
    if (timeWarpUserDetailsManager.emailExists(email))
      return 1;
    final TimeWarpUser user = new TimeWarpUser(username,email, passwordEncoder.encode(password), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    timeWarpUserDetailsManager.createUser(user);
    
    return 2;
  }


  /***
   * @param login
   * @param password
   * @return  false if an user is already signin /
   * true if it's a success
   * @throws ServletException   if there are bad credentials
   */
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


  /***
   * @param username
   * @return
   * false if user doesn't exist /
   * true if it's a success
   */
  public boolean delete(String username) {
    if (!timeWarpUserDetailsManager.userExists(username))
      return false;
    timeWarpUserDetailsManager.deleteUser(username);
    return true;
  }


  /***
   * @param oldPwd
   * @param newPwd
   * @return
   * 0 if it's OK /
   * 1 User not logged in /
   * 2 if Incorrect Old Password
   * @throws ServletException
   */
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
