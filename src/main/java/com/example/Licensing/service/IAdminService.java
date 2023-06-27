package com.example.Licensing.service;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.dto.AdminDTO;
import com.example.Licensing.model.entitie.Admin;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public interface IAdminService {
    ResponseMessage<Admin> registerAdmin(Admin admin);

    ResponseMessage<Admin> loginAdmin(Admin admin);
}
