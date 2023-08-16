package com.example.Licensing.repository;

import com.example.Licensing.model.entitie.Admin;
import com.example.Licensing.model.entitie.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Repository
public interface LicenceRepo extends JpaRepository<License, Long> {
    License findByLicenceKey(String licenseKey);
}
