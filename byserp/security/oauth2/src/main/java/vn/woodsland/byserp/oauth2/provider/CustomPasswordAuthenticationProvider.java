package vn.woodsland.byserp.oauth2.provider;


import vn.woodsland.byserp.oauth2.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomPasswordAuthenticationProvider extends AbstractPasswordAuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;

	protected CustomPasswordAuthenticationProvider(LoginInfoService service) {
		super(service);
		
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		if (authentication.getCredentials() == null) {
			this.logger.debug("Authentication failed: no credentials provided");
			throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
		} else {
			String presentedPassword = authentication.getCredentials().toString();
			if (!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
				this.logger.debug("Authentication failed: password does not match stored value");
				throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
			}
		}
	}

	@Override
	protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		return this.findUserDetail(s);
	}
}
