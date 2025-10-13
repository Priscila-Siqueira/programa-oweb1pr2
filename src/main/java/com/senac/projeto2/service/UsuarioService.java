package com.senac.projeto2.service;

import com.senac.projeto2.config.SecurityConfiguration;
import com.senac.projeto2.dto.CreateUserDto;
import com.senac.projeto2.dto.request.LoginUserDto;
import com.senac.projeto2.dto.response.RecoveryJwtTokenDto;
import com.senac.projeto2.dto.request.UsuarioDtoRequest;
import com.senac.projeto2.dto.response.UsuarioDtoResponse;
import com.senac.projeto2.entity.Role;
import com.senac.projeto2.entity.RoleName;
import com.senac.projeto2.entity.User;
import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.repository.RoleRepository;
import com.senac.projeto2.repository.UserRepository;
import com.senac.projeto2.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    @Autowired
    private RoleRepository roleRepository;



    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return this.usuarioRepository.listarUsuariosAtivos();
    }

    public Usuario listarUsuarioPorId(Integer idUsuario){
        return this.usuarioRepository.obterUsuarioAtivoPorId(idUsuario);
    }

    public UsuarioDtoResponse salvar(UsuarioDtoRequest usuarioDtoRequest){
        final String ROLE_PADRAO = "ROLE_CUSTOMER";


        Role role = roleRepository.findByName(RoleName.valueOf(ROLE_PADRAO))
                .orElseThrow(() -> new RuntimeException("Role '" + ROLE_PADRAO + "' não encontrada"));

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDtoRequest.getNome());
        usuario.setCpf(usuarioDtoRequest.getCpf());
        usuario.setEmail(usuarioDtoRequest.getLogin());
        usuario.setSenha(securityConfiguration.passwordEncoder().encode(usuarioDtoRequest.getSenha()));
        usuario.setDataNascimento(usuarioDtoRequest.getDataNascimento());
        usuario.setStatus(1);


        usuario.setRoles(List.of(role));


        Usuario usuarioSalvo = this.usuarioRepository.save(usuario);

        return modelMapper.map(usuarioSalvo, UsuarioDtoResponse.class);
    }

    public UsuarioDtoResponse atualizar(Integer idUsuario, UsuarioDtoRequest usuarioDtoRequest){
        Usuario usuario = this.listarUsuarioPorId(idUsuario);
        if (usuario != null){
            modelMapper.map(usuarioDtoRequest, usuario);
            Usuario usuarioTemp = this.usuarioRepository.save(usuario);

            return modelMapper.map(usuarioTemp,UsuarioDtoResponse.class);
        }else{
            return null;
        }

    }


    public void apagar(Integer idUsuario){
        Usuario usuario = listarUsuarioPorId(idUsuario);
        if (usuario != null) {
            this.usuarioRepository.apagadorLogico(idUsuario);
        }else{
            System.out.println("Id não existe no banco de dados.");
        }
    }

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
