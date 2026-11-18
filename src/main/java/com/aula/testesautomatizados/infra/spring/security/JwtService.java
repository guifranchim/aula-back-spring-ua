package com.aula.testesautomatizados.infra.spring.security;

import com.aula.testesautomatizados.entity.UsuarioEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtService {
    private final Algorithm algorithm;
    private final String issuer;

    public JwtService(
            @Value("${api.security.token.secret:minha-secret-default}") String secret,
            @Value("${api.security.token.issuer:loja-do-medonza}") String issuer) {
        this.algorithm = Algorithm.HMAC256(secret);
        this.issuer = issuer;
    }

    public String gerarToken(UsuarioEntity usuario){
        try {
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withClaim("role", usuario.getRole())
                    .withExpiresAt(Instant.now().plus(8, ChronoUnit.HOURS))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new IllegalStateException("erro ao gerar o token JWT");
        }
    }

    public String validarToken(String token){
        try {
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {
            throw new IllegalStateException("erro ao validar o token JWT");
        }
    }


}
