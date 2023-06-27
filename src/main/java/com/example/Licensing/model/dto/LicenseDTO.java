package com.example.Licensing.model.dto;

import com.example.Licensing.model.entitie.Admin;
import com.example.Licensing.model.entitie.License;

import java.util.Date;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public class LicenseDTO {
    private Long id;
    private String licenceKey;
    private Date expirationDate;
    private Date genreratedDate;
    private Admin admin;

    public LicenseDTO() {
    }

    public LicenseDTO(Long id, String licenceKey, Date expirationDate, Date genreratedDate, Admin admin) {
        this.id = id;
        this.licenceKey = licenceKey;
        this.expirationDate = expirationDate;
        this.genreratedDate = genreratedDate;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getGenreratedDate() {
        return genreratedDate;
    }

    public void setGenreratedDate(Date genreratedDate) {
        this.genreratedDate = genreratedDate;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public static LicenseDTO fromEntity(License licence){
        return new LicenseDTO(licence.getId(), licence.getLicenceKey(), licence.getExpirationDate(), licence.getGenreratedDate(), licence.getAdmin());
    }
    public LicenseDTO(License licence){
        this.id = licence.getId();
        this.licenceKey = licence.getLicenceKey();
        this.expirationDate = licence.getExpirationDate();
        this.genreratedDate = licence.getGenreratedDate();
    }

    public License toEntity(License licence) {
        licence.setId(this.id);
        licence.setLicenceKey(this.licenceKey);
        licence.setExpirationDate(this.expirationDate);
        licence.setGenreratedDate(this.genreratedDate);
        licence.setAdmin(this.admin);
        return licence;
    }
}
