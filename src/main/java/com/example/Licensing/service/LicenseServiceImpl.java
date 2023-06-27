package com.example.Licensing.service;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.License;
import com.example.Licensing.repository.LicenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Service
public class LicenseServiceImpl implements ILicenseService {
    private LicenceRepo licenceRepo;
    @Autowired
    public LicenseServiceImpl(LicenceRepo licenceRepo){
        this.licenceRepo = licenceRepo;
    }

    @Override
    public ResponseMessage<List<License>> getAllLicenses() {
        List<License> licenses = licenceRepo.findAll();
        ResponseMessage<List<License>> response = new ResponseMessage<>();
        response.setData(licenses);
        response.setMessage("Licenses retrieved successfully.");
        return response;
    }
}
