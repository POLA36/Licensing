package com.example.Licensing.repository;

import com.example.Licensing.model.entitie.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    @Query("SELECT a FROM Admin a WHERE a.username =: username AND a.password =: passowrd")
    Admin findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    Admin findAdminByUsername(String username);
}
