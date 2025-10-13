package com.senac.projeto2.repository;

import com.senac.projeto2.entity.Categoria;
import com.senac.projeto2.entity.Inscricao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Integer> {

    @Query("SELECT i FROM Inscricao i WHERE i.status >=0")
    List<Inscricao> listarInscricoesAtivas();

    @Query("SELECT i FROM Inscricao i WHERE i.id = :id AND i.status >=0")
    Inscricao obterInscricaoAtivaPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Inscricao i SET i.status = -1 WHERE i.id = :id")
    int apagadorLogico(@Param("id") int id);
}
