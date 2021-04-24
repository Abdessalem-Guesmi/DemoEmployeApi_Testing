package com.abdou.security;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.securityContext;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {

		
		resp.addHeader("Access-Control-Allow-Origin", "*");
		resp.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, "
				+ "Access-Control-Request-Method,"
				+ "Access-Control-Request-Headers, authorization");
		resp.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, "
				+ "Access-Control-Allow-Credentials, authorization");
		String jwt = req.getHeader(SecurityConstant.HEADER_STRING);
		System.out.println(jwt);
		if(req.getMethod().equals("OPTIONS")){
			resp.setStatus(HttpServletResponse.SC_OK);
		}
		else{
			
		
		if(jwt==null || !jwt.startsWith(SecurityConstant.TOKEN_PREFIX)){
			chain.doFilter(req, resp);
			return;
		}
		Claims claims= Jwts.parser()
				.setSigningKey(SecurityConstant.SECRET)
				.parseClaimsJws(jwt.replace(SecurityConstant.TOKEN_PREFIX, ""))
				.getBody();
		String username=claims.getSubject();
		ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		roles.forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.get("authority")));
				
 		});
     UsernamePasswordAuthenticationToken authenticateduser = 
    		 new UsernamePasswordAuthenticationToken(username,null, authorities);
     SecurityContextHolder.getContext().setAuthentication(authenticateduser);
     chain.doFilter(req, resp);
		
	}
	}
}
