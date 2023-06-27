package com.example.Licensing.model.dto;

import com.example.Licensing.model.entitie.Admin;

import java.util.Date;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public class AdminDTO {
    private Long id;
    private String username;
    private Date registrationDate;

    public AdminDTO() {
    }

    public AdminDTO(Long id, String username, Date registrationDate) {
        this.id = id;
        this.username = username;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public AdminDTO(Admin admin){
        this.id = admin.getId();
        this.username = admin.getUsername();
        this.registrationDate = admin.getRegistrationDate();
    }

    public Admin toEntity(Admin admin) {
        admin.setId(this.id);
        admin.setUsername(this.username);
        admin.setRegistrationDate(this.registrationDate);
        return admin;
    }
}