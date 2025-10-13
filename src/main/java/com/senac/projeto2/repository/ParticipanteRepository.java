package com.senac.projeto2.repository;

import com.senac.projeto2.entity.Inscricao;
import com.senac.projeto2.entity.Participante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {
    @Query("SELECT p FROM Participante p WHERE p.status >=0")
    List<Participante> listarParticipantesAtivos();

    @Query("SELECT p FROM Participante p WHERE p.id = :id AND p.status >=0")
    Participante obterParticipanteAtivoPorId(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Participante p SET p.status = -1 WHERE p.id = :id")
    int apagadorLogico(@Param("id") int id);
}
