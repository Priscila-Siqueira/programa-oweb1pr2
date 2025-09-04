package com.senac.projeto2.service;

import com.senac.projeto2.dto.request.UsuarioDtoRequest;
import com.senac.projeto2.dto.response.UsuarioDtoResponse;
import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private ModelMapper modelMapper;

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
        //Preciso passar os valores do objeto usuarioDto para o usuario
        Usuario usuario = modelMapper.map(usuarioDtoRequest, Usuario.class);
        usuario.setStatus(1);

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
}
