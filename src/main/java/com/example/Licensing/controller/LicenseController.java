package com.example.Licensing.controller;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.License;
import com.example.Licensing.repository.LicenceRepo;
import com.example.Licensing.service.ILicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.util.List;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@RestController
@RequestMapping(value = "/license")
public class LicenseController {
    private ILicenseService licenseService;
    private LicenceRepo licenceRepo;
    @Autowired
    public LicenseController(ILicenseService licenseService, LicenceRepo licenceRepo){
        this.licenceRepo = licenceRepo;
        this.licenseService = licenseService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllLicenses")
    public ResponseMessage<List<License>> fetchAndStore() throws SocketException {
        return licenseService.getAllLicenses();
    }

    @GetMapping("/license-verification")
    public ResponseMessage<License> fetchLicence(License license) throws SocketException{
        String licenKey = license.getLicenceKey();
        licenceRepo.findByLicenceKey(licenKey);
        return new ResponseMessage<>(HttpStatus.OK, licenKey);
    }
}
