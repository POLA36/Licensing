package com.example.Licensing.service;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.Admin;
import com.example.Licensing.repository.AdminRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Service
public class AdminServiceImpl implements IAdminService{
    /*bad ptatices
    * @Autowired
    * AdminRepo adminRepo
    * */

    //good practices
    private AdminRepo adminRepo;
    @Autowired
    public AdminServiceImpl(AdminRepo adminRepo){
        this.adminRepo = adminRepo;
    }

    @Override
    public ResponseMessage<Admin> registerAdmin(Admin admin) {
        ResponseMessage<Admin> response;
        String userName = admin.getUsername();
        String password = admin.getPassword();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        // Check if user already exists
        if (adminRepo.findAdminByUsername(userName) != null) {
            throw new IllegalArgumentException("Username already exists");
        }else {
            admin.setUsername("root");
            admin.setPassword("root00");
            admin.setRegistrationDate(new Date());
            adminRepo.save(admin);
            response = new ResponseMessage<Admin>(HttpStatus.OK,"User Register successfully", admin);
        }
        return response;
    }

    @Override
    public ResponseMessage<Admin> loginAdmin(Admin admin) {
        ResponseMessage<Admin> response;
        String userName = admin.getUsername();
        String password = admin.getPassword();
        admin = adminRepo.findByUsernameAndPassword(userName, password);
        if (admin != null && BCrypt.checkpw(password, admin.getPassword())) {
            response = new ResponseMessage<>(HttpStatus.OK,"User login successfully",admin);
        } else {
            response = new ResponseMessage<>(HttpStatus.BAD_REQUEST,"Wrong password or login",admin);
        }
        return response;
    }
}