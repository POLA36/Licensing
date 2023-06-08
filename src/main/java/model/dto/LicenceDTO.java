package model.dto;

import jakarta.persistence.FetchType;
import model.entitie.Admin;
import model.entitie.Licence;

import java.util.Date;

public class LicenceDTO {
    private Long id;
    private String licenceKey;
    private Date expirationDate;
    private Date genreratedDate;
    private Admin admin;

    public LicenceDTO() {
    }

    public LicenceDTO(Long id, String licenceKey, Date expirationDate, Date genreratedDate, Admin admin) {
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

    public static LicenceDTO fromEntity(Licence licence){
        return new LicenceDTO(licence.getId(), licence.getLicenceKey(), licence.getExpirationDate(), licence.getGenreratedDate(), licence.getAdmin());
    }

    public Licence toEntity() {
        Licence licence = new Licence();
        licence.setId(this.id);
        licence.setLicenceKey(this.licenceKey);
        licence.setExpirationDate(this.expirationDate);
        licence.setGenreratedDate(this.genreratedDate);
        licence.setAdmin(this.admin);
        return licence;
    }
}
