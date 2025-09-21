package com.billing.core.controller;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final String SECRET = "mySecretKeyForJWTTokenGenerationTesting123456789";

    @PostMapping("/token")
    public TokenResponse generateToken(@RequestParam("tenantId") UUID tenantId) {
        try {
            JWSSigner signer = new MACSigner(SECRET);

            JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .claim("tenantId", tenantId.toString())
                .issueTime(new Date())
                .expirationTime(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1 hour
                .build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);

            return new TokenResponse(signedJWT.serialize());
        } catch (Exception e) {
            throw new RuntimeException("Token generation failed", e);
        }
    }

    public static class TokenResponse {
        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}