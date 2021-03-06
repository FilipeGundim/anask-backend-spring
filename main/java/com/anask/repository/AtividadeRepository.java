package com.anask.repository;

import com.anask.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

    @Query(value = "select * from tbl_usuario_atividade where id_usuario = :id and status = 1", nativeQuery = true)
    public List<Atividade> getByUserId(@Param("id") int id);


    @Query(value = "select * from tbl_usuario_atividade where id_usuario = :id", nativeQuery = true)
    public List<Atividade> getHistorico(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_usuario_atividade SET status = 0 WHERE id_atividade = :id", nativeQuery = true)
    public void deleteAtividade(@Param("id") int id);
}
