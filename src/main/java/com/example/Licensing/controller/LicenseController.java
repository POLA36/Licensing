package com.example.Licensing.controller;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.License;
import com.example.Licensing.service.ILicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.SocketException;
import java.util.List;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Controller
@RequestMapping(value = "/license")
public class LicenseController {
    private ILicenseService licenseService;
    @Autowired
    public LicenseController(ILicenseService licenseService){
        this.licenseService = licenseService;
    }

    @GetMapping("/getAllLicenses")
    public ResponseMessage<List<License>> fetchAndStore() throws SocketException {
        return licenseService.getAllLicenses();
    }
}
