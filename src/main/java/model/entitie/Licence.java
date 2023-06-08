package model.entitie;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
public class Licence {
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        Licence licence = (Licence) o;
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
