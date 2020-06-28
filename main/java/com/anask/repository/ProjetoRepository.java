package com.anask.repository;

import com.anask.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Query(value = "Select * from tbl_projeto where titulo like %:filter% and status = 1", nativeQuery = true)
    public List<Projeto> getAllByFilter(@Param("filter") String filter);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tbl_projeto_usuario VALUES(:user, :project)", nativeQuery = true)
    public void ingressarProjeto(@Param("user") int user, @Param("project") int project);

    @Query(value = "Select * from tbl_projeto where id_usuario= :user and status = 1", nativeQuery = true)
    public List<Projeto> getAllByUserId(@Param("user") int user);

}

