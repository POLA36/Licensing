package com.example.Licensing.controller;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.Admin;
import com.example.Licensing.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private IAdminService adminService;
    @Autowired
    public AdminController(IAdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseMessage<Admin> registerAdmin(@RequestBody Admin admin) {
        ResponseMessage<Admin> response = adminService.registerAdmin(admin);
        return response;
    }

    @PostMapping("/login")
    public ResponseMessage<Admin> loginAdmin(@RequestBody Admin admin){
        ResponseMessage<Admin> response = adminService.loginAdmin(admin);
        return response;
    }
}
