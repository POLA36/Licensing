package com.example.Licensing.service;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.License;

import java.util.List;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public interface ILicenseService {
    ResponseMessage<List<License>> getAllLicenses();
}
