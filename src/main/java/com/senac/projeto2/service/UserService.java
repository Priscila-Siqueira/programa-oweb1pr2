package com.senac.projeto2.service;

import com.senac.projeto2.config.SecurityConfiguration;
import com.senac.projeto2.dto.CreateUserDto;
import com.senac.projeto2.dto.request.LoginUserDto;
import com.senac.projeto2.dto.response.RecoveryJwtTokenDto;
import com.senac.projeto2.entity.Role;
import com.senac.projeto2.entity.User;
import com.senac.projeto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    // Método responsável por autenticar um usuário e retornar um token JWT
    public RecoveryJwtTokenDto authenticateUser(LoginUserDto loginUserDto) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.login(), loginUserDto.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new RecoveryJwtTokenDto(jwtTokenService.generateToken(userDetails));
    }

    // Método responsável por criar um usuário
    public void createUser(CreateUserDto createUserDto) {
        Role role = new Role();
        role.setName(createUserDto.role());

        User newUser = new User();
        newUser.setNome(createUserDto.nome());
        newUser.setCpf(createUserDto.cpf());
        newUser.setDataNascimento(createUserDto.dataNascimento());
        newUser.setEmail(createUserDto.email());
        newUser.setPassword(securityConfiguration.passwordEncoder().encode(createUserDto.password()));
        newUser.setStatus(1);

        newUser.setRoles(List.of(role));

        // Salva o novo usuário no banco de dados
        userRepository.save(newUser);
    }
}

