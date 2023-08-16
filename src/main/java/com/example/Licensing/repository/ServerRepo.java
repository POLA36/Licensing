package com.example.Licensing.repository;

import com.example.Licensing.model.entitie.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Repository
public interface ServerRepo extends JpaRepository<Server, Long> {
    Server findByMacAdresse(String macAdresse);
}
