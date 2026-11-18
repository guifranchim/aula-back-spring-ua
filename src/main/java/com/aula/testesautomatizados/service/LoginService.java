package com.aula.testesautomatizados.service;

import com.aula.testesautomatizados.controller.login.LoginRequest;
import com.aula.testesautomatizados.entity.UsuarioEntity;
import com.aula.testesautomatizados.infra.spring.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public String login(LoginRequest data){
        if(data == null || data.login() == null || data.senha() == null){
            throw new IllegalArgumentException("Login e senha nao podem ser vazios");
        }

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var usuario = (UsuarioEntity) authentication.getPrincipal();

        return jwtService.gerarToken(usuario);
    }

}
