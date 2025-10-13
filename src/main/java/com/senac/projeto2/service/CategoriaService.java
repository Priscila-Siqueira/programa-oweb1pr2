package com.senac.projeto2.service;

import com.senac.projeto2.dto.request.CategoriaDtoRequest;
import com.senac.projeto2.dto.request.CategoriaDtoRequestUpdate;
import com.senac.projeto2.dto.response.CategoriaDtoResponse;
import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.entity.Usuario;
import com.senac.projeto2.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CategoriaService {
    
    @Autowired
    private ModelMapper modelMapper;
    
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarCategorias(){
        return this.categoriaRepository.listarCategoriasAtivas();
    }

    public Categoria listarCategoriaPorId(int idCategoria){
        return this.categoriaRepository.obterCategoriaAtivaPorId(idCategoria);
    }
    
    public CategoriaDtoResponse salvar(CategoriaDtoRequest categoriaDtoRequest){
        Categoria categoria = modelMapper.map(categoriaDtoRequest, Categoria.class);
        categoria.setStatus(1);
        
        Categoria categoriaSalva = this.categoriaRepository.save(categoria);
        
        return modelMapper.map(categoriaSalva, CategoriaDtoResponse.class);
    }

    public CategoriaDtoResponse atualizar(Integer idCategoria, CategoriaDtoRequestUpdate categoriaDtoRequestUpdate) {
        Categoria categoria = this.listarCategoriaPorId(idCategoria);
        if (categoria != null){
            modelMapper.map(categoriaDtoRequestUpdate, categoria);
            Categoria categoriaTemp = this.categoriaRepository.save(categoria);

            return modelMapper.map(categoriaTemp, CategoriaDtoResponse.class);
        }else{
            return null;
        }
    }
    
    
    public void apagar(Integer idCategoria){
        Categoria categoria = listarCategoriaPorId(idCategoria);
        if (categoria != null) {
            this.categoriaRepository.apagadorLogico(idCategoria);
        }else{
            System.out.println("Id não existe no banco de dados.");
        }
    }


}
