package com.kd.jwt.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.kd.jwt.model.AuthenticationToken;
import com.kd.jwt.model.LoginUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private static final String SECURITY_KEY = "!@kumar1234";

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		AuthenticationToken authenticationToken = (AuthenticationToken)authentication;
		String token = authenticationToken.getToken();
		Claims claim = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
		return new LoginUserDetails(claim.getSubject(), token, Long.parseLong((String)claim.get("Id")), 
				AuthorityUtils.commaSeparatedStringToAuthorityList((String)claim.get("role")));
	}

}
