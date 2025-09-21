package com.billing.core.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import com.nimbusds.jwt.SignedJWT;

public class JwtAuthFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String auth = request.getHeader("Authorization");
    if(auth != null && auth.startsWith("Bearer ")){
      String token = auth.substring(7);
      try{
        SignedJWT jwt = SignedJWT.parse(token);
        Object claim = jwt.getJWTClaimsSet().getClaim("tenantId");
        if(claim!=null){
          TenantContext.setCurrentTenant(java.util.UUID.fromString(claim.toString()));
        }
      }catch(Exception e){ }
    }
    try{ filterChain.doFilter(request, response);} finally { TenantContext.clear(); }
  }
}
