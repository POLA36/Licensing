package model.dto;

import model.entitie.Admin;

public class AdminDTO {
    private Long id;
    private String username;
    private String registrationDate;

    public AdminDTO() {
    }

    public AdminDTO(Long id, String username, String registrationDate) {
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

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static AdminDTO fromEntity(Admin admin) {
        return new AdminDTO(admin.getId(), admin.getUsername(), admin.getRegistrationDate());
    }

    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(this.id);
        admin.setUsername(this.username);
        admin.setRegistrationDate(this.registrationDate);
        return admin;
    }
}