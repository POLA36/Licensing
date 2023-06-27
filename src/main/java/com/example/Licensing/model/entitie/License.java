package com.example.Licensing.model.entitie;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Entity
@Table(name = "Licence")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String licenceKey;
    private Date expirationDate;
    private Date genreratedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License licence = (License) o;
        return Objects.equals(id, licence.id) && Objects.equals(licenceKey, licence.licenceKey) && Objects.equals(expirationDate, licence.expirationDate) && Objects.equals(genreratedDate, licence.genreratedDate) && Objects.equals(admin, licence.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licenceKey, expirationDate, genreratedDate, admin);
    }

    @Override
    public String toString() {
        return "Licence{" +
                "id=" + id +
                ", licenceKey='" + licenceKey + '\'' +
                ", expirationDate=" + expirationDate +
                ", genreratedDate=" + genreratedDate +
                ", admin=" + admin +
                '}';
    }
}
