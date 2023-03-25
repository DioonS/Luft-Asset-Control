package com.web.luft.SpringWeb.repository;

import com.web.luft.SpringWeb.models.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ColaboradoresRepo extends JpaRepository<Colaborador, Integer> {

    //@Query(value = "select count(a) >  from Colaboradores a WHERE a.id = :id")
    boolean existsById(Integer id);

    // Consulta JPQL para maior portabilidade e segurança
    /*@Query(value = "select CASE WHEN count(a) > 0 THEN 'true' ELSE 'false' END  from Colaboradores a WHERE a.id = :id")
    boolean existsById(int id);*/

    /*@Query(value = "SELECT a FROM Colaboradores a WHERE a.email = :email AND a.senha = :senha")
    boolean existsByEmail(String email);

    @Query(value = "SELECT a FROM Colaboradores a WHERE a.email = :email AND a.senha = :senha")
    Colaboradores findByEmailAndSenha(String email, String senha);

    default Colaboradores login(String email, String senha) {
        return findByEmailAndSenha(email, senha);
    }*/

    //Colaborador findByEmail(String email);

    //@Query(value="select * from administradores where email like %:email% or senha like %:senha% ", nativeQuery = true)
    //public ArrayList<Administrador> findAllByNomeEmail(@Param("email") String email, @Param("senha") String senha);

    //@Query(value="select * from administradores where email = :email and senha = :senha", nativeQuery = true)
    //public ArrayList<Administrador> findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
