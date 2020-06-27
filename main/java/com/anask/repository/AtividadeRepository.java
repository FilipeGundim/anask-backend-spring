package com.anask.repository;

import com.anask.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

    @Query(value = "select * from tbl_usuario_atividade where id_usuario = :id and status = 1", nativeQuery = true)
    public List<Atividade> getByUserId(@Param("id") int id);
}
