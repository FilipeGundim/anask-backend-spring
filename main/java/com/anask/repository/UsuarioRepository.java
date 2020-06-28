package com.anask.repository;

import com.anask.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select * from tbl_usuario where email = :email and senha= :senha", nativeQuery = true)
    public Usuario getUser(@Param("email") String email, @Param("senha") String senha);
}
